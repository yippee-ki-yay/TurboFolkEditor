package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import model.Frame;
import model.Project;
import model.Workspace;
import model.TreeModel;
import editorLook.MainFrame;

public class WorkspaceTree extends JTree implements TreeSelectionListener
{
	private static final long serialVersionUID = 4103080408620022917L;

	public WorkspaceTree()
	{
	 setEditable(false);
	 addTreeSelectionListener(this);
	 setCellRenderer(new WorkspaceTreeCellRendered());
	 
	 addMouseListener(new MouseAdapter() {
		 public void mousePressed(MouseEvent e) {
             TreePath selPath = getPathForLocation(e.getX(), e.getY());
           
             if (e.getClickCount() == 2) {
            	 if(selPath != null){
            	 Object o = selPath.getLastPathComponent();
            	 if(o == null)return;
            	 if(o instanceof Frame)
            	 {
                  	 MainFrame.getInstance().getDesktopManager().showFrame(((Frame) o).getId());
            	 }}
         }
     };
	});
	 
	}
	
	public void addProject(Project project)
	{
		((TreeModel)getModel()).addProject(project);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void deleteProject(Project project) {
		((TreeModel)getModel()).deleteProject(project);
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
	    Object o = getLastSelectedPathComponent();
        
	    if(o != null)
	    {
	    	if(o instanceof Frame)
	    	{
	    		MainFrame.getInstance().getDesktopManager().
	    		                              selectFrame(((Frame) o).getId());
	    	}
	    }	
	}
	
	public void selectNode(int id)
	{
	    
		
		//TODO YOLO
		/*Object arr[] = new Object[3];
		
		Frame f = Project.selectFrame(id);
		
		arr[0] = TreeModel.workspace;
		arr[1] = Workspace.selectProject(f.getParentId());
		arr[2] = f;
		
		TreePath path = new TreePath(arr);
		
		//((TreeModel)getModel()).getPathToRoot(f);
		
		//Project node = (Project)Workspace.selectProject(id); //selektuj prvi elem
		
		
		setSelectionPath(path);*/
	}
	
}
