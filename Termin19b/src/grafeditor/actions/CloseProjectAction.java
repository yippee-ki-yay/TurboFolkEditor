package grafeditor.actions;

import grafeditor.app.AppCore;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class CloseProjectAction extends AbstractEditorAction {


	
	public CloseProjectAction() {
		
		
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/close.png"));
		putValue(NAME, "Close project");
		putValue(SHORT_DESCRIPTION, "Close project");
	}

	public void actionPerformed(ActionEvent arg0) {
		//zatvaranje projekta
	}

}
