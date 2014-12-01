package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;


@SuppressWarnings("serial")
public class MaximizeAction extends AbstractAction
{

	public MaximizeAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_W);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Maximize Frame");
		putValue(SMALL_ICON, new ImageIcon("img/maximize.jpg"));
		putValue(NAME, "Maximize Frame");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	MainFrame.getInstance().getDesktopManager().Maximize();
		
	}

}
