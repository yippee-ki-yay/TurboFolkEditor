package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import states.StateManager;

public class FrameNode implements TreeNode
{

	int id;
	String name;
	int parentId;
	ProjectNode parent;
	
	ArrayList<ElementNode> elements = new ArrayList<ElementNode>();
	
	FrameModel model = new FrameModel();
	
	public FrameSelectionModel selectionModel = new FrameSelectionModel();
	
	private StateManager stateManager = new StateManager();
	
	public StateManager getStateManager() {
		return stateManager;
	}


	public void setStateManager(StateManager stateManager) {
		this.stateManager = stateManager;
	}


	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public FrameNode(int id, String name, ProjectNode parent)
	{
		this.id = id;
		this.name = name;
		this.parent = parent;
	}
	

	@Override
	public String toString()
	{
		return this.name;
	}
	
	public void addElement(ElementNode elem)
	{
		elements.add(elem);
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
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return (TreeNode) getElement(childIndex);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return getElementCount();
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return getFrameIndex((ElementNode)node);
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getFrameIndex(ElementNode elementNode) {
		return elements.indexOf(elementNode);
	}
	
	public ElementNode getElement(int index) {
		return elements.get(index);
	}
	
	public int getElementCount() {
		return elements.size();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public FrameModel getModel() {
		return model;
	}


	public void setModel(FrameModel model) {
		this.model = model;
	}

}
