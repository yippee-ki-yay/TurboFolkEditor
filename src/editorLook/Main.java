package editorLook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Main {
	
	static SplashScreen splash;
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MainFrame mf = MainFrame.getInstance();
				mf.createApp();
			    mf.setVisible(false);
				
				splash = new SplashScreen();
				
				Timer timer = new Timer(1500, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						MainFrame.getInstance().setVisible(true);
						splash.setVisible(false);
						splash.dispose();
						
					}
				});
				
				timer.start();
				timer.setRepeats(false);
				
			}
		});

	}

}
