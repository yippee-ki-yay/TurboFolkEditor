package model.elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;


import painters.ElementPainter;

public abstract class FrameElement 
{
	protected Paint paint;
	protected Stroke stroke;
	
	protected String name;
	
	protected Point pos;

	protected Dimension size;
	
	protected ElementPainter elemPainter;

	public FrameElement(Paint paint, Stroke stroke, Point pos, Dimension size) {
		super();
		this.paint = paint;
		this.stroke = stroke;
		this.pos = pos;
		this.size = size;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}
	
	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public ElementPainter getElemPainter() {
		return elemPainter;
	}

	public void setElemPainter(ElementPainter elemPainter) {
		this.elemPainter = elemPainter;
	}

}
