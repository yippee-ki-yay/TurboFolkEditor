package events;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

//TODO mnemonics

public class DrawTriangleAction extends AbstractAction
{

	private static final long serialVersionUID = 7107261052750884724L;

	public DrawTriangleAction()
	{
		//putValue(MNEMONIC_KEY, KeyEvent.VK_W);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_T, ActionEvent.ALT_MASK));
		
		putValue(SHORT_DESCRIPTION, "Draws triangle");
		putValue(SMALL_ICON, new ImageIcon("img/triangle.png"));
		//putValue(NAME, "Maximize Frame");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	
		
	}

}