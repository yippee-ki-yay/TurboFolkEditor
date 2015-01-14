package painters;

import java.awt.geom.GeneralPath;
import java.util.Random;

import model.elements.FrameElement;

@SuppressWarnings("serial")
public class TrianglePainter extends ElementPainter
{

    Random rand = new Random();

    public TrianglePainter(FrameElement elem)
    {
        super(elem);

        Turtle t = new Turtle(elem.getSize().getWidth()/2, 0);
        // elem.setPos(new Point((int)elem.getSize().getWidth()/2,
        // elem.getPos().y));
        t.turnLeft(60);
        t.forward(elem.getSize().getWidth());
        t.turnLeft(120);
        t.forward(elem.getSize().getWidth());
        t.turnLeft(120);
        t.forward(elem.getSize().getWidth());

        GeneralPath trougao = new GeneralPath();
        trougao.moveTo(elem.getPos().x, elem.getPos().y);
        trougao.lineTo(elem.getPos().x - 10, elem.getPos().y + 30);
        trougao.lineTo(elem.getPos().x + 15, elem.getPos().y + 30);
        trougao.closePath();

        this.shape = t.getG();
    }

}
