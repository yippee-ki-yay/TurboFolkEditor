package model;



import java.util.ArrayList;

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
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		
		nodes.add(node.getParent().getParent());
		nodes.add(node.getParent());
		nodes.add(node);
		
		return nodes.toArray(new TreeNode[nodes.size()]);
		
	}
	

}
