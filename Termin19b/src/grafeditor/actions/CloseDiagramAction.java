package grafeditor.actions;

import grafeditor.app.AppCore;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class CloseDiagramAction extends AbstractEditorAction {


	
	public CloseDiagramAction() {
		
		
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/close.png"));
		putValue(NAME, "Close diagram");
		putValue(SHORT_DESCRIPTION, "Close diagram");
	}

	public void actionPerformed(ActionEvent arg0) {
		//zatvaranje selektovanog dijagrama i njegovo brisanje iz stabla
	}

}
