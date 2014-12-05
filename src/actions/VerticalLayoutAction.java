package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;

public class VerticalLayoutAction extends AbstractAction
{
	private static final long serialVersionUID = -455323436981933792L;

	public VerticalLayoutAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Vertical windows");
		putValue(SMALL_ICON, new ImageIcon("img/tileWindowsVertically.png"));
		putValue(NAME, "Vertical windows");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(MainFrame.getInstance().getDesktopManager().isSomeoneAlive())	
		   MainFrame.getInstance().getDesktopManager().getLayoutManager().
		                                               ToVertical();
		
	}

}
