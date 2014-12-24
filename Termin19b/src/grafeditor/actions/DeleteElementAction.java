package grafeditor.actions;

import grafeditor.app.AppCore;
import grafeditor.model.elements.DiagramElement;
import grafeditor.view.DiagramView;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import javax.swing.KeyStroke;

/**Klasa <b>DeleteAction</b> nasledjuje klasu <b>AbstractEditorAction</b> i modeluje akciju
 * za brisanje elemenata sa kanvasa
 * @author Tim5
 *
 */
@SuppressWarnings("serial")
public class DeleteElementAction extends AbstractEditorAction {

	DeleteElementAction(){
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_DELETE, 0));
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(SMALL_ICON, loadIcon("images/editdelete.png"));
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Delete");
	}
	
	public void actionPerformed(ActionEvent e) {
		
		DiagramView view= (DiagramView) AppCore.getInstance().getDesktop().getSelectedFrame();
		view.startSelectState();
		if (!view.getDiagram().getSelectionModel().getSelectionList().isEmpty()){
			Iterator<DiagramElement > it=view.getDiagram().getSelectionModel().getSelectionListIterator();
			while (it.hasNext()){
				DiagramElement element=it.next();
				view.getDiagram().getModel().removeElement(element);
				
			}
			view.getDiagram().getSelectionModel().removeAllFromSelectionList();
			//mana brisanja je ta sto ukoliko postoji link vezan za element i obrise se element
			//link se ne brise!!!
			//dve opcije
			//1. prolaziti kroz sve ulaze i izlaze elementa i za svaki od
			//njih proci kroz sve linkovi i videti da li je ulaz ili izlaz vezan za link
			
			//2.(bolje resenje) uvesti u klasu InputOutputElement referencu na link sa kojom je vezana
			//pa prilikom brisanje elementa, proci kroz njegove ulaze i izlaze i 
			//obrisati vezane linkove
		}

	}

}
