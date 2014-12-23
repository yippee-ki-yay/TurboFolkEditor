package model.elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import painters.TreePainter;

public class TreeElement extends FrameElement
{
	public TreeElement(Paint p, Stroke s, Point pos, Dimension size)
	{
		super(p, s, pos, size);
		this.elemPainter = new TreePainter(this);
	}
}
