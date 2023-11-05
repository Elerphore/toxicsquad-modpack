package ru.elerphore.toxicpack.painsystems.mathquiz;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static ru.elerphore.toxicpack.ToxicMod.factoryReceiver;

public class MathQuiz {

    private final List<ServerPlayer> players = new ArrayList<>();
    private final HashMap<ServerPlayer, Boolean> playersPlayerWithMathQuiz = new HashMap<>();
    private static MathQuiz mathQuiz;
    private static MathQuizTask currentQuiz;

    public static synchronized MathQuiz getInstance() {
        if(mathQuiz == null) mathQuiz = new MathQuiz();

        return mathQuiz;
    }

    public void addNewQuiz(MathQuizTask mathQuizTask) {
        currentQuiz = mathQuizTask;

        try {
            startNewQuiz();
        } catch (InterruptedException e) {
            currentQuiz = null;
            e.printStackTrace();
        }

    }

    public void startNewQuiz() throws InterruptedException {

        players.forEach(player -> playersPlayerWithMathQuiz.put(player, null));

        var currentTime = System.currentTimeMillis();

        do {
            playersPlayerWithMathQuiz.forEach((player, result) -> {
                if(result == null) {
                    player.sendSystemMessage(Component.literal("У тебя математика, не забывай"));
                    player.sendSystemMessage(
                            Component.literal(currentQuiz.first + String.valueOf(currentQuiz.sign) + currentQuiz.second)
                    );
                }
            });

            Thread.sleep(1000);
        } while (System.currentTimeMillis() - currentTime < 10000L);

        finishMathQuizTaskConsideringPlayersAnswers();

    }

    synchronized public void playerAnswered(ServerPlayer player, Float playerAnswer) {
        if(currentQuiz == null) return;
        if(playersPlayerWithMathQuiz.containsKey(player) && playersPlayerWithMathQuiz.get(player) != null) return;

        var playerResult = playerAnswer.equals(currentQuiz.result);

        if(playerResult) {
            player.sendSystemMessage(Component.literal("Молодец, ты решил легчайшую задачу."));
        } else {
            player.sendSystemMessage(Component.literal("Ты мудак? Страдай."));
        }

        playersPlayerWithMathQuiz.put(player, playerResult);
    }

    public void addPlayer(ServerPlayer player) {
        players.add(player);
    }

    synchronized public boolean isMathQuizCurrentlyActive() {
        return currentQuiz != null;
    }

    public void removePlayer(ServerPlayer player) {
        players.remove(player);
    }

    synchronized public void addPlayerToTheListWhoDidNotAnswer(ServerPlayer player) {
        player.sendSystemMessage(Component.literal("Ты мудак? Страдай."));
        playersPlayerWithMathQuiz.put(player, false);
    }

    synchronized public void finishMathQuizTaskConsideringPlayersAnswers() {
        currentQuiz = null;

        playersPlayerWithMathQuiz.forEach((player, result) -> {
            if(result == null || !result) {
                player.sendSystemMessage(Component.literal("Страдай мудак"));
                factoryReceiver.getCreeperMobFactory().mobSpawn(player, 7);
            }
        });

        playersPlayerWithMathQuiz.clear();
    }


}
