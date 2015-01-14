package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;
import frame.FrameView;


public class DrawCircleAction extends AbstractAction
{
	private static final long serialVersionUID = -5156941483640828169L;

	public DrawCircleAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.ALT_MASK));
		
		putValue(SHORT_DESCRIPTION, "Draw circle");
		putValue(SMALL_ICON, new ImageIcon("img/circle.png"));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
		((FrameView)(MainFrame.getInstance().getDesktopManager().getSelectedFrame())).
                                getStateManager().setCircleState();
		
		MainFrame.getInstance().getStatusBar().setState("Add element");
		
	}

}