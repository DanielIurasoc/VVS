package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import application.Server;
import application.ServerState;
import application.Main;

public class mainTest {
	private static Server server;
	private static int testPort = 2222;
	
	@Before
    public static void setup() {
    	try {
    		server = new Server(testPort);
    	} catch (IOException e) {
		    System.out.println(e.getMessage());
		}
    }

	@Test
	public void testPerformAction() {
		IOException e;
		//assertEquals(e.getMessage(), performAction(server, ServerState.Running));
	}
}
