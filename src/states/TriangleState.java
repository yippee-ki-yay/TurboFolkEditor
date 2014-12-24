package states;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import model.ElementNode;
import model.ElementNode.ElemType;
import model.FrameNode;
import model.elements.ElementBuilder;
import model.elements.TriangleElement;
import editorLook.MainFrame;

public class TriangleState implements State
{

	@Override
	public void draw(MouseEvent e, FrameNode node) {
		if(node.getModel().isSpaceFree(e.getPoint()))
		{
			TriangleElement trig = new ElementBuilder().setPos(e.getPoint()).buildTriangle();
			
			trig.setName("Triangle" + MainFrame.element_id);
			trig.setDesc("Triangle element");
			
			node.getModel().addElement(trig);
			
			ElementNode newNode = new ElementNode(node,"Triangle"+ MainFrame.element_id,
					ElemType.TRIANGLE, trig);
			newNode.setName("Triangle" + MainFrame.element_id);
			node.addElement(newNode);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
			trig.setNode(newNode);
			
			MainFrame.element_id++;
		}
		
		
	}

}
