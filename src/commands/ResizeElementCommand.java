package commands;

import java.awt.Point;

import model.elements.FrameElement;
import frame.FrameView;

public class ResizeElementCommand implements Command
{
    private FrameElement element;
    private FrameView view;
    private Point oldPos, newPos;
    private double oldScale;
    private double newSize;
    
    
    public ResizeElementCommand(FrameView view, FrameElement element, Point oldPos, 
                                     double oldScale)
    {
        this.view = view;
        this.element = element;
        this.oldScale = oldScale;
        this.newPos = element.getPos();
        this.oldPos = oldPos;
        this.newSize = element.getScale();
    }
    
    @Override
    public void undo()
    {
        element.setPos(oldPos);
        element.setScale(oldScale);
        
        view.repaint();

    }

    @Override
    public void doCommand()
    {
        element.setPos(newPos);
        element.setScale(newSize);
        
        view.repaint();
        
    }

}
