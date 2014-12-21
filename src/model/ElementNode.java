package model;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class ElementNode implements TreeNode
{
	FrameNode parent;
	String name;
	
	public enum ElemType {RECTANGLE, TRIANGLE, CIRCLE};
	
	ElemType type;

	public ElementNode(FrameNode parent, String name, ElemType t)
	{
		this.parent = parent;
		type = t;
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		return name;
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
