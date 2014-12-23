package frame;

import java.awt.Dimension;

import javax.swing.JInternalFrame;


public class FrameLayoutManager {

	enum Layout {CASCADE , VERTICAL, HORIZONTAL};
	
	Layout currState;
	FrameManager desktopPane;
	Dimension desktopSize;
	
	int currX, currY, dX, dY;
	
	boolean goingLeft = false;
	boolean goingRight = true;
	
	public FrameLayoutManager(FrameManager manager)
	{
		currState = Layout.CASCADE;
		desktopPane = manager;
		
		dX = 30; dY = 30;
		currX = 0; currY = 0;
	}
	
	/**
	 * Adds the new form in the current layout style
	 * 
	 * @param form is the internal frame we are adding
	 */
	public void add(FrameView form)
	{
		if(currState == Layout.CASCADE)
		{
			addCascadeForm(form);
		}
		else if(currState == Layout.HORIZONTAL)
		{
			addHorizontalForm(form);
		}
		else if(currState == Layout.VERTICAL)
		{
			addVerticalForm(form);
		}
		
		desktopPane.add(form);
	}
	
	public void ToCascade()
	{
		
		currState = Layout.CASCADE;
		
        JInternalFrame frames[] = desktopPane.getAllFrames();
        
		
		int nFrames = frames.length;
		
		currX = 20; currY = 20;
		
		for(int i = nFrames-1; i >= 0;--i)
		{
			frames[i].setSize(200, 200);
			addCascadeForm(frames[i]);
		}
	}
	
	public void ToVertical()
	{
		
		currState = Layout.VERTICAL;
		
		JInternalFrame frames[] = desktopPane.getAllFrames();
		
		int nFrames = frames.length;
		
		int currY = 0;
		
		for(int i = nFrames-1; i >= 0;--i)
		{
			frames[i].setSize(desktopPane.getWidth(),
					desktopPane.getHeight()/nFrames);
			
			frames[i].setLocation(0, currY);
			currY += desktopPane.getHeight()/nFrames;
		}
	}
	
	public void ToHorizontal()
	{
		
		currState = Layout.HORIZONTAL;
		
		JInternalFrame frames[] = desktopPane.getAllFrames();
		
		int nFrames = frames.length;
		
		int currX = 0;
		
		for(int i = nFrames-1; i >= 0;--i)
		{
			frames[i].setSize(desktopPane.getWidth()/ nFrames,
					desktopPane.getHeight());
			
			frames[i].setLocation(currX, 0);
			currX += desktopPane.getWidth()/nFrames;
		}
	}
	
	private void addCascadeForm(JInternalFrame form)
	{		
		desktopSize = desktopPane.getSize();
		form.setLocation(currX, currY);
			
		//udarili smo desnu ivicu
		if(form.getWidth() + form.getX()-50 >= desktopSize.width)
		{
			goingRight = false; goingLeft = true;
			currX = desktopSize.width-200;currY = -20;
		}
		
		//udarili smo levu ivicu
		if(form.getX() <= 0)
		{
			goingRight = true; goingLeft = false;
			currY = 0;
		}
		
		if(goingLeft == true)
		{
		
			currX -= 20;  currY += 20;
		}
		
		if(goingRight == true)
		{
			currX += 20;  currY += 20;
		}
		
		//udarili smo donju ivicu
		if(form.getHeight() + form.getY() >= desktopSize.height)
		{
			if(goingRight == true)
			{
				currY = 0;currX -= 100;
			}
			else if(goingLeft == true)
			{
				currY = 0;currX += 100;	
			}
				
			
		}
	}
	
	private void addHorizontalForm(FrameView form)
	{
         currState = Layout.HORIZONTAL;
		
		JInternalFrame frames[] = desktopPane.getAllFrames();
		
		int nFrames = frames.length;
		
		int currX = 0;
		
		for(JInternalFrame frame: frames)
		{
			frame.setSize(desktopPane.getWidth()/ nFrames+1,
					desktopPane.getHeight());
			
			frame.setLocation(currX, 0);
			currX += desktopPane.getWidth()/nFrames+1;
		}
		
		form.setSize(desktopPane.getWidth()/ nFrames+1,
				desktopPane.getHeight());
		
		form.setLocation(currX, 0);
		currX += desktopPane.getWidth()/nFrames+1;
	}
	
	private void addVerticalForm(FrameView form)
	{
        currState = Layout.VERTICAL;
		
		JInternalFrame frames[] = desktopPane.getAllFrames();
		
		int nFrames = frames.length;
		
		int currY = 0;
		
		for(JInternalFrame frame: frames)
		{
			frame.setSize(desktopPane.getWidth(),
					desktopPane.getHeight()/nFrames+1);
			
			frame.setLocation(0, currY);
			currY += desktopPane.getHeight()/nFrames+1;
		}
		
		form.setSize(desktopPane.getWidth(),
				desktopPane.getHeight()/nFrames);
		
		form.setLocation(0, currY);
		currY += desktopPane.getHeight()/nFrames;
		
	}
	
	
}
