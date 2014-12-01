package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;

public class HorizontalLayoutAction extends AbstractAction
{

	private static final long serialVersionUID = 968325447141070818L;

	public HorizontalLayoutAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_K);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Horizontal windows");
		putValue(SMALL_ICON, new ImageIcon("img/tileWindowsHorizontally.png"));
		putValue(NAME, "Horizontal windows");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
	MainFrame.getInstance().getDesktopManager().getLayoutManager()
	                              .ToHorizontal();
		
	}

}

