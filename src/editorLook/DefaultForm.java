package editorLook;


import java.beans.PropertyVetoException;
import java.util.Random;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

//TODO Za sada rasporedi prozore random po JDesktopPane
//Kasnije napravi neku LayoutKlasu koja na razlicite nacine
//rasporedjuje i resizuje framove

@SuppressWarnings("serial")
public class DefaultForm extends JInternalFrame
{
	public DefaultForm(String name)
	{
		super(name, true, true, true, true);
		setLocation(100 + randomPosition(), 100 + randomPosition());
		setSize(200, 200);
		setVisible(true);
		toFront();
		
		//TODO anonimna klasa rly bro?
		this.addInternalFrameListener(new InternalFrameListener() {
			
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameIconified(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameDeiconified(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameDeactivated(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameClosing(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				MainFrame.getInstance().getTree()
				         .deleteNode(e.getInternalFrame().getTitle());
				
			}
			
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				String name = e.getInternalFrame().getTitle();
				MainFrame.getInstance().getTree().setSelected(name);
				
			}
		});
	
	}
	
	int randomPosition()
	{
		Random rand = new Random();
		
		int min = -100;
		int max = 250;
		
		return rand.nextInt((max - min) + 1) + min;
	}
}
