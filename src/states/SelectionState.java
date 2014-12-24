package states;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import model.FrameNode;
import model.elements.FrameElement;
import editorLook.MainFrame;

public class SelectionState implements State {

	@Override
	public void draw(MouseEvent e, FrameNode node) {
		// TODO Auto-generated method stub

		if(!e.isControlDown())
			node.selectionModel.removeAllSelectedElements();
		
		if (e.getClickCount() == 1) 
		{
			//uzmemo point i proverimo da li je ubo neki element pa taj dodamo u listu
			Point pos = e.getPoint();

			FrameElement clickedElement = node.getModel().getElementAt(pos);
			if (clickedElement != null) 
			{
				//YOLO, SWAG
				if(!node.selectionModel.isElementSelected(clickedElement))
				  node.selectionModel.addSelectedElement(clickedElement);
				else
				  node.selectionModel.removeSelectedElement(clickedElement);
				
				node.getModel().fireUpdatePreformed();
			}
			else
			{
				node.selectionModel.removeAllSelectedElements();
				node.getModel().fireUpdatePreformed();
			}

		} else if (e.getClickCount() == 2) 
		{
			Point pos = e.getPoint();

			// if on that pos is an element, get that elem and start dialog
			FrameElement clickedElement = node.getModel().getElementAt(pos);
			if (clickedElement != null) {
				MainFrame.getInstance().getPropertyDialog()
						.setCurrElement(clickedElement);
				node.getModel().fireUpdatePreformed();
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
						.getWorkspaceTree());
			}
		}

	}

}
