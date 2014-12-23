package states;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import model.ElementNode;
import model.ElementNode.ElemType;
import model.FrameNode;
import model.elements.ElementBuilder;
import model.elements.TreeElement;
import editorLook.MainFrame;

public class TreeState implements State
{

	@Override
	public void draw(MouseEvent e, FrameNode node) {
		
		if(node.getModel().isSpaceFree(e.getPoint()))
		{
			TreeElement tree = new ElementBuilder().setPos(e.getPoint())
                    .setPaint(new Color(0, 255, 0)).buildTree();

			node.getModel().addElement(tree);

			ElementNode newNode = new ElementNode(node,"Tree", ElemType.TREE);
			node.addElement(newNode);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		}
		
		
	}

}
