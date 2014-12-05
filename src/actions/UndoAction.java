package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;


public class UndoAction extends AbstractAction
{
	private static final long serialVersionUID = -455323436981933792L;

	public UndoAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Undo");
		putValue(SMALL_ICON, new ImageIcon("img/undo.png"));
		putValue(NAME, "Undo");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	
		
	}

}
