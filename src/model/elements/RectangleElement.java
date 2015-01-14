package model.elements;


import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import painters.RectanglePainter;

@SuppressWarnings("serial")
public class RectangleElement extends FrameElement
{
	
	public RectangleElement(Paint paint, Stroke stroke, Point pos, Dimension size) {
		super(paint, stroke, pos, size);
		this.elemPainter = new RectanglePainter(this);
		this.type = "Rectangle";
	}

}
