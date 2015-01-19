package states;

import java.awt.event.MouseEvent;

import frame.FrameView;

public class State
{
    public void draw(MouseEvent e, FrameView node){};

    public void drag(MouseEvent e, FrameView node){};

    public void released(MouseEvent e, FrameView node){};
    
    public void moved(MouseEvent e, FrameView node){};
    
    public void pressed(MouseEvent e, FrameView node){};
}
