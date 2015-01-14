package states;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import model.elements.FrameElement;
import editorLook.MainFrame;
import frame.FrameView;

public class MoveState extends State
{

	@Override
	public void draw(MouseEvent e, FrameView node) 
	{		
	}

	@Override
	public void drag(MouseEvent e, FrameView node) 
	{
		node.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		
		Point pos = node.pointToUserSpace(e.getPoint());
		
		//za koliko smo se pomerili od tacke gde smo kliknuli do sadasnje tacke
		int dx = node.getPocetnaTacka().x - pos.x;
		int dy = node.getPocetnaTacka().y - pos.y;
		
		for(FrameElement dragedElement : node.getFrameNode().selectionModel.getSelectedElements())
		{
		
      //  FrameElement dragedElement = node.getFrameNode().selectionModel.getSelectedElement();
		
		if(dragedElement != null)
		{
		
			//postavi element na poziciji kojoj je bio + za koliko se pomerio
			Point2D newPosition = (Point2D)dragedElement.getPos().clone();
			newPosition.setLocation(newPosition.getX()-dx,
					newPosition.getY() - dy);
	
		
			dragedElement.setPos((Point) newPosition);
			
			//updejtuj status bar kad pomeras elemnt
			String status_pos = "x: " + (int)(newPosition.getX()-dx) +  " y: " + 
			                                      (int)(newPosition.getY()-dy);
			MainFrame.getInstance().getStatusBar().setPos(status_pos);
			
		}
		}
		node.setPocetnaTacka(pos);
		
		
		node.repaint();
		
		
	}

	@Override
	public void released(MouseEvent e, FrameView node) {
		// TODO Auto-generated method stub
		node.getStateManager().setSelectionState();
		node.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	
		
	}

}
