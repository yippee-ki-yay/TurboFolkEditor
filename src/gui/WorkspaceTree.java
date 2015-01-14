package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import editorLook.MainFrame;

public class WorkspaceTree extends JTree implements TreeSelectionListener
{
    private static final long serialVersionUID = 4103080408620022917L;

  //  private boolean ctrlDown = false;

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

                if (e.getClickCount() == 2)
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
             //   if (e.isControlDown()) ctrlDown = true;
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
              //  if (e.getID() == e.CTRL_MASK) ctrlDown = false;
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
            } else if (o instanceof ElementNode) // TODO problem oko multi
                                                 // selekcije
            {
                /*
                 * ElementNode node = (ElementNode)o; if(!ctrlDown ||
                 * !((FrameNode
                 * )node.getParent()).selectionModel.isMultiSelection())
                 * ((FrameNode
                 * )node.getParent()).selectionModel.removeAllSelectedElements
                 * ();
                 * 
                 * //YOLO, SWAG
                 * if(!((FrameNode)node.getParent()).selectionModel.
                 * isElementSelected(node.getElement()))
                 * ((FrameNode)node.getParent
                 * ()).selectionModel.addSelectedElement(node.getElement());
                 * else ((FrameNode)node.getParent()).selectionModel.
                 * removeSelectedElement(node.getElement());
                 * 
                 * ((FrameNode)node.getParent()).getModel().fireUpdatePreformed()
                 * ;
                 */
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

    public void selectElementNode(ElementNode elemNode)
    {
        TreeNode[] arr = ((WorkspaceTreeModel) getModel())
                .getPathToRoot(elemNode);

        TreePath path = new TreePath(arr);
        setSelectionPath(path);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void expandNode(FrameNode frameNode)
    {
        TreeNode[] arr = ((WorkspaceTreeModel) getModel())
                .getPathToRoot(frameNode);

        TreePath path = new TreePath(arr);
        expandPath(path);

    }

}
