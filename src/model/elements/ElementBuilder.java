package model.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

public class ElementBuilder 
{
	Paint paint  = new Color(255, 255, 255);
	Stroke stroke = new BasicStroke(2f);
	Point pos = new Point(0, 0);
	Dimension size = new Dimension(20,20);
	
	public RectangleElement buildRectangle()
	{	
		return new RectangleElement(paint, stroke, pos, size);
	}
	
	public CircleElement buildCircle()
	{
		return new CircleElement(paint, stroke, pos, size);
	}
	
	public TriangleElement buildTriangle()
	{
		return new TriangleElement(paint, stroke, pos, size);
	}
	
	public ElementBuilder setPaint(Paint p)
	{
		this.paint = p;
		return this;
	}
	
	public ElementBuilder setPos(Point p)
	{
		this.pos = p;
		return this;
	}
	
	public ElementBuilder setStroke(Stroke s)
	{
		this.stroke = s;
		return this;
	}
	
	public ElementBuilder setSize(Dimension size)
	{
		this.size = size;
		return this;
	}
	
	
}
