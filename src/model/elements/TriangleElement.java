package model.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import painters.TrianglePainter;

@SuppressWarnings("serial")
public class TriangleElement extends FrameElement
{

	public TriangleElement(Paint paint, Stroke stroke, Point pos, Dimension size, Color strokeColor) {
		super(paint, stroke, pos, size, strokeColor);
		
		this.elemPainter = new TrianglePainter(this);
		this.type = "Triangle";
	}

}
