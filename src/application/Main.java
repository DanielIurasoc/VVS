package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;


public class Main{
	public static void createGUI(Server server) {
		JFrame f = new JFrame("My WebServer");
		
		JButton bStart = new JButton("START");
		JButton bStop = new JButton("STOP");
		
		JTextField tStatus = new JTextField("STOPPED");
		JTextField tPort = new JTextField("0000");
		
		JLabel lStatus = new JLabel("Server Status : ");
		JLabel lPort = new JLabel("Server Port : ");
		
		JCheckBox cMaintenance = new JCheckBox("Maintenance ON!");
		
		lStatus.setBounds(100, 100, 100, 40);
		tStatus.setBounds(200, 100, 100, 40);
		tStatus.setEditable(false);
		
		lPort.setBounds(100, 150, 100, 40);
		tPort.setBounds(200, 150, 100, 40);
		tPort.setEditable(false);
		
		cMaintenance.setBounds(100, 200, 200, 40);
		
		bStart.setBounds(70, 250, 100, 40);
		bStop.setBounds(230, 250, 100, 40);
		
		bStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cMaintenance.isSelected()) {
					tStatus.setText("MAINTENANCE");
					tPort.setText("8008");
					
					performAction(server, ServerState.Maintenance);
				}
				else {
					tStatus.setText("RUNNING");
					tPort.setText("8008");

					performAction(server, ServerState.Running);
				}
			}
		});
					
		bStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tStatus.setText("STOPPED");
				tPort.setText("0000");
				server.setServerState(ServerState.Stopped);
			}
		});
		
		f.add(lStatus);
		f.add(lPort);
		f.add(tStatus);
		f.add(tPort);
		f.add(cMaintenance);
		f.add(bStart);
		f.add(bStop);
		f.setSize(400, 500);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	public static void performAction(Server server, ServerState ss) {
		try {
			server.setServerState(ss);
			server.start();
		}
		catch (Exception e) {
		    System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
		    Server server = new Server(8008);
		    server.setServerState(ServerState.Stopped);
		    createGUI(server);
		}
		catch (IOException ex) {
		    System.out.println(ex.getMessage());
		}
	}
}

