package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import model.FrameNode;
import model.ProjectNode;
import model.WorkspaceTreeModel;
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
            	 if(o instanceof FrameNode)
            	 {
                  	 MainFrame.getInstance().getDesktopManager().showFrame(((FrameNode) o).getId());
            	 }}
         }
     };
	});
	 
	}
	
	public void addProject(ProjectNode projectNode)
	{
		((WorkspaceTreeModel)getModel()).addProject(projectNode);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void deleteProject(ProjectNode projectNode) {
		((WorkspaceTreeModel)getModel()).deleteProject(projectNode);
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
	    Object o = getLastSelectedPathComponent();
        
	    if(o != null)
	    {
	    	if(o instanceof FrameNode)
	    	{
	    		MainFrame.getInstance().getDesktopManager().
	    		                              selectFrame(((FrameNode) o).getId());
	    	}
	    }	
	}
	
	public void selectNode(FrameNode frameNode)
	{
		
		TreeNode[] arr = ((WorkspaceTreeModel)getModel()).getPathToRoot(frameNode);
	    
		TreePath path = new TreePath(arr);
		setSelectionPath(path);
		
	}
	
	
}
