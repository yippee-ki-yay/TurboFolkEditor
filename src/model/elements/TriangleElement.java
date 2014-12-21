package model.elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import painters.TrianglePainter;

public class TriangleElement extends FrameElement
{

	public TriangleElement(Paint paint, Stroke stroke, Point pos, Dimension size) {
		super(paint, stroke, pos, size);
		
		this.elemPainter = new TrianglePainter(this);
	}

}
