package editorLook;




import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.HashMap;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class FormManager extends JDesktopPane
{	
	private static final long serialVersionUID = 4178080838523837768L;
	
	
	HashMap<Integer, DefaultForm> frames;
	
	FormLayoutManager layout;

	public FormManager()
	{
		frames = new HashMap<Integer, DefaultForm>();
		setMinimumSize(new Dimension((int) MainFrame.getInstance().getSize().getWidth() - 350, 1));
		layout = new FormLayoutManager(this);
	}
	
	public void addFrame(String title, int count) 
	{
		DefaultForm newForm = new DefaultForm(title, count);
		frames.put(count, newForm);
		
		layout.add(newForm);
		newForm.toFront();  //ovakve fije koje uticu na frejm moramo pozvati posle add()
	}

	public void selectNext()
	{
		JInternalFrame frames[] = getAllFrames();
		if(frames.length != 0)
		{
			JInternalFrame frame = selectFrame(false);
			if(frame == null)return;
		}
	}
	
	public void selectPrevious()
	{
		JInternalFrame frames[] = getAllFrames();
		if(frames.length != 0)
		{
			JInternalFrame frame = selectFrame(true);
			if(frame == null)return;
		}	
	}
	
	public void Minimize()
	{
		JInternalFrame frame = getSelectedFrame();
		
		if(frame == null)return;
		
		try {
			frame.setIcon(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Maximize()
	{
		JInternalFrame frame = getSelectedFrame();
		
		if(frame == null)return;
		
		try {
			frame.setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void selectFrame(String frameName)
	{
		JInternalFrame frames[] = getAllFrames();
			
		for(int i = 0; i < frames.length; i++)
		{
			if(frames[i].getTitle().equals(frameName))
			{
				try {
					frames[i].setSelected(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void selectFrame(int id)
	{
		try {
			frames.get(id).setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isSomeoneSelected()
	{
		JInternalFrame frames[] = getAllFrames();
		
		for(int i = 0; i < frames.length; i++)
		{
			if(frames[i].isSelected())
			{
				return true;
			}
		}
		
		return false;
	}
	
	//TODO srsly bro? 
	public String getSlectedFrame()
	{
		//nemamo selektovanih frejmova
		if(getSelectedFrame() == null)
		{
			//probaj da selektujes bar neki frejm
		}
		
		return getSelectedFrame().getTitle();
				
	}
	
	public void deleteSelected()
	{
		if(isSomeoneSelected())
		getSelectedFrame().dispose();
	}
	
	
	
	public FormLayoutManager getLayoutManager() {
		return layout;
	}

	public void setLayoutManager(FormLayoutManager layout) {
		this.layout = layout;
	}
}
