package grafeditor.model.elements;


import grafeditor.view.painters.CirclePainter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

public class CircleElement extends DiagramDevice {

	public CircleElement(Point2D position, Dimension size, Stroke stroke, Paint paint,Color strokeColor) {
		super(position, size, stroke, paint,strokeColor,5,5);
		
		elementPainter = new CirclePainter(this);
		

	}

	
	public static DiagramDevice createDefault(Point2D pos, int elemNo){
		Point2D position = (Point2D) pos.clone();
		
        Paint fill = Color.WHITE;
	    CircleElement or=new CircleElement(position, 
	    		                   new Dimension(50,50),
	    		                   new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),
	    		                   fill,
	    		                   Color.BLACK);
        or.setName("Circle " + elemNo);
		return or;
	}

}
