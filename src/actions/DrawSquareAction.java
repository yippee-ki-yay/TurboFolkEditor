package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;


public class DrawSquareAction extends AbstractAction
{

	private static final long serialVersionUID = 8694871055944814060L;

	public DrawSquareAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.ALT_MASK));
		
		putValue(SHORT_DESCRIPTION, "Draw square");
		putValue(SMALL_ICON, new ImageIcon("img/square.png"));
		putValue(NAME, "Draw square");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	
		
	}

}
