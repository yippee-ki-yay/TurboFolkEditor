package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;
import frame.FrameView;



public class LassoSelectAction extends AbstractAction
{
	private static final long serialVersionUID = -5156941483640828169L;

	public LassoSelectAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.ALT_MASK));
		
		putValue(SHORT_DESCRIPTION, "Lasso Select");
		putValue(SMALL_ICON, new ImageIcon("img/lasso.png"));
		putValue(NAME, "Lasso Select");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		((FrameView)(MainFrame.getInstance().getDesktopManager().getSelectedFrame())).
        getStateManager().setLassoState();
		
		MainFrame.getInstance().getStatusBar().setState("Lasso Select");

	}

}