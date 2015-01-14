package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import model.ProjectNode;
import editorLook.MainFrame;

@SuppressWarnings("serial")
public class ImportAction extends AbstractAction
{

    public ImportAction()
    {
        putValue(ACCELERATOR_KEY,
                KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

        putValue(SHORT_DESCRIPTION, "Import project");
        putValue(SMALL_ICON, new ImageIcon("img/import.png"));
        putValue(NAME, "Import project");
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        ProjectNode p = null;

        JFileChooser fileDialog = new JFileChooser();

        if (fileDialog.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                FileInputStream inFile = new FileInputStream(
                        fileDialog.getSelectedFile());
                ObjectInputStream objectInput = new ObjectInputStream(inFile);
                p = (ProjectNode) objectInput.readObject();
                objectInput.close();
                // inFile.close();
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            MainFrame.getInstance().getWorkspaceTree().addProject(p);

            // moramo proci kroz sve modele frame i napraviti frameView
            for (int i = 0; i < p.getFrameCount(); ++i)
            {
                MainFrame.getInstance().getDesktopManager()
                        .addFrame(p.getFrame(i).getName(),
                                p.getFrame(i).getId(), p.getFrame(i));
            }
        }

    }

}