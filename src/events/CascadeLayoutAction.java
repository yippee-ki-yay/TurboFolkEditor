package events;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;

public class CascadeLayoutAction extends AbstractAction
{

	private static final long serialVersionUID = -1921016314391262295L;

	public CascadeLayoutAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_J);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_J, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Cascade windows");
		putValue(SMALL_ICON, new ImageIcon("img/cascadeWindows.png"));
		putValue(NAME, "Cascade windows");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	MainFrame.getInstance().getDesktopManager().getLayoutManager().ToCascade();
		
	}

}
