package painters;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import model.elements.FrameElement;

public abstract class ElementPainter implements Serializable
{
    private static final long serialVersionUID = 7919964081050823236L;

    protected Shape shape;
    protected FrameElement element;

    public ElementPainter(FrameElement elem)
    {
        this.element = elem;
    }

    public void paint(Graphics2D gg, FrameElement element)
    {
        // gg.setPaint(Color.BLACK);

        AffineTransform oldTransform = gg.getTransform();

        gg.translate(element.getPos().x, element.getPos().y);
        gg.rotate(element.getRotate(), element.getSize().width / 2,
                element.getSize().height / 2);
        gg.scale(element.getScale(), element.getScale());

        gg.setPaint(element.getStrokeColor()); 
        gg.setStroke(element.getStroke());
        gg.draw(getShape());
        
        gg.setPaint(element.getPaint());
        gg.fill(getShape()); 


        // gg.fill(getShape());
        gg.setTransform(oldTransform);
      

    }

    public Shape getShape()
    {
        return shape;
    }

    public void setShape(Shape shape)
    {
        this.shape = shape;
    }

    public boolean isElementAt(Point p)
    {
        Rectangle2D rect = new Rectangle2D.Double();
        rect.setRect(element.getPos().getX(), element.getPos().getY(), element
                .getSize().getWidth(), element.getSize().getHeight());
        return rect.contains(p);
    }
}
