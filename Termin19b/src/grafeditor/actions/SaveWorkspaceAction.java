package grafeditor.actions;

import grafeditor.app.AppCore;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class SaveWorkspaceAction extends AbstractEditorAction{
	

	public SaveWorkspaceAction() {
		/**
		 * Pomoću metode apstraktne klase AbstractAction putValue 
		 * postavljamo vrednosti 4 od 8 konstanti
		 * Kada povežemo ovaj Action sa bilo kojom komponentom koja nasleđuje JComponent
		 * komponenta će iz ovih konstanti postaviti svoj Accelerator, Icon, Name i Description 
		 */
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/filesave.png"));
		putValue(NAME, "Save workspace");
		putValue(SHORT_DESCRIPTION, "Save workspace");
	}

	public void actionPerformed(ActionEvent arg0) {
		//
		
	}

}
