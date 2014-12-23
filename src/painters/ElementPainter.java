package painters;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

import model.elements.FrameElement;

public abstract class ElementPainter 
{
	protected Shape shape;
	
	public ElementPainter(FrameElement elem)
	{
		
	}

	public void paint(Graphics2D gg, FrameElement element)
	{
		//gg.setPaint(Color.BLACK);
		gg.setPaint(element.getPaint());
		gg.setStroke(element.getStroke());
		gg.draw(getShape());

		//gg.fill(getShape());
		
	}
	
	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	public boolean isElementAt(Point p)
	{
		return shape.contains(p);
	}
}
