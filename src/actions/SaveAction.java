package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import model.ProjectNode;
import editorLook.MainFrame;


public class SaveAction extends AbstractAction
{
	private static final long serialVersionUID = -4705054839893474047L;

	public SaveAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Save");
		putValue(SMALL_ICON, new ImageIcon("img/save.png"));
		putValue(NAME, "Save");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
		JFileChooser jfc = new JFileChooser();
		
		Object o = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		ProjectNode project = null;
		
		if(o instanceof ProjectNode)
			project = (ProjectNode)o;
		else
			return;
		
		File projectFile=project.getSaveFile();
		
		if (project.getSaveFile()==null){
		         if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
		                   projectFile=jfc.getSelectedFile();           	 
		        	 
		         }else{
		        	return; 
		         }
		         
		}     
	      
		         
	    ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(projectFile));
			os.writeObject(project);
			project.setSaveFile(projectFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
			
	
	
		
	}

}