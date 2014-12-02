package frame;




import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import model.FrameNode;


public class FrameManager extends JDesktopPane
{	
	private static final long serialVersionUID = 4178080838523837768L;
	
	
	HashMap<Integer, FrameView> frames;
	
	FrameLayoutManager layout;

	public FrameManager()
	{
		frames = new HashMap<Integer, FrameView>();
		layout = new FrameLayoutManager(this);
	}
	
	public void addFrame(String title, int count, FrameNode frameNode) 
	{
		FrameView newForm = new FrameView(title, count, frameNode);
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
	
	public void showFrame(int idx)
	{
		FrameView f = frames.get(idx);
		
		if(f != null)
		{
			frames.get(idx).setVisible(true);
		}
	}
	
	public void removeFrameViews(ArrayList<FrameNode> frame_nodes)
	{
		for(FrameNode f : frame_nodes)
		{
			frames.get(f.getId()).dispose();
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
	
	
	public void deleteSelected()
	{
		if(isSomeoneSelected())	
		{
			getSelectedFrame().dispose();
		}
		
	}
	
	
	
	public FrameLayoutManager getLayoutManager() {
		return layout;
	}

	public void setLayoutManager(FrameLayoutManager layout) {
		this.layout = layout;
	}
}
