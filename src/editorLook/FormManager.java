package editorLook;




import java.awt.Dimension;
import java.awt.LayoutManager;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public class FormManager extends JDesktopPane
{	
	FormLayoutManager layout;

	public FormManager()
	{
		setMinimumSize(new Dimension((int) MainFrame.getInstance().getSize().getWidth() - 350, 1));
		layout = new FormLayoutManager(this);
	}
	
	public void addFrame(String name) 
	{
		DefaultForm newForm = new DefaultForm(name);
		layout.add(newForm);
		newForm.toFront();  //ovakve fije koje uticu na frejm moramo pozvati posle add()
		
		/* sjebe on jtree code logiku
		try {
			newForm.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
	
	//postoji vec fija za ovo
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
	
	//TODO srsly bro? vec postoji metoda za ovo
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
