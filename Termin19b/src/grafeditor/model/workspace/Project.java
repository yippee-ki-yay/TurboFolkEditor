package grafeditor.model.workspace;





import grafeditor.app.AppCore;
import grafeditor.event.UpdateEvent;
import grafeditor.event.UpdateListener;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;



/**
 * 
 * @author Igor Z.
 * Predstavlja jedan projekat u okviru jednog Workspace-a
 * U sebi sadrži kolekciju dijagrama
 *
 */
@SuppressWarnings("serial")
public class Project implements TreeNode,UpdateListener,Serializable {

	//kolekcija dijagrama u okviru jednog projekta
	private ArrayList<Diagram> diagrams = new ArrayList<Diagram>();
	private String name;
	private transient boolean changed; 
	private File projectFile;
	
	public Project(String projectName) {
		this.name=projectName;
		this.changed=false;
		this.projectFile=null;

		

	}
	

	public void addDiagram(Diagram diagram){
		diagram.getModel().addUpdateListener(this);
		diagrams.add(diagram);
		diagram.setName( this.name+" - Diagram  - Grafički editor:"+String.valueOf(diagrams.size()));
		
	}	
	
	public String toString(){
		return ((changed?"* ":"")+ name);
	}	
	public Diagram getDiagram(int index) {
		return diagrams.get(index);
	}
	
	public int getDiagramIndex(Diagram diagram) {
		return diagrams.indexOf(diagram);
	}
	
	public int getDiagramCount() {
		return diagrams.size();
	}	
	public boolean isLeaf() {
		return false;
	}	
	
	public void setName(String name){
		this.name=name;
	}


	public TreeNode getChildAt(int arg0) {
		return getDiagram(arg0);
	}


	public int getChildCount() {
		return getDiagramCount();
	}


	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getIndex(TreeNode arg0) {
		return getDiagramIndex((Diagram)arg0);
	}


	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}


	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}


	public void updatePerformed(UpdateEvent e) {
		setChanged(true);
		
	}


	public boolean isChanged() {
		return changed;
	}


	public void setChanged(boolean changed) {
		if (this.changed!=changed){
		     this.changed=changed;
		     SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getWorkspaceTree());
		}
	}


	public File getProjectFile() {
		return projectFile;
	}


	public void setProjectFile(File projectFile) {
		this.projectFile = projectFile;
	}
}
