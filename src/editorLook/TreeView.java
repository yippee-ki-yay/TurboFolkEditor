package editorLook;

import java.util.HashMap;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

//TODO trenutno jedan ogroman clusterfuck zajedno sa formmanagerom
//izdeli na neke logicke celine i podeli odgovornost posla

@SuppressWarnings("serial")
public class TreeView extends JScrollPane
{
	private JTree tree;
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	
	private HashMap<String, DefaultMutableTreeNode> nodeFormMap;
	

	public TreeView()
	{
		root = new DefaultMutableTreeNode("Workspace");
		
		nodeFormMap = new HashMap<String, DefaultMutableTreeNode>();
		
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
				
				if(node == null) return;
				
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
		nodeFormMap.put(name, newNode);
		
	}
	
	/**
	 * Method just removes the selected node from the 
	 * from the tree structure.
	 * @param name Title of the Internal Frame you
	 * want to remove
	 */
	public void deleteNode(String name)
	{
		DefaultMutableTreeNode node = nodeFormMap.
				get(name);
		
		//nismo nasli form-u sa tim nazivom izadji
		if(node == null)
			return;
		
		//ukloni taj naziv iz liste
		nodeFormMap.remove(name);
		
		model.removeNodeFromParent(node);
	}
	
	public void setSelected(String name)
	{
		DefaultMutableTreeNode node = 
		                nodeFormMap.get(MainFrame.getInstance()
		                		.getDesktopManager().getSlectedFrame());
		
		TreeNode[] nodes = node.getPath();
		TreePath path = new TreePath(nodes);
		tree.setSelectionPath(path);
		
		
	}
	
	public DefaultMutableTreeNode getNode(String name)
	{
		return nodeFormMap.get(name);
	}
	
	public DefaultTreeModel getModel() {
		return model;
	}

	public void setModel(DefaultTreeModel model) {
		this.model = model;
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
