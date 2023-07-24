package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class GameWindow {
	private JFrame jframe;
	public GameWindow(GamePanel gamepanel) {
		jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamepanel);
		jframe.setResizable(false); 
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		jframe.addWindowFocusListener(new WindowFocusListener() {

			@Override
			public void windowGainedFocus(WindowEvent arg0) {
				gamepanel.getGame().windowFocusLost();
			}

			@Override
			public void windowLostFocus(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});

	}
}
