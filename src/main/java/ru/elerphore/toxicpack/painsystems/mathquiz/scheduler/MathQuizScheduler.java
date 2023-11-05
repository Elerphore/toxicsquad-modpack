package ru.elerphore.toxicpack.painsystems.mathquiz.scheduler;

import ru.elerphore.toxicpack.painsystems.mathquiz.MathQuiz;
import ru.elerphore.toxicpack.painsystems.mathquiz.MathQuizTask;

import java.util.TimerTask;

public class MathQuizScheduler extends TimerTask {

    public MathQuizScheduler() { }


    @Override
    public void run() {
        try {
            execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void execute() {
        var mathQuiz = MathQuiz.getInstance();
        mathQuiz.addNewQuiz(new MathQuizTask());
    }
}
