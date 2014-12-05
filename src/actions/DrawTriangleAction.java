package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;


public class DrawTriangleAction extends AbstractAction
{

	private static final long serialVersionUID = 7107261052750884724L;

	public DrawTriangleAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_T, ActionEvent.ALT_MASK));
		
		putValue(SHORT_DESCRIPTION, "Draw triangle");
		putValue(SMALL_ICON, new ImageIcon("img/triangle.png"));
		putValue(NAME, "Draw triangle");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	
		
	}

}