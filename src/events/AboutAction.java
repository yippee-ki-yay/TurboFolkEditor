package events;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.AboutDialog;
import editorLook.MainFrame;



public class AboutAction extends AbstractAction
{
	private static final long serialVersionUID = -7449805751468726631L;

	private AboutDialog aboutDialog = null;
	
	public AboutAction()
	{
		putValue(MNEMONIC_KEY, KeyEvent.VK_H);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "About dialog");
		putValue(SMALL_ICON, new ImageIcon("img/about.png"));
		putValue(NAME, "About dialog");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(aboutDialog == null)
		{
			aboutDialog = new AboutDialog();
		}
		aboutDialog.setVisible(true);
		
	}

}