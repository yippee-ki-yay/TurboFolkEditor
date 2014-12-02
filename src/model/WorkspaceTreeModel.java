package model;



import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class WorkspaceTreeModel extends DefaultTreeModel {

	private static final long serialVersionUID = 6394005654724969178L;
	
	public static WorkspaceNode workspaceNode = new WorkspaceNode();

	public WorkspaceTreeModel() {
		super(workspaceNode);
	}
	

	public void addProject(ProjectNode projectNode) {
		((WorkspaceNode)getRoot()).addProject(projectNode);
	}
	
	public void deleteProject(ProjectNode projectNode) {
		((WorkspaceNode)getRoot()).deleteProject(projectNode);
	}
	
	@Override
	public TreeNode[] getPathToRoot(TreeNode node)
	{
		TreeNode[] nodes = new TreeNode[3];
		
		nodes[2] = node;
		
		nodes[1] = node.getParent();
		nodes[0] = nodes[1].getParent();
		
		return nodes;
		
	}
	

}
