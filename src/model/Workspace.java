package model;



import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;


public class Workspace implements TreeNode {

	private static ArrayList<Project> projects = new ArrayList<Project>();

	
	public Workspace()
	{
		super();
	}
	
	@Override
	public String toString()
	{
		return "Workspace";
	}
	
	public void addProject(Project project)
	{
		
		projects.add(project);
		
	}
	
	public void deleteProject(Project p)
	{
		p.deleteFrames(-1);
		projects.remove(p);
	}
	
	static public Project selectProject(int id)
	{
		for(int i = 0; i < projects.size(); ++i)
		{
			if(projects.get(id).getId() == id)
			{
				return projects.get(id);
			}
		}
		return null;
	}
	
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
		return getProjectIndex((Project) arg0);
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
	
	public int getProjectIndex(Project project) {
		return projects.indexOf(project);
	}
	
	public Project getProject(int index) {
		return projects.get(index);
	}
	
	public int getProjectsCount() {
		return projects.size();
	}

}
