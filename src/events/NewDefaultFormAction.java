package events;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import editorLook.DefaultForm;
import editorLook.MainFrame;

@SuppressWarnings("serial")
public class NewDefaultFormAction extends AbstractAction
{
	public NewDefaultFormAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultForm form = new DefaultForm();
		MainFrame.getInstance().getDesktopManager().add(form);
		
	}

}
