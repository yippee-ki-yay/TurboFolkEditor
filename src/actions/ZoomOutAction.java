package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;
import frame.FrameView;


@SuppressWarnings("serial")
public class ZoomOutAction extends AbstractAction
{

	public ZoomOutAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Zoom out");
		putValue(SMALL_ICON, new ImageIcon("img/zoom_out.png"));
		putValue(NAME, "Zoom out");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
	    FrameView frame = (FrameView) MainFrame.getInstance().
                getDesktopManager().getSelectedFrame();

        frame.zoomOut();	
	}

}