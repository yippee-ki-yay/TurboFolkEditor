package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;


@SuppressWarnings("serial")
public class ExportAction extends AbstractAction
{

	public ExportAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_E);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Export project");
		putValue(SMALL_ICON, new ImageIcon("img/export.png"));
		putValue(NAME, "Export project");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	
		
	}

}