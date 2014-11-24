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
	
	JLabel Msg1;
	JLabel Msg2;
	
	public StatusBar()
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		welcomeMsg  = new JLabel("Hodor");
		add(welcomeMsg);
		
		add(Box.createHorizontalGlue());
		
		Msg1 = new JLabel("Hodor");
		add(Msg1);
		
		add(Box.createHorizontalGlue());
		
		Msg2 = new JLabel("Hodor");
		add(Msg2);
		
		add(Box.createHorizontalGlue());
		
	    stageMsg    = new JLabel("Hodor");
	    add(stageMsg);
	
	    add(Box.createHorizontalGlue());
	    
	    progressMsg = new JLabel("Hodor");
	    
	    add(progressMsg);
	}
}
