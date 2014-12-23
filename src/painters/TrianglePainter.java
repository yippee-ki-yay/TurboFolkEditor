package painters;

import java.awt.geom.GeneralPath;
import java.util.Random;

import model.elements.FrameElement;

public class TrianglePainter extends ElementPainter {

	Random rand = new Random();
	
	public TrianglePainter(FrameElement elem) {
		super(elem);
		
		GeneralPath trougao = new GeneralPath();
		trougao.moveTo(elem.getPos().x, elem.getPos().y);
		trougao.lineTo(elem.getPos().x-10, elem.getPos().y+30);
		trougao.lineTo(elem.getPos().x+15, elem.getPos().y+30);
		trougao.closePath();
		
		
		this.shape = trougao;
	}
	
	

}
