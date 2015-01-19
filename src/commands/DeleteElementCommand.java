package commands;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import model.elements.FrameElement;
import editorLook.MainFrame;
import frame.FrameView;

public class DeleteElementCommand implements Command
{

    FrameView view = null;
    ArrayList<FrameElement> frameList = new ArrayList<FrameElement>();
    
    public DeleteElementCommand(FrameView view, ArrayList<FrameElement> list)
    {
        this.view = view;
        
        for(FrameElement e : list)
        {
            frameList.add(e);
        }
    }
    
    @Override
    public void undo()
    {
        for(FrameElement e : frameList)
        {
            view.getFrameNode().getModel().addElement(e);
            view.getFrameNode().addElement(e.getNode());
        }
        
       
        view.getFrameNode().getModel().fireUpdatePreformed();
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
        
    }

    @Override
    public void doCommand()
    {
       for(FrameElement e : frameList)
       {
           view.getFrameNode().getModel().removeElement(e);
           view.getFrameNode().removeElement(e.getNode());
           view.getFrameNode().selectionModel.removeSelectedElement(e);
       }
       
       //izbacimo iz drveta i iz liste selektovanih
       
       view.getFrameNode().getModel().fireUpdatePreformed();
       SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
        
    }

}
