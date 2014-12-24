package grafeditor.gui;


import grafeditor.app.AppCore;
import grafeditor.model.workspace.Diagram;
import grafeditor.model.workspace.Project;
import grafeditor.model.workspace.WorkspaceModel;
import grafeditor.view.WorkspaceTreeCellRendered;
import grafeditor.view.WorkspaceTreeEditor;

import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class WorkspaceTree extends JTree implements  TreeSelectionListener{

	public WorkspaceTree() {
		
		addTreeSelectionListener(this);



	    setCellEditor(new WorkspaceTreeEditor(this,new WorkspaceTreeCellRendered()));
		setCellRenderer(new WorkspaceTreeCellRendered());
		setEditable(true);
		
		
	}

	
	/**
	 * Metoda za dodavanje novog projekta u workspace 
	 * @param project
	 */
	public void addProject(Project project){
		((WorkspaceModel)getModel()).addProject(project);
		SwingUtilities.updateComponentTreeUI(this);
	}


	public void valueChanged(TreeSelectionEvent arg0) {
		TreePath path = arg0.getPath();
		for(int i=0; i<path.getPathCount(); i++){
			if(path.getPathComponent(i) instanceof Diagram){
				Diagram d=(Diagram)path.getPathComponent(i);
				
				JInternalFrame[] jif= AppCore.getInstance().getDesktop().getAllFrames();
				for (int j=0;j<jif.length;j++){
					
					if (jif[j].getName().equals(d.getName())){
						try {
							
							jif[j].setSelected(true);
							
						} catch (PropertyVetoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					
				}
				
				break;
			}
		}
		
	}
	public Project getCurrentProject() {
		TreePath path = getSelectionPath();
		for(int i=0; i<path.getPathCount(); i++){
			if(path.getPathComponent(i) instanceof Project){
				return (Project)path.getPathComponent(i);
			}
		}
		return null;
	}


	
}
