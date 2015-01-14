package states;

import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import frame.FrameView;

public class LassoState extends State
{

    private Rectangle2D.Double rec = new Rectangle2D.Double();

    @Override
    public void drag(MouseEvent e, FrameView node)
    {
        // TODO Auto-generated method stub

       // Point currPos = e.getPoint();

       // int width = node.getPocetnaTacka().x - currPos.x;
        //int height = node.getPocetnaTacka().y - currPos.y;

        // rec.setRect(node.getPocetnaTacka().x, node.getPocetnaTacka().y,
        // Math.abs(width), Math.abs(height));

        /*
         * if((width < 0) && (height < 0)) // kad povlacimo dole levo {
         * rec.setRect(currPos.getX(), currPos.getY(), Math.abs(width),
         * Math.abs(height)); }
         */

        // rec.setRect(100, 100, 20, 20);

        node.setSelectionRectangle(rec);
        node.repaint();
    }

    @Override
    public void released(MouseEvent e, FrameView node)
    {
        rec.setRect(0, 0, 0, 0); // kad se klik pusti treba da nestane lasso
                                 // pravougaonik
        node.repaint();

    }

    @Override
    public void draw(MouseEvent e, FrameView node)
    {
        // TODO Auto-generated method stub

    }

}
