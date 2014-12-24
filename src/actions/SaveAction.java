package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
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
		
		Object o = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		
		try {
			FileOutputStream fileOut = new FileOutputStream("tubofolk.tf");
			ObjectOutputStream objectStream = new ObjectOutputStream(fileOut);
			
			if(o instanceof ProjectNode)
			  objectStream.writeObject(o);
			
			objectStream.close();
			fileOut.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	
		
	}

}