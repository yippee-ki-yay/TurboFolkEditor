package model;


import java.util.ArrayList;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class TreeModel extends DefaultTreeModel {

	private static final long serialVersionUID = 6394005654724969178L;
	
	public static Workspace workspace = new Workspace();

	public TreeModel() {
		super(workspace);
	}
	

	public void addProject(Project project) {
		((Workspace)getRoot()).addProject(project);
	}
	
	public void deleteProject(Project project) {
		((Workspace)getRoot()).deleteProject(project);
	}
	
	@Override
	public TreeNode[] getPathToRoot(TreeNode node)
	{
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		TreeNode parent = node.getParent();
		while(parent != null)
		{
			nodes.add(parent);
			parent = parent.getParent();
		}
		
		return (TreeNode[]) nodes.toArray();
		
	}
	

}
