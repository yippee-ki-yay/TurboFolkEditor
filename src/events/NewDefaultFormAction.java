package events;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import editorLook.MainFrame;

@SuppressWarnings("serial")
public class NewDefaultFormAction extends AbstractAction
{
	static int i = 1;
	
	public NewDefaultFormAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
	}
	
	
	//TODO kad ovo pozovis kao addFrame() ne prikaze se?
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().getDesktopManager().addFrame("Form" + i);
		MainFrame.getInstance().getTree().addNode("Form" + i);
		i++;
	}

}
