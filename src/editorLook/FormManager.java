package editorLook;



import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public class FormManager extends JDesktopPane
{	
	
	public FormManager()
	{
		
	}
	
	public void addFrame(String name)
	{
		DefaultForm newForm = new DefaultForm(name);
		add(newForm);
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
	
}
