package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;

import model.ProjectNode;


@SuppressWarnings("serial")
public class ImportAction extends AbstractAction
{

	public ImportAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		
		putValue(SHORT_DESCRIPTION, "Import project");
		putValue(SMALL_ICON, new ImageIcon("img/import.png"));
		putValue(NAME, "Import project");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		ProjectNode p = null;
		
		try {
			FileInputStream inFile = new FileInputStream("tubofolk.tf");
			ObjectInputStream objectInput = new ObjectInputStream(inFile);
	        p = (ProjectNode)objectInput.readObject();
	        inFile.close();
	        objectInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainFrame.getInstance().getWorkspaceTree().addProject(p);
		
	}

}