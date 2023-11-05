package ru.elerphore.toxicpack.painsystems.mathquiz;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MathQuizTask {

    public final Float first, second, result;
    public final Character sign;

    private final List<Character> signs = Arrays.asList('+', '-', '/', '*');

    public MathQuizTask() {
        Random random = new Random();
        this.first = (float) (random.nextInt(100 - 1) + 1);
        this.second = (float) (random.nextInt(100 - 1) + 1);
        this.sign = signs.get(random.nextInt(signs.size()));


        this.result = switch (this.sign) {
                        case '+' -> first + second;
                        case '-' -> first - second;
                        case '/' -> first / second;
                        case '*' -> first * second;
                        default -> 0f;
        };
    }

}
