package se.bjornhansson.selenium.testing.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.bjornhansson.selenium.testing.utils.SimulatorServer;

public class SimulatorServerTest {

    @Test
    public void testThatSimulatorServerCanBeStarted() {
        SimulatorServer simulator = new SimulatorServer(1337);
        simulator.start();
        assertEquals("Simulator should be started at given port", 1337, simulator.getPort());
        simulator.stop();
    }
}
