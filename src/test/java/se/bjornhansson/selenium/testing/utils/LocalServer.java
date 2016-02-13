package se.bjornhansson.selenium.testing.utils;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Local server that can be used to serve local web pages during tests
 */
public class LocalServer {
    private int myPort = 0;
    private Server myServer;
    private String myPageDir;

    public LocalServer() {
    }

    /**
     * Starts the server. Use random port as default
     * 
     * @throws Exception
     */
    public void start() throws Exception {
        myServer = new Server(myPort);
        // Do not actually need to be a WAR. Can place normal HTML in webapp
        WebAppContext context = new WebAppContext();
        context.setResourceBase(myPageDir);
        // Specify the context path that you want this webapp to show up as
        context.setContextPath("/");
        // Tell the classloader to use the "server" classpath over the webapp classpath. (this is so that jars and libs in your server classpath are used,
        // requiring no WEB-INF/lib directory to exist)
        context.setParentLoaderPriority(true);
        // Add this webapp to the server
        myServer.setHandler(context);
        myServer.start();
        myPort = ((ServerConnector) myServer.getConnectors()[0]).getLocalPort();
    }

    /**
     * Stops the server
     */
    public void stop() {
        try {
            myServer.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getPort() {
        return myPort;
    }

    public void setPort(int port) {
        myPort = port;
    }

    public void setPageDir(String dir) {
        myPageDir = dir;
    }
}
