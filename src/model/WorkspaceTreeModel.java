package model;

import java.util.Stack;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class WorkspaceTreeModel extends DefaultTreeModel
{

    private static final long serialVersionUID = 6394005654724969178L;

    public static WorkspaceNode workspaceNode = new WorkspaceNode();

    public WorkspaceTreeModel()
    {
        super(workspaceNode);
    }

    public void addProject(ProjectNode projectNode)
    {
        ((WorkspaceNode) getRoot()).addProject(projectNode);
    }

    public void deleteProject(ProjectNode projectNode)
    {
        ((WorkspaceNode) getRoot()).deleteProject(projectNode);
    }

    @Override
    public TreeNode[] getPathToRoot(TreeNode node)
    {

        Stack<TreeNode> nodess = new Stack<TreeNode>();

        TreeNode n = node;

        while (n != null)
        {
            nodess.add(n);
            n = n.getParent();
        }

        TreeNode[] nodes = new TreeNode[nodess.size()];

        int i = 0;
        while (!nodess.isEmpty())
        {
            nodes[i] = nodess.pop();
            i++;
        }

        return nodes;

    }

}
