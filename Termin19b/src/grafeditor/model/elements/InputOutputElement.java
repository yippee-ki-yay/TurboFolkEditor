package grafeditor.model.elements;

import grafeditor.view.painters.InputOutputPainter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

@SuppressWarnings("serial")
public class InputOutputElement extends DiagramElement{

	public static final int INPUT = 0;
	public static final int OUTPUT = 1;
	
	protected Point2D position;
	protected DiagramDevice device;
	
	protected int ioNo;
    protected int type;

	
		
	public InputOutputElement(Point2D position, Dimension size, Stroke stroke, Paint paint,Color strokeColor,
			                  DiagramDevice device, int ioNo, int type) {
		super( stroke, paint,strokeColor);
		
		this.device = device;
		this.ioNo = ioNo;
		this.type = type;
		this.position=position;
		elementPainter=new InputOutputPainter(this);
	}
	
	
	
	public static DiagramElement createDefault(Point2D pos,Stroke stroke , Paint paint,DiagramDevice device, 
			   int ioNo,   int type){
		Point2D position = (Point2D) pos.clone();
		position.setLocation(position.getX(), position.getY());
        InputOutputElement io=new InputOutputElement(position, 
        		                                     new Dimension(40,25),
        		                                     stroke, 
        		                                     paint,
        		                                     Color.BLUE,
        		                                     device,
        		                                     ioNo, 
        		                                     type);
        io.setName("IO" + ioNo);
		return io;
	}


	
	
	
	public Point2D getPosition() {
		return position;
	}


	public int getType() {
		return type;
	}
	
	

}
