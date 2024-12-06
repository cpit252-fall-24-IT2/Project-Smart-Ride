package org.example.Strategy;

import java.util.Scanner;

public class UserChoice {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Scanner scanner) {
        if (strategy != null) {
            strategy.execute(scanner);
        }
    }
}