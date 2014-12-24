package grafeditor.model.workspace;

import grafeditor.model.DiagramModel;
import grafeditor.model.DiagramSelectionModel;

import java.io.Serializable;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;


/**
 * 
 * @author Igor Z.
 * Predstavlja jedan  dijagram projekta
 * U sebi sadrži model dijagrama
 *
 */
@SuppressWarnings("serial")
public class Diagram implements TreeNode,Serializable {
	private String name;
	private DiagramModel model=new DiagramModel();
	private Project project;
	
	/**
	 * Selekcioni model je zadužen za čuvanje i izmenu tekuće selekcije. 
	 */
	private DiagramSelectionModel selectionModel;
	
 
    
    
	public Diagram(String diagramName, Project project) {
		name=diagramName;
		
		
	}
	
	public DiagramModel getModel() {
		return model;
	}
	
	public String toString(){
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setModel(DiagramModel model) {
		this.model = model;
	}

	public TreeNode getChildAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return project;
	}

	public int getIndex(TreeNode arg0) {
		// TODO Auto-generated method stub
		return -1;
	}

	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return true;
	}

	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}

    

	public DiagramSelectionModel getSelectionModel() {
		if(selectionModel == null)
			selectionModel = new DiagramSelectionModel();
		return selectionModel;
	}

 

}
