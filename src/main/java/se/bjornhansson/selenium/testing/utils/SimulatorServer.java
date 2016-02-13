package se.bjornhansson.selenium.testing.utils;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

import com.github.tomakehurst.wiremock.WireMockServer;

/**
 * Simulator to mock and stub requests
 */
public class SimulatorServer {
    private WireMockServer myWireMockServer;

    public SimulatorServer(int port) {
        myWireMockServer = new WireMockServer(wireMockConfig().port(port));
    }

    public void start() {
        myWireMockServer.start();
    }

    public void stop() {
        myWireMockServer.stop();
    }

    public int getPort() {
        return myWireMockServer.port();
    }
}
