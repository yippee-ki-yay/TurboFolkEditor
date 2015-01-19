package commands;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.SwingUtilities;

import model.ElementNode;
import model.ElementNode.ElemType;
import model.ProjectNode;
import model.elements.ElementBuilder;
import model.elements.FrameElement;
import editorLook.MainFrame;
import frame.FrameView;

public class AddElementCommand implements Command
{

    private ElemType type;
    private FrameView frame;
    private Point pos;

    private FrameElement elem = null;
    private ElementNode elemNode = null;

    public AddElementCommand(FrameView node, ElemType type, Point pos)
    {
        this.frame = node;
        this.type = type;
        this.pos = pos;
    }

    @Override
    public void undo()
    {
        frame.getFrameNode().selectionModel.removeAllSelectedElements();
        frame.getFrameNode().getModel().removeElement(elem);
        frame.getFrameNode().removeElement(elemNode);
        MainFrame.element_id--;
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
                .getWorkspaceTree());

    }

    @Override
    public void doCommand()
    {
        
        // Napravimo samo jednu istancu elem i elemNoda
        if (elem == null && elemNode == null)
        {
            if (type == ElemType.RECTANGLE)
            {
             //   if (frame.getFrameNode().getModel().isSpaceFree(pos))
                {
                    elem = new ElementBuilder().setPosCenter(pos).
                            setSize(new Dimension(80, 50)).buildRectangle();

                    // Nova instanca noda u drvetu
                    elemNode = new ElementNode(frame.getFrameNode(), "Rectangle"
                            + MainFrame.element_id, ElemType.RECTANGLE, elem);
                }

            } else if (type == ElemType.CIRCLE)
            {
              //  if (frame.getFrameNode().getModel().isSpaceFree(pos))
                {
                    elem = new ElementBuilder().setPosCenter(pos).buildCircle();

                    elemNode = new ElementNode(frame.getFrameNode(), "Circle"
                            + MainFrame.element_id, ElemType.CIRCLE, elem);

                }
            } else if (type == ElemType.TRIANGLE)
            {
               // if (frame.getFrameNode().getModel().isSpaceFree(pos))
                {
                    elem = new ElementBuilder().setPosCenter(pos)
                            .buildTriangle();

                    elemNode = new ElementNode(frame.getFrameNode(), "Triangle"
                            + MainFrame.element_id, ElemType.TRIANGLE, elem);

                }
            } else if (type == ElemType.TREE)
            {
              //  if (frame.getFrameNode().getModel().isSpaceFree(pos))
                {
                    elem = new ElementBuilder().setPosCenter(pos)
                            .setStrokeColor(new Color(0, 255, 0)).setSize(new Dimension(100, 110))
                            .buildTree();

                    elemNode = new ElementNode(frame.getFrameNode(), "Tree"
                            + MainFrame.element_id, ElemType.TREE, elem);
                }

            }
        
        }
        // Ubacimo naziv i desc elementa i dodamo ga u listu elementa
        elem.setName(elem.getType() + MainFrame.element_id);
        elem.setDesc(elem.getType() + " element");
        frame.getFrameNode().getModel().addElement(elem);

        // dodamo u drvo tu instancu i povezemo element sa elemenNode
        frame.getFrameNode().addElement(elemNode);
        elem.setNode(elemNode);

        // osvezimo iscrtacanje prozora i drveta i updejtujemo brojac elementa
        frame.getFrameNode().getModel().fireUpdatePreformed();
        ProjectNode.updateChanged(true);
        MainFrame.element_id++;
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
                .getWorkspaceTree());
        

    }

}
