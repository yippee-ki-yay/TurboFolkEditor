package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;


public class SaveAction extends AbstractAction
{
	private static final long serialVersionUID = -4705054839893474047L;

	public SaveAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_S);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Save");
		putValue(SMALL_ICON, new ImageIcon("img/save.png"));
		putValue(NAME, "Save");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	
		
	}

}