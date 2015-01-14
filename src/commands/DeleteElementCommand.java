package commands;

import model.elements.FrameElement;

public class DeleteElementCommand implements Command
{

    FrameElement element = null;
    
    public DeleteElementCommand(FrameElement element)
    {
        this.element = element;
    }
    
    @Override
    public void undo()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doCommand()
    {
        // TODO Auto-generated method stub
        
    }

}
