package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class FrameNode implements TreeNode, Serializable
{
    private static final long serialVersionUID = -3053787462486669567L;

    private int id;
    private String name;
    private int parentId;
    private ProjectNode parent;

    private ArrayList<ElementNode> elements = new ArrayList<ElementNode>();

    private FrameModel model = new FrameModel();

    public FrameSelectionModel selectionModel = new FrameSelectionModel();

    public int getParentId()
    {
        return parentId;
    }

    public void setParentId(int parentId)
    {
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
    public Enumeration children()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getAllowsChildren()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public TreeNode getChildAt(int childIndex)
    {
        // TODO Auto-generated method stub
        return (TreeNode) getElement(childIndex);
    }

    @Override
    public int getChildCount()
    {
        // TODO Auto-generated method stub
        return getElementCount();
    }

    @Override
    public int getIndex(TreeNode node)
    {
        // TODO Auto-generated method stub
        return getFrameIndex((ElementNode) node);
    }

    @Override
    public TreeNode getParent()
    {
        // TODO Auto-generated method stub
        return parent;
    }

    @Override
    public boolean isLeaf()
    {
        // TODO Auto-generated method stub
        return false;
    }

    public int getFrameIndex(ElementNode elementNode)
    {
        return elements.indexOf(elementNode);
    }

    public ElementNode getElement(int index)
    {
        return elements.get(index);
    }

    public int getElementCount()
    {
        return elements.size();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public FrameModel getModel()
    {
        return model;
    }

    public void setModel(FrameModel model)
    {
        this.model = model;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void removeElement(ElementNode elem)
    {
        elements.remove(elem);
    }


}
