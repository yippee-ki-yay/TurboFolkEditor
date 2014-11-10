package editorLook;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


@SuppressWarnings("serial")
public class TreeView extends JScrollPane
{
	private JTree tree;
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	
	public TreeView()
	{
		root = new DefaultMutableTreeNode("Workspace");
		
		model = new DefaultTreeModel(root);
		model.addTreeModelListener(new MyTreeModelListener());
		
		tree = new JTree(model);  //moras mu nakaciti model podataka nad kojim radis
		
		
		//TODO organizuj ovo drugacije da nemas unutrasnje klase
		//Unutrasnja klasa reguje na selekcije
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)
						               tree.getLastSelectedPathComponent();
				
				String selectedFrame = (String)node.getUserObject();
				
				MainFrame.getInstance().getDesktopManager().selectFrame(selectedFrame);
				
			}
		});
		
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode
		(TreeSelectionModel.SINGLE_TREE_SELECTION);
	
		setViewportView(tree);
	}
	
	public void addNode(String name)
	{
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(name);
		DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode)model.getRoot();
		
		model.insertNodeInto(newNode, rootNode, rootNode.getChildCount());
				
		tree.scrollPathToVisible(new TreePath(newNode.getPath()));
		
		root.add(newNode);
		
	}
	
	public void deleteNode()
	{
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)
	               tree.getLastSelectedPathComponent();
		model.removeNodeFromParent(node);
	}
	
	
	public class MyTreeModelListener implements TreeModelListener
	{
		
		
		@Override
		public void treeNodesChanged(TreeModelEvent e) {

			
		}

		@Override
		public void treeNodesInserted(TreeModelEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void treeNodesRemoved(TreeModelEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void treeStructureChanged(TreeModelEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}
}
