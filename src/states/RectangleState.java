package states;

import java.awt.event.MouseEvent;
import java.lang.annotation.ElementType;

import javax.swing.SwingUtilities;

import editorLook.MainFrame;

import model.ElementNode;
import model.ElementNode.ElemType;
import model.FrameNode;
import model.elements.ElementBuilder;
import model.elements.RectangleElement;

public class RectangleState implements State
{

	@Override
	public void draw(MouseEvent e, FrameNode node) {
		RectangleElement rec = new ElementBuilder().
				setPos(e.getPoint()).buildRectangle();
		
		node.getModel().addElement(rec);
		
		ElementNode newNode = new ElementNode(node, "Rectangle", ElemType.RECTANGLE);
		node.addElement(newNode);
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		
	}

}
