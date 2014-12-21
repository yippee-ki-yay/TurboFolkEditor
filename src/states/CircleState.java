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
		// TODO Auto-generated method stub
		CircleElement circle = new ElementBuilder().setPos(e.getPoint())
				                                    .buildCircle();
		
		node.getModel().addElement(circle);
		
		ElementNode newNode = new ElementNode(node,"Circle", ElemType.CIRCLE);
		node.addElement(newNode);
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		
	}

}
