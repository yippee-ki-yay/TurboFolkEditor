package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import model.Project;
import editorLook.MainFrame;

@SuppressWarnings("serial")
public class DeleteAction extends AbstractAction
{

	public DeleteAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Delte Frame");
		putValue(SMALL_ICON, new ImageIcon("img/delete.png"));
		putValue(NAME, "Delete Frame");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
		
		//Ako je samo jedan frejm selektovan
       int id =  MainFrame.getInstance().getDesktopManager().deleteSelected();
        
        //selektovan frame nam vrati svoj id
		
		
		Object o = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		
		if(o instanceof Project)
		{
			MainFrame.getInstance().getWorkspaceTree().deleteProject((Project)o);
			
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		}
	}

}
