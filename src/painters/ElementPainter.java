package painters;

import java.awt.Color;
import java.awt.Graphics2D;
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
		gg.setPaint(Color.RED);

		gg.setStroke(element.getStroke());
		gg.draw(getShape());
		gg.setPaint(element.getPaint());

		gg.fill(getShape());
		
	}
	
	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
}
