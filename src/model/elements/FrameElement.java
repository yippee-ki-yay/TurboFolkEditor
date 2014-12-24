package model.elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import model.ElementNode;
import model.FrameNode;
import painters.ElementPainter;

public abstract class FrameElement 
{
	protected Paint paint;
	protected Stroke stroke;
	
	protected String name;
	protected String desc;
	
	protected Point pos;

	protected Dimension size;
	
	protected ElementPainter elemPainter;
	
	private ElementNode node;

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
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public ElementNode getNode() {
		return node;
	}

	public void setNode(ElementNode newNode) {
		this.node = newNode;
	}

}
