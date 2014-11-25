package events;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;

@SuppressWarnings("serial")
public class NewDefaultFormAction extends AbstractAction
{
	private static int idCount = 0;
	
	public NewDefaultFormAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
		
		putValue(SHORT_DESCRIPTION, "New Frame");
		putValue(SMALL_ICON, new ImageIcon("img/new_22x22.jpg"));
		putValue(NAME, "New Frame");
		
	}
	
	
	//TODO kad ovo pozovis kao addFrame() ne prikaze se?
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().getDesktopManager().addFrame("Form" + idCount, idCount);
		MainFrame.getInstance().getTree().addNode("Form" + idCount, idCount);
		idCount++;
	}

}
