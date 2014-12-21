package painters;

import java.awt.geom.Ellipse2D;

import model.elements.FrameElement;

public class CirclePainter extends ElementPainter
{

	public CirclePainter(FrameElement elem) {
		super(elem);
		this.shape = new Ellipse2D.Float(elem.getPos().x, elem.getPos().y,
				                             elem.getSize().width, elem.getSize().height);
	}

}
