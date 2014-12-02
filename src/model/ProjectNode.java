package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class ProjectNode implements TreeNode
{
    ArrayList<FrameNode> frameNodes = new ArrayList<FrameNode>();
	private String name;
	
	int id;
	
	public ProjectNode(String name, int id)
	{   
		this.name = name;
		this.id = id;
	}
	
	public void deleteFrame(FrameNode frameNode)
	{
			frameNodes.remove(frameNode);
	}
	
	public void removeAllFrames()
	{
		frameNodes.clear();
	}
	
	public ArrayList<FrameNode> getFrames()
	{
		
		
		return frameNodes;
	}
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void addFrame(FrameNode frameNode)
	{
		frameNode.setParentId(id);
		frameNodes.add(frameNode);
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
		return (TreeNode) getFrame(childIndex);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return getFrameCount();
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return getFrameIndex((FrameNode)node);
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return WorkspaceTreeModel.workspaceNode;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getFrameIndex(FrameNode frameNode) {
		return frameNodes.indexOf(frameNode);
	}
	
	public FrameNode getFrame(int index) {
		return frameNodes.get(index);
	}
	
	public int getFrameCount() {
		return frameNodes.size();
	}
	

}
