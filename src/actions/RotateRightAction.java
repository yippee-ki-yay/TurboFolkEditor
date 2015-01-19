package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import commands.RotateElementCommand;

import editorLook.MainFrame;
import frame.FrameView;


public class RotateRightAction extends AbstractAction
{
	private static final long serialVersionUID = -5156941483640828169L;

	public RotateRightAction()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.ALT_MASK));
		
		putValue(SHORT_DESCRIPTION, "Rotate");
		putValue(SMALL_ICON, new ImageIcon("img/rotate.png"));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		FrameView selectedFrame = (FrameView) MainFrame.getInstance().
				                              getDesktopManager().getSelectedFrame();
		
		selectedFrame.getCommandManager().add(new RotateElementCommand(
                selectedFrame,selectedFrame.getFrameNode().selectionModel.getSelectedElements(), 
                Math.PI/2));
		
		selectedFrame.repaint();
	}

}