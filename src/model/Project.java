package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class Project implements TreeNode
{
    ArrayList<Frame> frames = new ArrayList<Frame>();
	private String name;
	
	//ako frame asociras sa frameview ona mozes direknto vratiti
	//frame i preko njega uzeti projekat otuda i putanja
	
	int id;
	
	public Project(String name, int id)
	{   
		System.out.println(frames.size());
		this.name = name;
		this.id = id;
	}
	
	public void deleteFrames(int id)
	{
		if(id == -1)
			frames.clear();
		else
			frames.remove(id);
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
	
	public void addFrame(Frame frame)
	{
		frame.setParentId(id);
		System.out.println(id);
		frames.add(frame);
	}
	
	//TODO STA Ako je obrisan?
/*	static public Frame selectFrame(int id)
	{
		for(int i = 0; i < frames.size(); ++i)
		{
			if(frames.get(id).getId() == id)
			{
				return frames.get(id);
			}
		}
		return null;
	}*/
	
	
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
		return getFrameIndex((Frame)node);
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return TreeModel.workspace;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getFrameIndex(Frame frame) {
		return frames.indexOf(frame);
	}
	
	public Frame getFrame(int index) {
		return frames.get(index);
	}
	
	public int getFrameCount() {
		return frames.size();
	}
	

}
