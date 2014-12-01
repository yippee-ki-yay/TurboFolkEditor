package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;


@SuppressWarnings("serial")
public class ImportAction extends AbstractAction
{

	public ImportAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_I);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Import project");
		putValue(SMALL_ICON, new ImageIcon("img/import.png"));
		putValue(NAME, "Import project");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	
		
	}

}