package grafeditor.actions;

import grafeditor.app.AppCore;
import grafeditor.model.workspace.Project;
import grafeditor.view.DiagramView;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class OpenProjectAction extends AbstractEditorAction {


	
	public OpenProjectAction() {
		
		/**
		 * Pomoću metode apstraktne klase AbstractAction putValue 
		 * postavljamo vrednosti 4 od 8 konstanti
		 * Kada povežemo ovaj Action sa bilo kojom komponentom koja nasleđuje JComponent
		 * komponenta će iz ovih konstanti postaviti svoj Accelerator, Icon, Name i Description 
		 */
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/fileopen.png"));
		putValue(NAME, "Open project");
		putValue(SHORT_DESCRIPTION, "Open project");
	}

	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new DiagramFileFilter());
		
		if(jfc.showOpenDialog(AppCore.getInstance())==JFileChooser.APPROVE_OPTION){
			try {
				ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				  
				Project p=null;
				try {
					p = (Project) os.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    
			      AppCore.getInstance().getWorkspaceTree().addProject(p);
				
				  for (int i=0;i<p.getDiagramCount();i++){
				    DiagramView view=new DiagramView();
				    p.getDiagram(i).getModel().addUpdateListener(p);
				    view.setDiagram(p.getDiagram(i));
				    
				   AppCore.getInstance().getDesktop().add(view);
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
			
		
		
	}
	}
}
