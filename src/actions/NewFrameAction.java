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
public class NewFrameAction extends AbstractAction
{
	
	public NewFrameAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
		
		putValue(SHORT_DESCRIPTION, "New Frame");
		putValue(SMALL_ICON, new ImageIcon("img/frame.png"));
		putValue(NAME, "New Frame");
		
	}
	
	
	//TODO kad ovo pozovis kao addFrame() ne prikaze se?
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		Object p=MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (p  instanceof model.ProjectNode)
		{
			FrameNode f = new FrameNode(MainFrame.frame_id, "Frame" + MainFrame.frame_id, (ProjectNode)p);
			((ProjectNode) p).addFrame(f);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
			
			MainFrame.getInstance().getDesktopManager().addFrame("Frame" + MainFrame.frame_id,
					                                               MainFrame.frame_id, f);
			MainFrame.frame_id++;
		}
		
	}

}
