package model;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import model.elements.FrameElement;

public class ElementNode implements TreeNode
{
	FrameNode parent;
	String name;
	
	public enum ElemType {RECTANGLE, TRIANGLE, CIRCLE, TREE};
	
	ElemType type;
	
	FrameElement element; //refernca na graficki element sa kojim je povezan

	public ElementNode(FrameNode parent, String name, ElemType t, FrameElement elem)
	{
		this.parent = parent;
		type = t;
		this.name = name;
		this.element = elem;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FrameElement getElement() {
		return element;
	}

	public void setElement(FrameElement element) {
		this.element = element;
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
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	public ElemType getType() {
		return type;
	}

	public void setType(ElemType type) {
		this.type = type;
	}
	

}
