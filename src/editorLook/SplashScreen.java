package editorLook;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow {

	JLabel imgLabel;
	
	public SplashScreen()
	{
		
		imgLabel = new JLabel();
		
		Icon icon = new ImageIcon("img/ftn-logo.png");
		imgLabel.setIcon(icon);
		
		setVisible(true);
		
		add(imgLabel);
		
		pack();
		
		setLocationRelativeTo(null);
	}
	
}

