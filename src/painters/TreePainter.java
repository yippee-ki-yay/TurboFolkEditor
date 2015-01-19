package painters;

import model.elements.FrameElement;

@SuppressWarnings("serial")
public class TreePainter extends ElementPainter
{

    public TreePainter(FrameElement elem)
    {
        super(elem);
        Turtle t = new Turtle(50, 105);
        t.turnRight(90);

        tree(t, 30);

        this.shape = t.getG();
    }

    private void tree(Turtle t, int length)
    {
        if (length > 2)
        {
            t.forward(length);
            t.turnRight(20);
            tree(t, length - 5);
            t.turnLeft(40);
            tree(t, length - 5);
            t.turnRight(20);
            t.backward(length);
        }
    }

}
