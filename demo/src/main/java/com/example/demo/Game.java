package com.example.demo;

import java.util.Random;

public class Game {
    private Player playerA;
    private Player playerB;
    private Random random;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.random = new Random();
    }

    public void start() {
        while (playerA.isAlive() && playerB.isAlive()) {
            Player attacker = playerA.getHealth() <= playerB.getHealth() ? playerA : playerB;
            Player defender = attacker == playerA ? playerB : playerA;
            
            takeTurn(attacker, defender);
        }

        System.out.println("Game Over!");
        System.out.println(playerA.isAlive() ? "Player A wins!" : "Player B wins!");
    }

    private void takeTurn(Player attacker, Player defender) {
        int attackRoll = rollDie();
        int defendRoll = rollDie();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defendDamage = defender.getStrength() * defendRoll;

        int damage = Math.max(0, attackDamage - defendDamage);
        defender.takeDamage(damage);

        System.out.println("Attacker rolls " + attackRoll + " for attack: " + attackDamage);
        System.out.println("Defender rolls " + defendRoll + " for defense: " + defendDamage);
        System.out.println("Defender takes " + damage + " damage, health now " + defender.getHealth());
    }

    private int rollDie() {
        return random.nextInt(6) + 1;
    }
}
