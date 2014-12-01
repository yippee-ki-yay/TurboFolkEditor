package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import model.Frame;
import model.Project;
import editorLook.MainFrame;

public class NewProjectAction extends AbstractAction
{

	static int id = 0;
	
	private static final long serialVersionUID = -3965019754209574120L;

	public NewProjectAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);
		
		putValue(SHORT_DESCRIPTION, "New Project");
		putValue(SMALL_ICON, new ImageIcon("img/projectBtn.png"));
		putValue(NAME, "New Project");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//pozovi kod da se kreira nova package stavka u drvetu
		Project project = new Project("Project" + id, id);
		MainFrame.getInstance().getWorkspaceTree().addProject(project);
		
		/*Frame frame = new Frame(MainFrame.frame_id, "Frame" + MainFrame.frame_id, project);
		project.addFrame(frame);
		MainFrame.getInstance().getDesktopManager().addFrame("Frame" + MainFrame.frame_id, MainFrame.frame_id);*/
		
		id++;
	}
	
}