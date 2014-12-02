package model;



import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;


public class WorkspaceNode implements TreeNode {

	private static ArrayList<ProjectNode> projectNodes = new ArrayList<ProjectNode>();

	
	public WorkspaceNode()
	{
		super();
	}
	
	@Override
	public String toString()
	{
		return "Workspace";
	}
	
	public void addProject(ProjectNode projectNode)
	{
		
		projectNodes.add(projectNode);
		
	}
	
	public void deleteProject(ProjectNode p)
	{
		p.removeAllFrames();
		projectNodes.remove(p);
	}
	
	static public ProjectNode selectProject(int id)
	{
		for(int i = 0; i < projectNodes.size(); ++i)
		{
			if(projectNodes.get(id).getId() == id)
			{
				return projectNodes.get(id);
			}
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		// TODO Auto-generated method stub
		return getProject(arg0);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return getProjectsCount();
	}

	@Override
	public int getIndex(TreeNode arg0) {
		// TODO Auto-generated method stub
		return getProjectIndex((ProjectNode) arg0);
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null; //workspace je top node pa nema parent
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getProjectIndex(ProjectNode projectNode) {
		return projectNodes.indexOf(projectNode);
	}
	
	public ProjectNode getProject(int index) {
		return projectNodes.get(index);
	}
	
	public int getProjectsCount() {
		return projectNodes.size();
	}

}
