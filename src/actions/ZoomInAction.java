package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;
import frame.FrameView;


@SuppressWarnings("serial")
public class ZoomInAction extends AbstractAction
{

	public ZoomInAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_PLUS, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Zoom in");
		putValue(SMALL_ICON, new ImageIcon("img/zoom_in.png"));
		putValue(NAME, "Zoom in");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		FrameView frame = (FrameView) MainFrame.getInstance().
		                              getDesktopManager().getSelectedFrame();
		
		frame.zoomIn();
	}

}