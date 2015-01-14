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
import frame.FrameView;

@SuppressWarnings("serial")
public class DeleteAction extends AbstractAction
{

	public DeleteAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Delete");
		putValue(SMALL_ICON, new ImageIcon("img/delete.png"));
		putValue(NAME, "Delete");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//dobijemo koji node je selektovan
		Object o = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		
		//ako je projekat selektovan izbrisi sve nodove i framove datog projekta
		if(o instanceof ProjectNode)
		{
			MainFrame.getInstance().getDesktopManager().removeFrameViews(((ProjectNode)o).getFrames());
			MainFrame.getInstance().getWorkspaceTree().deleteProject((ProjectNode)o);
			MainFrame.getInstance().getActionManager().getFormAction().setEnabled(false);
			
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
			
		}
		else if(o instanceof FrameNode)
		{
			MainFrame.getInstance().getDesktopManager().deleteSelected();
			
			
			ProjectNode p = (ProjectNode) ((FrameNode)o).getParent();
    		p.deleteFrame(((FrameNode)o));
    		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
    		
		}
		
		//Prodjemo kroz sve selektovane elemente obrisemo elemente i njihove nodove
		FrameView frame = (FrameView)MainFrame.getInstance().getDesktopManager().getSelectedFrame();
		
		if(frame == null)return;
		
		frame.getCommandManager().undoCommand();
		
		//ako nista nije selektovano nemas sta ni brisati
		/*if(frame.getFrameNode().selectionModel.isEmpty())
			return;
		
		for(FrameElement elem : frame.getFrameNode().selectionModel.getSelectedElements())
		{
			frame.getFrameNode().getModel().removeElement(elem); //ubijemo graficki prikaz
			frame.getFrameNode().removeElement(elem.getNode()); //ubijemo stavku u drvetu
			
		}
		frame.getFrameNode().selectionModel.removeAllSelectedElements();
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());*/
	}

}
