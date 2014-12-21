package states;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import editorLook.MainFrame;

import model.ElementNode;
import model.FrameNode;
import model.ElementNode.ElemType;
import model.elements.ElementBuilder;
import model.elements.TriangleElement;

public class TriangleState implements State
{

	@Override
	public void draw(MouseEvent e, FrameNode node) {
		TriangleElement trig = new ElementBuilder().setPos(e.getPoint())
				                                   .buildTriangle();
		
		node.getModel().addElement(trig);
		
		ElementNode newNode = new ElementNode(node,"Triangle",ElemType.TRIANGLE);
		node.addElement(newNode);
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		
	}

}
