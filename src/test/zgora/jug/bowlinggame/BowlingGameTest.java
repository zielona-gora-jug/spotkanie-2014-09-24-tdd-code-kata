package test.zgora.jug.bowlinggame;

import org.junit.Before;
import org.junit.Test;
import pl.zgora.jug.bowlinggame.Game;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private Game g;

    @Before
    public void setUp() throws Exception {
        g = new Game();
    }

    @Test

    public void gutterGame() {
        rollMany(20, 0);
        assertEquals(0, g.countScore());
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);
        assertEquals(20, g.countScore());
    }

    @Test
    public void oneSpare() {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertEquals(16, g.countScore());
    }

    @Test
    public void oneStrike() {
        rollStrike();
        g.roll(4);
        g.roll(3);
        assertEquals(24, g.countScore());
    }

    @Test
    public void perfectGame() {
        rollMany(12, 10);
        assertEquals(300, g.countScore());
    }

    @Test
    public void testScoreLoop() {
        g.roll(2);
        g.roll(3);
        g.roll(4);
        rollMany(17, 0);
        assertEquals(9, g.countScore());
    }

    private void rollStrike() {
        g.roll(10);
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }
    private void rollMany(int howMany, int pins) {
        for (int i = 0; i < howMany; i++) {
            g.roll(pins);
        }
    }
}
