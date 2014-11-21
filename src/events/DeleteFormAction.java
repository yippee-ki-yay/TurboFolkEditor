package events;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import editorLook.MainFrame;

@SuppressWarnings("serial")
public class DeleteFormAction extends AbstractAction
{

	public DeleteFormAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
		//Proveri da li postoji selektovan frejm pre nego sto brises
		if(MainFrame.getInstance().getDesktopManager().isSomeoneSelected())
		{
			MainFrame.getInstance().getTree().
            deleteNode(MainFrame.getInstance().getDesktopManager().getSlectedFrame());

            MainFrame.getInstance().getDesktopManager().deleteSelected();
		}	
		
	}

}
