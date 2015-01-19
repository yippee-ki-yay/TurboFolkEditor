package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import editorLook.MainFrame;
import events.UpdateElementsEvent;
import events.UpdateElementsListener;

public class ProjectNode implements TreeNode, Serializable,
        UpdateElementsListener
{
    private static final long serialVersionUID = -4573316885575262635L;

    private ArrayList<FrameNode> frameNodes = new ArrayList<FrameNode>();
    private String name;
    public static boolean changed;

    File saveFile;

    int id;

    public ProjectNode(String name, int id)
    {
        this.name = name;
        this.id = id;
        this.changed = false;
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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public File getSaveFile()
    {
        return saveFile;
    }

    public void setSaveFile(File saveFile)
    {
        this.saveFile = saveFile;
    }

    @Override
    public String toString()
    {
        return ((changed ? "* " : "") + name);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void addFrame(FrameNode frameNode)
    {
        frameNode.getModel().addUpdateElementsListener(this);
        frameNode.setParentId(id);
        frameNodes.add(frameNode);
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
        return (TreeNode) getFrame(childIndex);
    }

    @Override
    public int getChildCount()
    {
        // TODO Auto-generated method stub
        return getFrameCount();
    }

    @Override
    public int getIndex(TreeNode node)
    {
        // TODO Auto-generated method stub
        return getFrameIndex((FrameNode) node);
    }

    @Override
    public TreeNode getParent()
    {
        // TODO Auto-generated method stub
        return WorkspaceTreeModel.workspaceNode;
    }

    @Override
    public boolean isLeaf()
    {
        // TODO Auto-generated method stub
        return false;
    }

    public int getFrameIndex(FrameNode frameNode)
    {
        return frameNodes.indexOf(frameNode);
    }

    public FrameNode getFrame(int index)
    {
        return frameNodes.get(index);
    }

    public int getFrameCount()
    {
        return frameNodes.size();
    }

    public boolean isChanged()
    {
        return changed;
    }

    public void setChanged(boolean changed)
    {
        if (this.changed != changed)
        {
            this.changed = changed;
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
                    .getWorkspaceTree());
        }
    }
    
    public static void updateChanged(boolean c)
    {
        if (changed != c)
        {
            changed = c;
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
                    .getWorkspaceTree());
        } 
    }
    
    @Override
    public void updatePerformed(UpdateElementsEvent e)
    {
      //  setChanged(true);
    }

}
