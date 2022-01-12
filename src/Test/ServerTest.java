package Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import application.Server;
import application.ServerState;

public class ServerTest {

    private static Server server;
    private static final int testPort = 22222;
    private ServerState serverState;

    @Before
    public static void setup() {
    	try {
    		server = new Server(testPort);
    	} catch (IOException e) {
		    System.out.println(e.getMessage());
		}
    }

    @Test
    public void testSetServerState() {
    	server.setServerState(serverState.Maintenance);
    	assertEquals(serverState.Maintenance, server.getServerState());
    }
    
}