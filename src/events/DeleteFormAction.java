package events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import editorLook.MainFrame;

@SuppressWarnings("serial")
public class DeleteFormAction extends AbstractAction
{

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
