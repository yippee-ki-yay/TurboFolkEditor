package grafeditor.view.painters;

import grafeditor.model.elements.CircleElement;
import grafeditor.model.elements.DiagramElement;

import java.awt.geom.Ellipse2D;

/**
 * Konkretan painter je zadužen za definisanje Shape objekta koji predstavlja dati element
 * @author Igor Z.
 *
 */
public class CirclePainter extends DevicePainter{

	public CirclePainter(DiagramElement device) {
		super(device);
		CircleElement circle = (CircleElement) device;
		shape=new Ellipse2D.Double(circle.getPosition().getX(), circle.getPosition().getY(), circle.getSize().getHeight(), circle.getSize().getHeight());
		

		
	}
	

	
}
