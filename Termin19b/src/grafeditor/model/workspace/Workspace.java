package grafeditor.model.workspace;





import java.awt.Component;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

/**
 * 
 * 
 * @author Igor Z.
 * Predstavlja jedan workspace
 * U sebi sadrži kolekciju projekata
 */
public class Workspace  implements TreeNode{

	//kolekcija projekata
	private ArrayList<Project> projects = new ArrayList<Project>();
	
	
	public Workspace() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		return "Workspace";
	}
	
	
	public TreeNode getChildAt(int arg0) {
		return getProject(arg0);
		
	}

	public int getChildCount() {
		return getProjectsCount();
	}

	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIndex(TreeNode arg0) {
		return getProjectIndex((Project) arg0);
	}

	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addProject(Project project){
		projects.add(project);
		project.setName("Project - Grafički editor"+projects.size());
	}
	
	public Project getProject(int index) {
		return projects.get(index);
	}	
	
	public int getProjectIndex(Project project) {
		return projects.indexOf(project);
	}
	public int getProjectsCount() {
		return projects.size();
	}
}
