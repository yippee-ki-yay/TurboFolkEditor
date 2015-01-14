package states;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import model.elements.FrameElement;
import editorLook.MainFrame;
import frame.FrameView;

public class SelectionState extends State
{

    @Override
    public void draw(MouseEvent e, FrameView node)
    {
        Point pos = node.pointToUserSpace(e.getPoint());

        if (!e.isControlDown())
        {
            node.getFrameNode().selectionModel.removeAllSelectedElements();
            node.getFrameNode().selectionModel.setMultiSelection(false);
        }

        if (e.getClickCount() == 1)
        {
            // uzmemo point i proverimo da li je ubo neki element pa taj dodamo
            // u listu

            FrameElement clickedElement = node.getFrameNode().getModel()
                    .getElementAt(pos);

            if (clickedElement != null)
            {
                node.getFrameNode().selectionModel.setMultiSelection(true);

                // YOLO, SWAG
                if (!node.getFrameNode().selectionModel
                        .isElementSelected(clickedElement))
                    node.getFrameNode().selectionModel
                            .addSelectedElement(clickedElement);
                else
                {
                    node.getFrameNode().selectionModel
                    .removeSelectedElement(clickedElement);
                }
                    

                node.getFrameNode().getModel().fireUpdatePreformed();
                MainFrame.getInstance().getWorkspaceTree()
                        .selectElementNode(clickedElement.getNode());
            } else
            {
                node.getFrameNode().selectionModel.removeAllSelectedElements();
                node.getFrameNode().getModel().fireUpdatePreformed();
            }

        } else if (e.getClickCount() == 2)
        {

            // if on that pos is an element, get that elem and start dialog
            FrameElement clickedElement = node.getFrameNode().getModel()
                    .getElementAt(pos);
            if (clickedElement != null)
            {
                MainFrame.getInstance().getPropertyDialog()
                        .setCurrElement(clickedElement);
                node.getFrameNode().getModel().fireUpdatePreformed();
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
                        .getWorkspaceTree());
            }
        }

    }

    @Override
    public void drag(MouseEvent e, FrameView node)
    {

        Point pos = node.pointToUserSpace(e.getPoint());

        FrameElement dragedElement = node.getFrameNode().selectionModel
                .getSelectedElement();

        if (dragedElement != null)
        {
           if( node.getHandleFromPoint(pos) != null)
               node.getStateManager().setResizeState();
           else
            node.getStateManager().setMoveState();
        }

    }

    @Override
    public void released(MouseEvent e, FrameView node)
    {
        // TODO Auto-generated method stub

    }
    
    @Override
    public void moved(MouseEvent e, FrameView frame)
    {
       frame.setMouseCursor(frame.pointToUserSpace(e.getPoint()));
    }

}
