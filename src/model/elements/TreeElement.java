package model.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import painters.TreePainter;

@SuppressWarnings("serial")
public class TreeElement extends FrameElement
{
	public TreeElement(Paint p, Stroke s, Point pos, Dimension size, Color strokeColor)
	{
		super(p, s, pos, size, strokeColor);
		this.elemPainter = new TreePainter(this);
		this.type = "Tree";
	}
}
