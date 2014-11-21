package events;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class NewProjectAction extends AbstractAction
{

	private static final long serialVersionUID = -3965019754209574120L;

	public NewProjectAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);
		
		putValue(SHORT_DESCRIPTION, "New Project");
		putValue(SMALL_ICON, new ImageIcon("img/projectBtn.png"));
		putValue(NAME, "New Project");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//pozovi kod da se kreira nova package stavka u drvetu
		
	}
	
}
