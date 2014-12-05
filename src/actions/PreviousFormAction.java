package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;


public class PreviousFormAction extends AbstractAction
{

	private static final long serialVersionUID = 8970039633861570526L;

	public  PreviousFormAction() {
	
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_LEFT, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Previous Frame");
		putValue(SMALL_ICON, new ImageIcon("img/next_left.png"));
		putValue(NAME, "Previous Frame");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	MainFrame.getInstance().getDesktopManager().selectPrevious();
		
	}

}
