package states;


import java.awt.Point;
import java.awt.event.MouseEvent;

import model.ElementNode.ElemType;

import commands.AddElementCommand;

import frame.FrameView;

public class TriangleState extends State
{

	@Override
	public void draw(MouseEvent e, FrameView frame) 
	{
		Point pos = frame.pointToUserSpace(e.getPoint());
		
        if (frame.getFrameNode().getModel().isSpaceFree(pos))
        {
            frame.getCommandManager().add(new AddElementCommand(frame, ElemType.TRIANGLE, pos));
        }
		
	}

	@Override
	public void drag(MouseEvent e, FrameView node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void released(MouseEvent e, FrameView node) {
		// TODO Auto-generated method stub
		
	}

}
