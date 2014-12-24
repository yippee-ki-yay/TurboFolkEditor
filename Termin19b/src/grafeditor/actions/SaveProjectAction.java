package grafeditor.actions;

import grafeditor.app.AppCore;
import grafeditor.model.workspace.Project;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class SaveProjectAction extends AbstractEditorAction{
	

	public SaveProjectAction() {
		/**
		 * Pomoću metode apstraktne klase AbstractAction putValue 
		 * postavljamo vrednosti 4 od 8 konstanti
		 * Kada povežemo ovaj Action sa bilo kojom komponentom koja nasleđuje JComponent
		 * komponenta će iz ovih konstanti postaviti svoj Accelerator, Icon, Name i Description 
		 */
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/filesave.png"));
		putValue(NAME, "Save project");
		putValue(SHORT_DESCRIPTION, "Save project");
	}

	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new DiagramFileFilter());
		
		Project project=AppCore.getInstance().getWorkspaceTree().getCurrentProject();
		File projectFile=project.getProjectFile();
		
		if (!project.isChanged()){
			return;
		}
		
		if (project.getProjectFile()==null){
		         if(jfc.showSaveDialog(AppCore.getInstance())==JFileChooser.APPROVE_OPTION){
		                   projectFile=jfc.getSelectedFile();           	 
		        	 
		         }else{
		        	return; 
		         }
		         
		}     
	      
		         
	    ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(projectFile));
			os.writeObject(project);
			project.setProjectFile(projectFile);
			project.setChanged(false);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
			
	
		
	
		
	}

}
