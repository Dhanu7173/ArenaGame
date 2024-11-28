package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testGameFlow() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        Game game = new Game(playerA, playerB);
        game.start();

        assertTrue(playerA.isAlive() != playerB.isAlive());
    }
}
