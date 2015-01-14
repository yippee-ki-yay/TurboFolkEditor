package states;

import java.awt.Point;
import java.awt.event.MouseEvent;

import model.ElementNode.ElemType;

import commands.AddElementCommand;

import frame.FrameView;

public class RectangleState extends State
{

    @Override
    public void draw(MouseEvent e, FrameView node)
    {

        Point pos = node.pointToUserSpace(e.getPoint());
        if (node.getFrameNode().getModel().isSpaceFree(pos))
        {
            node.getCommandManager().add(
                    new AddElementCommand(node, ElemType.RECTANGLE, pos));
        }

    }

    @Override
    public void drag(MouseEvent e, FrameView node)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void released(MouseEvent e, FrameView node)
    {
        // TODO Auto-generated method stub

    }

}
