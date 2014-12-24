package grafeditor.actions;

import grafeditor.app.AppCore;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class TileVerticallyDiagramAction extends AbstractEditorAction {


	
	public TileVerticallyDiagramAction() {
		
		
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/vertically.png"));
		putValue(NAME, "Tile Vertically");
		putValue(SHORT_DESCRIPTION, "Tile Vertically");
	}

	public void actionPerformed(ActionEvent arg0) {
		//
	}

}
