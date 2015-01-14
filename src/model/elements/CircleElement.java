package model.elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import painters.CirclePainter;

@SuppressWarnings("serial")
public class CircleElement extends FrameElement
{
    public CircleElement(Paint p, Stroke s, Point pos, Dimension size)
    {
        super(p, s, pos, size);
        this.elemPainter = new CirclePainter(this);
        this.type = "Circle";
    }
}
