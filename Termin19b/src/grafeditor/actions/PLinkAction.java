package grafeditor.actions;

import grafeditor.app.AppCore;
import grafeditor.view.DiagramView;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class PLinkAction extends AbstractEditorAction {


	
	public PLinkAction() {
		
		
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/plink.jpg"));
		putValue(SHORT_DESCRIPTION, "Link");
	}

	public void actionPerformed(ActionEvent arg0) {
		((DiagramView)AppCore.getInstance().getDesktop().getSelectedFrame()).startLinkState();	
	}

}
