package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;
import frame.FrameView;



public class SelectAction extends AbstractAction
{
	private static final long serialVersionUID = -5156941483640828169L;

	public SelectAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.ALT_MASK));
		
		putValue(SHORT_DESCRIPTION, "Select");
		putValue(SMALL_ICON, new ImageIcon("img/select_icon.png"));
		putValue(NAME, "Select");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		((FrameView)(MainFrame.getInstance().getDesktopManager().getSelectedFrame())).
        getFrame().getStateManager().setSelectionState();

	}

}