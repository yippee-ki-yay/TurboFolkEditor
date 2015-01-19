package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import model.ElementNode;
import model.FrameNode;
import model.ProjectNode;
import model.WorkspaceTreeModel;
import model.elements.FrameElement;
import editorLook.MainFrame;
import frame.FrameView;

public class WorkspaceTree extends JTree implements TreeSelectionListener
{
    private static final long serialVersionUID = 4103080408620022917L;

    private boolean ctrlDown = false;

    public WorkspaceTree()
    {
        setEditable(false);
        addTreeSelectionListener(this);
        setCellRenderer(new WorkspaceTreeCellRendered());
        getSelectionModel().setSelectionMode(
                TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);

        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                TreePath selPath = getPathForLocation(e.getX(), e.getY());
                if(e.getClickCount() == 1)
                {
                    if (selPath != null)
                    {
                        Object o = selPath.getLastPathComponent();
                        if (o == null) return;
                        if (o instanceof ElementNode)
                        {
                            ElementNode node = (ElementNode)o;  
                            FrameNode frameNode =  (FrameNode) node.getParent();
                            
                            if(ctrlDown == false)
                                frameNode.selectionModel.removeAllSelectedElements();
                            
                            frameNode.selectionModel.addSelectedElement(node.getElement());
                            
                            frameNode.getModel().fireUpdatePreformed();
                        }
                        
                    }
                }
                else if (e.getClickCount() == 2)
                {
                    if (selPath != null)
                    {
                        Object o = selPath.getLastPathComponent();
                        if (o == null) return;
                        if (o instanceof FrameNode)
                        {
                            MainFrame.getInstance().getDesktopManager()
                                    .showFrame(((FrameNode) o).getId());
                        } else if (o instanceof ElementNode)
                        {
                            ElementNode node = ((ElementNode) o);
                            MainFrame.getInstance().getPropertyDialog()
                                    .setCurrElement(node.getElement());

                            node.setName(node.getElement().getName());
                            ((FrameNode) node.getParent()).getModel()
                                    .fireUpdatePreformed(); // updejt zbog boje
                            SwingUtilities
                                    .updateComponentTreeUI(WorkspaceTree.this);

                        }

                    }
                }
            };
        });

        addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.isControlDown()) ctrlDown = true;
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) ctrlDown = false;
            }

        });

    }

    public void addProject(ProjectNode projectNode)
    {
        ((WorkspaceTreeModel) getModel()).addProject(projectNode);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void deleteProject(ProjectNode projectNode)
    {
        ((WorkspaceTreeModel) getModel()).deleteProject(projectNode);
    }

    @Override
    public void valueChanged(TreeSelectionEvent e)
    {
        Object o = getLastSelectedPathComponent();

        if (o != null)
        {
            if (o instanceof FrameNode)
            {
                MainFrame.getInstance().getDesktopManager()
                        .selectFrame(((FrameNode) o).getId());
                MainFrame.getInstance().getActionManager().getFormAction()
                        .setEnabled(false);
                MainFrame.getInstance().getActionManager().getFormAction()
                        .putValue(Action.SHORT_DESCRIPTION, "Select a project");
                MainFrame.getInstance().getActionManager().getDeleteAction()
                        .putValue(Action.SHORT_DESCRIPTION, "Delete frame");

            } else if (o instanceof ProjectNode)
            {
                MainFrame.getInstance().getActionManager().getFormAction()
                        .setEnabled(true);
                MainFrame.getInstance().getActionManager().getFormAction()
                        .putValue(Action.SHORT_DESCRIPTION, "Add frame");
                MainFrame.getInstance().getActionManager().getDeleteAction()
                        .putValue(Action.SHORT_DESCRIPTION, "Delete project");
            } else if (o instanceof ElementNode)                                   
            {
                  
                 
            } else
            {
                MainFrame.getInstance().getActionManager().getFormAction()
                        .setEnabled(false);
                MainFrame.getInstance().getActionManager().getFormAction()
                        .putValue(Action.SHORT_DESCRIPTION, "Select a project");
            }

        }

    }

    public void selectNode(FrameNode frameNode)
    {

        TreeNode[] arr = ((WorkspaceTreeModel) getModel())
                .getPathToRoot(frameNode);

        TreePath path = new TreePath(arr);
        setSelectionPath(path);

    }

    public void selectElementNode(FrameView view)
    {
        ArrayList<TreePath> paths = new ArrayList<TreePath>();
        
        for(FrameElement elemNode : view.getFrameNode().selectionModel.getSelectedElements())
        {
            TreeNode[] arr = ((WorkspaceTreeModel) getModel())
                    .getPathToRoot(elemNode.getNode());

            paths.add(new TreePath(arr));
        }
        
        setSelectionPaths((TreePath[]) paths.toArray(new TreePath[paths.size()]));
        
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void expandNode(FrameNode frameNode)
    {
        TreeNode[] arr = ((WorkspaceTreeModel) getModel())
                .getPathToRoot(frameNode);

        TreePath path = new TreePath(arr);
        expandPath(path);

    }
    
    public ProjectNode getCurrentProject() {
        TreePath path = getSelectionPath();
        if(path != null)
        for(int i=0; i<path.getPathCount(); i++){
            if(path.getPathComponent(i) instanceof ProjectNode){
                return (ProjectNode)path.getPathComponent(i);
            }
        }
        return null;
    }

}
