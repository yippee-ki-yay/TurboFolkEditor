package grafeditor.actions;

import grafeditor.app.AppCore;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class PInverterAction extends AbstractEditorAction {


	
	public PInverterAction() {
		
		
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/inverter.png"));
		//putValue(NAME, "Inverter");
		putValue(SHORT_DESCRIPTION, "Inverter");
	}

	public void actionPerformed(ActionEvent arg0) {
		//zatvaranje selektovanog dijagrama i njegovo brisanje iz stabla
	}

}
