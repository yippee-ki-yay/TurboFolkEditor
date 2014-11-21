package Experiment;



import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class windowExample {
	
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				SplashScreen splash = new SplashScreen();
				
			}
		});
	}

}
