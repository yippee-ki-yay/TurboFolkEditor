package grafeditor.actions;

import grafeditor.app.AppCore;
import grafeditor.model.workspace.Diagram;
import grafeditor.model.workspace.Project;
import grafeditor.view.DiagramView;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class NewDiagramAction extends AbstractEditorAction{

	public NewDiagramAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/filenew.png"));
		putValue(NAME, "New diagram");
		putValue(SHORT_DESCRIPTION, "New diagram");
		}

	public void actionPerformed(ActionEvent arg0) {
		//
		Object p=AppCore.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (p  instanceof Project) {
			Diagram d=new Diagram("New diagram",(Project)p);
			((Project)p).addDiagram(d);
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getWorkspaceTree());
			
			
	        DiagramView view=new DiagramView();
			view.setDiagram(d);
			AppCore.getInstance().getDesktop().add(view);
			
			try {
				view.setSelected(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			

			
		}
		
	}

}
