package grafeditor.actions;

import grafeditor.app.AppCore;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class CascadeDiagramAction extends AbstractEditorAction {


	
	public CascadeDiagramAction() {
		
		
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/cascade.png"));
		putValue(NAME, "Cascade");
		putValue(SHORT_DESCRIPTION, "Cascade");
	}

	public void actionPerformed(ActionEvent arg0) {
		//kaskadni raspored svih prozora u desktop-u
	}

}
