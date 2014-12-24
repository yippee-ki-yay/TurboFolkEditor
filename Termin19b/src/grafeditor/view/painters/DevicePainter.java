package grafeditor.view.painters;



import grafeditor.model.elements.DiagramDevice;
import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.InputOutputElement;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.Iterator;

/**
 * DevicePainter je zadužen za crtanje uređaja kao i za detekciju pogotka
 * za sta koristi Shape.
 * @author igor
 *
 */
@SuppressWarnings("serial")
public class DevicePainter extends ElementPainter {
	
	
	
	public DevicePainter(DiagramElement device){
		super(device);
	}
	
	
	public void paint(Graphics2D g, DiagramElement element){


		if (element instanceof DiagramDevice){
			//ako se iscrtava element, trebaju da se iscrtaju i njegovi ulazi i izlazi 
			Iterator<InputOutputElement> it = ((DiagramDevice)element).getInputIterator();
			while(it.hasNext()){
				InputOutputElement d = (InputOutputElement) it.next();
				d.getPainter().paint(g,d);
			}
	  
			Iterator<InputOutputElement> it2 = ((DiagramDevice)element).getOutputIterator();
			while(it2.hasNext()){
				InputOutputElement d2 = (InputOutputElement) it2.next();
				d2.getPainter().paint(g,d2);
			}
		}	
	  

		
		g.setPaint(element.getStrokeColor());
		g.setStroke(element.getStroke());
		g.draw(getShape());

		g.setPaint(element.getPaint());
		g.fill(getShape());	
	}
	
	public boolean isElementAt( Point pos){
		return getShape().contains(pos);
	}



	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
