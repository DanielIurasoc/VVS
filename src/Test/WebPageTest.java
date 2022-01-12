package Test;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.*;
import application.WebPage;

public class WebPageTest {
	private static WebPage wp;
	private ServerSocket serverSocket;
	//Socket clientSocket = serverSocket.accept();
	
	//PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	
	@Test
	public void testGetInstanceNull() {
		wp = new WebPage();
		assertEquals(null, wp.getInstance());
	}
	
	
}
