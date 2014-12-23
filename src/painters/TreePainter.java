package painters;

import java.util.Random;

import model.elements.FrameElement;

public class TreePainter extends ElementPainter
{

	Random rand = new Random();
	
	public TreePainter(FrameElement elem) {
		super(elem);
		Turtle t = new Turtle(elem.getPos().x, elem.getPos().y);
		t.turnRight(90);
		
		tree(t, 30);
		
		this.shape = t.getG();
	}
	
	private void tree(Turtle t, int length)
	{
		if(length > 2) 
		{
			 int  n = (rand.nextInt((30 - 17) + 1) + 17);
			 t.forward(length);
		     t.turnRight(n);
		     tree(t, length-(rand.nextInt((6 - 2) + 1) + 2));
		     t.turnLeft(2*n);
		     tree(t, length-(rand.nextInt((6 - 2) + 1) + 2));
		     t.turnRight(n);
		     t.backward(length);
		}
	}
	        

}
