package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;


public class ExitAction extends AbstractAction
{
	private static final long serialVersionUID = 4176352810520048514L;

	public ExitAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Exit");
		putValue(SMALL_ICON, new ImageIcon("img/exit.png"));
		putValue(NAME, "Exit");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	MainFrame.getInstance().dispatchEvent(new WindowEvent(
			MainFrame.getInstance(), WindowEvent.WINDOW_CLOSING));
		
	}

}