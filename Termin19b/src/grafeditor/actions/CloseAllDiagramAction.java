package grafeditor.actions;

import grafeditor.app.AppCore;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class CloseAllDiagramAction extends AbstractEditorAction {


	
	public CloseAllDiagramAction() {
		
		
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/close.png"));
		putValue(NAME, "Close all diagrams");
		putValue(SHORT_DESCRIPTION, "Close all diagrams");
	}

	public void actionPerformed(ActionEvent arg0) {
		//zatvaranje svih dijagrama i njihovo brisanje iz stabla
	}

}
