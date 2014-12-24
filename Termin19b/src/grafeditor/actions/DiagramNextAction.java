package grafeditor.actions;

import grafeditor.app.AppCore;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class DiagramNextAction extends AbstractEditorAction {


	
	public DiagramNextAction() {
		
		
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/?.png"));
		putValue(NAME, "Next diagram");
		putValue(SHORT_DESCRIPTION, "Next diagram");
	}

	public void actionPerformed(ActionEvent arg0) {
		//
	}

}
