package commands;

import java.util.ArrayList;

import editorLook.MainFrame;

//TODO: YOU KNOW

public class CommandManager 
{
	private int idx = 0;
	private ArrayList<Command> commandList = new ArrayList<Command>();
	
	public CommandManager()
	{
		
	}
	
	public void add(Command c)
	{	
	    //bez ovoga moras prvo redovati sve komande da bi posle novu izvrsio
	  /*  
	    while(idx < commandList.size())
	    {
	        commandList.remove(idx);
	       
	    }*/
           
	    idx = commandList.size();
	    
		commandList.add(c);
		doCommand();
	}
	
	public void doCommand()
	{
		if(idx  < commandList.size()){
			commandList.get(idx ++).doCommand();
			MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
		}
		if(idx ==commandList.size()){
			MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
			
		};
	}
	
	public void undoCommand()
	{
		if(idx  > 0){
			MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
			
		/*	if(((AddElementCommand)commandList.get(--idx )).undoovanje == true)
			    commandList.get(--idx ).doCommand();
			else*/
			    commandList.get(--idx ).undo();
			
		}
		if(idx ==0){
			MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
		}
	}
	
}
