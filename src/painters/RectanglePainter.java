package painters;

import java.awt.geom.Rectangle2D;

import model.elements.FrameElement;
import model.elements.RectangleElement;

public class RectanglePainter extends ElementPainter
{
	public RectanglePainter(FrameElement elem)
	{
	  super(elem);
	  RectangleElement rec = (RectangleElement)elem;
	  this.shape = new Rectangle2D.Float(rec.getPos().x, rec.getPos().y,  
			                        rec.getSize().width, rec.getSize().height);
	}
}
