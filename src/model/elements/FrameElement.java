package model.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.io.Serializable;

import model.ElementNode;
import painters.ElementPainter;
import serialization.SerializableStrokeAdapter;

public abstract class FrameElement implements Serializable 
{
	private static final long serialVersionUID = -2270785075856091231L;
	
	protected Paint paint;
    protected SerializableStrokeAdapter stroke;
	
	protected String name;
	protected String desc;
	protected String type;
	
	protected Point pos;

	protected Dimension size;
	
	protected double scale;
	protected double rotate;
	protected double translateX;
	protected double translateY;
	
	protected ElementPainter elemPainter;
	protected Color strokeColor;
	
    private ElementNode node;

	public FrameElement(Paint paint, Stroke stroke, Point pos, Dimension size, Color strokeColor) {
		super();
		this.paint = paint;
		setStroke(stroke);
		this.pos = pos;
		this.size = size;
		this.strokeColor = strokeColor;
		this.scale = 1;
		this.rotate = 0;
		this.translateX = 0;
		this.translateY = 0;
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
		this.stroke = new SerializableStrokeAdapter(stroke);
	}
	
	   public Color getStrokeColor() {
	        return strokeColor;
	    }

	    public void setStrokeColor(Color strokeColor) {
	        this.strokeColor = strokeColor;
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
	
	public Dimension getInitSize()
	{
	    return size;
	}
	
	public Dimension getSize() 
	{
		Dimension tmp = new Dimension();
		//resizujemo sa scale parametrom
		tmp.setSize(size.width*getScale(), size.height*getScale()); 
		return tmp;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public double getRotate() {
		return rotate;
	}

	public void setRotate(double rotate) {
	    if(Math.abs(rotate - 2*Math.PI) < 0.01 || Math.abs(rotate + 2*Math.PI) < 0.01)
            rotate = 0;
		this.rotate = rotate;
	}

	public double getTranslateX() {
		return translateX;
	}

	public void setTranslateX(double translateX) {
		this.translateX = translateX;
	}

	public double getTranslateY() {
		return translateY;
	}

	public void setTranslateY(double translateY) {
		this.translateY = translateY;
	}

	

}
