package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import model.Frame;
import model.Project;
import editorLook.MainFrame;

@SuppressWarnings("serial")
public class NewFrameAction extends AbstractAction
{
	
	static int idCount = 0;
	
	public NewFrameAction()
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
		
		
		Object p=MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (p  instanceof model.Project)
		{
			Frame f = new Frame(idCount, "Frame" + idCount, (Project)p);
			((Project) p).addFrame(f);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
			
			MainFrame.getInstance().getDesktopManager().addFrame("Frame" + idCount, idCount);
			idCount++;
			//MainFrame.frame_id++;
		}
		
	}

}
