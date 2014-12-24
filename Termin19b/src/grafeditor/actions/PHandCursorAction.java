package grafeditor.actions;

import grafeditor.app.AppCore;
import grafeditor.view.DiagramView;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class PHandCursorAction extends AbstractEditorAction {


	
	public PHandCursorAction() {
		
		
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/handc.png"));
	//	putValue(NAME, "Select mode");
		putValue(SHORT_DESCRIPTION, "Select mode");
	}

	public void actionPerformed(ActionEvent arg0) {
		((DiagramView)AppCore.getInstance().getDesktop().getSelectedFrame()).startSelectState();	
	}

}
