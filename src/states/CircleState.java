package states;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import editorLook.MainFrame;

import model.ElementNode;
import model.FrameNode;
import model.ElementNode.ElemType;
import model.elements.CircleElement;
import model.elements.ElementBuilder;

public class CircleState implements State
{

	@Override
	public void draw(MouseEvent e, FrameNode node) {
		
		if(node.getModel().isSpaceFree(e.getPoint()))
		{
			CircleElement circle = new ElementBuilder().setPos(e.getPoint())
                    .buildCircle();

			circle.setName("Circle" + MainFrame.element_id);
			circle.setDesc("Circle element");
			
			node.getModel().addElement(circle);

			ElementNode newNode = new ElementNode(node,"Circle"+ MainFrame.element_id, 
					ElemType.CIRCLE, circle);

			node.addElement(newNode);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
			
			circle.setNode(newNode);
			
			MainFrame.element_id++;
		}
		
		
	}

}
