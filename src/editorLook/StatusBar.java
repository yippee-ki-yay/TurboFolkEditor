package editorLook;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/*
 * Nemoj nikad na kraju da add-ujes sve komponente
 * izgubio si pola sata jer Aligment i glue ne radi
 * ako ih ne dodajes pre poziva tih metoda
 */

@SuppressWarnings("serial")
public class StatusBar extends JPanel
{
	JLabel welcomeMsg;
	JLabel stageMsg;
	JLabel progressMsg;
	
	public StatusBar()
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		welcomeMsg  = new JLabel("Vojvoda se vraca");
		add(welcomeMsg);
		
		add(Box.createHorizontalGlue());
		
	    stageMsg    = new JLabel("Application is running");
	    add(stageMsg);
	
	    add(Box.createHorizontalGlue());
	    
	    progressMsg = new JLabel("100%");
	    
	    add(progressMsg);
	}
}
