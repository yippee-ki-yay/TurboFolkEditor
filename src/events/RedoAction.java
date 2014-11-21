package events;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;


public class RedoAction extends AbstractAction
{

	private static final long serialVersionUID = -1473591524847560001L;

	public RedoAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_U);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Redo");
		putValue(SMALL_ICON, new ImageIcon("img/redo.png"));
		putValue(NAME, "Redo");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	
		
	}

}
