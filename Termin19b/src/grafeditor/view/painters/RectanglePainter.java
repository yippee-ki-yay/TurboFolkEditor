package grafeditor.view.painters;

import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.RectangleElement;

import java.awt.geom.GeneralPath;

/**
 * Konkretan painter je zadužen za definisanje Shape objekta koji predstavlja dati element
 * @author Igor Z.
 *
 */
public class RectanglePainter extends DevicePainter{

	public RectanglePainter(DiagramElement device) {
		super(device);
		RectangleElement rectangle = (RectangleElement) device;

		shape=new GeneralPath();
		((GeneralPath)shape).moveTo(rectangle.getPosition().getX(),rectangle.getPosition().getY());
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getSize().width,rectangle.getPosition().getY());
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getSize().width,rectangle.getPosition().getY()+rectangle.getSize().height);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX(),rectangle.getPosition().getY()+rectangle.getSize().height);
		
		((GeneralPath)shape).closePath();

		
	}
	

	
}
