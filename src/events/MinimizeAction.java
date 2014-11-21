package events;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;


@SuppressWarnings("serial")
public class MinimizeAction extends AbstractAction
{

	public MinimizeAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_M);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Minimize Frame");
		putValue(SMALL_ICON, new ImageIcon("img/minimize.png"));
		putValue(NAME, "Minimize Frame");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	
		
	}

}
