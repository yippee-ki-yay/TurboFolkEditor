package frame;

import java.awt.Dimension;

import javax.swing.JInternalFrame;



//TODO updejtuj frejmove ako su neki obrisani
//TODO kad se menja velicina?
//TODO kod klasa dodavanja koristis u vise metoda isti kod

public class FrameLayoutManager {

	enum Layout {CASCADE , VERTICAL, HORIZONTAL};
	
	Layout currState;
	FrameManager desktopPane;
	Dimension desktopSize;
	
	int currX, currY, dX, dY;
	
	public FrameLayoutManager(FrameManager manager)
	{
		currState = Layout.CASCADE;
		desktopPane = manager;
		
		dX = 30; dY = 30;
		currX = 20; currY = 20;
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
		
		for(int i = 0; i < nFrames;++i)
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
		
		for(JInternalFrame frame: frames)
		{
			frame.setSize(desktopPane.getWidth(),
					desktopPane.getHeight()/nFrames);
			
			frame.setLocation(0, currY);
			currY += desktopPane.getHeight()/nFrames;
		}
	}
	
	public void ToHorizontal()
	{
		currState = Layout.HORIZONTAL;
		
		JInternalFrame frames[] = desktopPane.getAllFrames();
		
		int nFrames = frames.length;
		
		int currX = 0;
		
		for(JInternalFrame frame: frames)
		{
			frame.setSize(desktopPane.getWidth()/ nFrames,
					desktopPane.getHeight());
			
			frame.setLocation(currX, 0);
			currX += desktopPane.getWidth()/nFrames;
		}
	}
	
	private void addCascadeForm(JInternalFrame form)
	{
		form.setLocation(currX, currY);
		currX = currX + dX;currY = currY + dY;
		
		desktopSize = desktopPane.getSize();
		
		//ako smo dotakli granicu dole naseg desktopa vrati gore
		if(form.getHeight() + form.getY() >= desktopSize.height)
		{
			currX -= 100;
			currY = 30;
		}//stavi ga u centar ako spo otisli predaleko desno
		else if(form.getWidth() + form.getX()-100 >= desktopSize.width)
		{
			form.setLocation(desktopSize.width/2 - form.getWidth()/2,
					desktopSize.height/2 - form.getHeight()/2);
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
