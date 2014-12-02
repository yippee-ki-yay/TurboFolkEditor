package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import model.FrameNode;
import model.ProjectNode;
import editorLook.MainFrame;

@SuppressWarnings("serial")
public class DeleteAction extends AbstractAction
{

	public DeleteAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Delete");
		putValue(SMALL_ICON, new ImageIcon("img/delete.png"));
		putValue(NAME, "Delete");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//dobijemo kod node je selektovan
		Object o = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		
		//ako je projekat selektovan izbrisi sve nodove i framove datog projekta
		if(o instanceof ProjectNode)
		{
			MainFrame.getInstance().getDesktopManager().removeFrameViews(((ProjectNode)o).getFrames());
			MainFrame.getInstance().getWorkspaceTree().deleteProject((ProjectNode)o);
			
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		}
		else if(o instanceof FrameNode)
		{
			MainFrame.getInstance().getDesktopManager().deleteSelected();
			
			
			ProjectNode p = (ProjectNode) ((FrameNode)o).getParent();
    		p.deleteFrame(((FrameNode)o));
    		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		}
	}

}
