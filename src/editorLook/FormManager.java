package editorLook;


import java.awt.Dimension;
import java.beans.PropertyVetoException;

import javax.swing.DesktopManager;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class FormManager extends JDesktopPane
{
	//JDesktopPane desktop;   //WHAT THE FLYING FUCK WERE YOU DOING????
	
	
	public FormManager()
	{
		//desktop = new JDesktopPane();
		
		//frames = desktop.getAllFrames();
		
		//desktop.setMinimumSize(new Dimension(400, 400));
	}
	
	public void addFrame(String name)
	{
		DefaultForm newForm = new DefaultForm(name);
		add(newForm);
		//add(newForm);
	}

	
	//TODO test function selects allways first window
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
	
	public void deleteSelected()
	{
		getSelectedFrame().dispose();
			
	}
	
}
