package commands;

import java.util.ArrayList;

import model.elements.FrameElement;
import frame.FrameView;

public class RotateElementCommand implements Command
{

    private ArrayList<FrameElement> frameList = new ArrayList<FrameElement>();
    private FrameView view;
    private ArrayList<Double> rotateAngle = new ArrayList<Double>();
    private ArrayList<Double> prevAngle = new ArrayList<Double>();
    
    public RotateElementCommand(FrameView view, ArrayList<FrameElement> list, double rotate)
    {
        for(int i = 0; i < list.size(); ++i)
        {
            this.prevAngle.add(i, list.get(i).getRotate());
            this.rotateAngle.add(i, list.get(i).getRotate() - rotate);
            frameList.add(list.get(i));
        }

        this.view = view;
    }
    
    @Override
    public void undo()
    {
        for(int i = 0; i < frameList.size(); ++i)
        {
            frameList.get(i).setRotate(prevAngle.get(i));
        }
        
        view.repaint();
    }

    @Override
    public void doCommand()
    {
        for(int i = 0; i < frameList.size(); ++i)
        {
            frameList.get(i).setRotate(rotateAngle.get(i));
        }
       view.repaint();
        
    }

}
