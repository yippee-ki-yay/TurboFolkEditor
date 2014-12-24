package grafeditor.state;

import grafeditor.model.elements.DiagramDevice;
import grafeditor.model.elements.RectangleElement;
import grafeditor.view.DiagramView;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class RectangleState extends State{
	private DiagramView med; 
	public RectangleState(DiagramView md) {
      	med = md;
	}

	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		if (e.getButton()==MouseEvent.BUTTON1){
			 if (med.getDiagram().getModel().getElementAtPosition(position)==-1){
				 DiagramDevice device = RectangleElement.createDefault(position,med.getDiagram().getModel().getElementsCount());
				 med.getDiagram().getModel().addDiagramElement(device);
			 }
		}
	}
}
