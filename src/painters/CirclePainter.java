package painters;

import java.awt.geom.Ellipse2D;

import model.elements.FrameElement;

@SuppressWarnings("serial")
public class CirclePainter extends ElementPainter
{

	public CirclePainter(FrameElement elem) {
		super(elem);
		this.shape = new Ellipse2D.Float(0, 0,
				                             elem.getSize().width, elem.getSize().height);
	}

}
