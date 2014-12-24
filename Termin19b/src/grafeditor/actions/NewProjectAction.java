package grafeditor.actions;

import grafeditor.app.AppCore;
import grafeditor.model.workspace.Diagram;
import grafeditor.model.workspace.Project;
import grafeditor.view.DiagramView;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.KeyStroke;

public class NewProjectAction extends AbstractEditorAction{

	public NewProjectAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/filenew.png"));
		putValue(NAME, "New project");
		putValue(SHORT_DESCRIPTION, "New project");
		}

	public void actionPerformed(ActionEvent arg0) {
		
		
		Project p=new Project(" ");
		AppCore.getInstance().getWorkspaceTree().addProject(p);
		Diagram d=new Diagram(" ",p);
		p.addDiagram(d);
		
		
		
		DiagramView view=new DiagramView();
		view.setDiagram(d);
		AppCore.getInstance().getDesktop().add(view);
	
		try {
			view.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
