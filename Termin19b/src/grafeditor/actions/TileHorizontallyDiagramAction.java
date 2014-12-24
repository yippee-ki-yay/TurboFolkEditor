package grafeditor.actions;

import grafeditor.app.AppCore;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class TileHorizontallyDiagramAction extends AbstractEditorAction {


	
	public TileHorizontallyDiagramAction() {
		
		
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/horizontally.png"));
		putValue(NAME, "Tile Horizontally");
		putValue(SHORT_DESCRIPTION, "Tile Horizontally");
	}

	public void actionPerformed(ActionEvent arg0) {
		//zatvaranje selektovanog dijagrama i njegovo brisanje iz stabla
	}

}
