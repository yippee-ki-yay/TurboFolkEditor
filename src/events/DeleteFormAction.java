package events;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import editorLook.MainFrame;

public class DeleteFormAction extends AbstractAction
{

	@Override
	public void actionPerformed(ActionEvent arg0) {
			MainFrame.getInstance().getDesktopManager().deleteSelected();
			//MainFrame.getInstance().getTree().deleteNode();
		
	}

}
