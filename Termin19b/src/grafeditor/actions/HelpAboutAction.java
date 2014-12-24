package grafeditor.actions;

import grafeditor.app.AppCore;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class HelpAboutAction extends AbstractEditorAction {


	
	public HelpAboutAction() {
		
		
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/help.png"));
		putValue(NAME, "About GrafEditor");
		putValue(SHORT_DESCRIPTION, "About GrafEditor");
	}

	public void actionPerformed(ActionEvent arg0) {
		//otvara mali dijalog sa vašom slikom, brojem indeksa i imenom i prezimenom, mailom i telefonom
	}

}
