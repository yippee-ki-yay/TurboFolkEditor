package events;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

//TODO mnemonics

public class DrawCircleAction extends AbstractAction
{
	private static final long serialVersionUID = -5156941483640828169L;

	public DrawCircleAction()
	{
		//putValue(MNEMONIC_KEY, KeyEvent.VK_W);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.ALT_MASK));
		
		putValue(SHORT_DESCRIPTION, "Draws circle");
		putValue(SMALL_ICON, new ImageIcon("img/circle.png"));
		//putValue(NAME, "Maximize Frame");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	
		
	}

}