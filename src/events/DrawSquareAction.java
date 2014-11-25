package events;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

//TODO mnemonics

public class DrawSquareAction extends AbstractAction
{

	private static final long serialVersionUID = 8694871055944814060L;

	public DrawSquareAction()
	{
		//putValue(MNEMONIC_KEY, KeyEvent.VK_W);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.ALT_MASK));
		
		putValue(SHORT_DESCRIPTION, "Draws square");
		putValue(SMALL_ICON, new ImageIcon("img/square.png"));
		//putValue(NAME, "Maximize Frame");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	
		
	}

}
