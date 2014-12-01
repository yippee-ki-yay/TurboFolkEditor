package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;


@SuppressWarnings("serial")
public class NextFormAction extends AbstractAction
{

	public NextFormAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_RIGHT);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_RIGHT, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Next Frame");
		putValue(SMALL_ICON, new ImageIcon("img/next_right.png"));
		putValue(NAME, "Next Frame");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	MainFrame.getInstance().getDesktopManager().selectNext();
		
	}

}