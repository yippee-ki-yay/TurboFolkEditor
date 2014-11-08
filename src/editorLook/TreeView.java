package editorLook;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class TreeView extends JScrollPane
{
	private JTree tree;
	
	public TreeView()
	{
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Workspace");
		
		for(int i = 0; i < 40; ++i)
		{
			DefaultMutableTreeNode x = new DefaultMutableTreeNode("yolo");
			root.add(x);
		}
		
		tree = new JTree(root);
		tree.setVisible(true);
		this.setViewportView(tree);
	}
}
