package grafeditor.actions;

import grafeditor.app.AppCore;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class SaveDiagramAction extends AbstractEditorAction{
	

	public SaveDiagramAction() {
		/**
		 * Pomoću metode apstraktne klase AbstractAction putValue 
		 * postavljamo vrednosti 4 od 8 konstanti
		 * Kada povežemo ovaj Action sa bilo kojom komponentom koja nasleđuje JComponent
		 * komponenta će iz ovih konstanti postaviti svoj Accelerator, Icon, Name i Description 
		 */
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/filesave.png"));
		putValue(NAME, "Save diagram");
		putValue(SHORT_DESCRIPTION, "Save diagram");
	}

	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(AppCore.getInstance());
		
	}

}
