package grafeditor.gui;

import grafeditor.app.AppCore;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.plaf.SeparatorUI;

public class Menu extends JMenuBar{

	public Menu() {
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		fileMenu.add(AppCore.getInstance().getActionManager().getOpenWorkspaceAction());
		fileMenu.add(AppCore.getInstance().getActionManager().getOpenDiagramAction());
		
		fileMenu.addSeparator();
		
		fileMenu.add(AppCore.getInstance().getActionManager().getNewProjectAction());
		fileMenu.add(AppCore.getInstance().getActionManager().getNewDiagramAction());
		
		fileMenu.addSeparator();
		
		fileMenu.add(AppCore.getInstance().getActionManager().getSaveDiagramAction());
		fileMenu.add(AppCore.getInstance().getActionManager().getSaveProjectAction());
		fileMenu.add(AppCore.getInstance().getActionManager().getSaveWorkspaceAction());
		
		fileMenu.addSeparator();
		
		fileMenu.add(AppCore.getInstance().getActionManager().getCloseDiagramAction());
		fileMenu.add(AppCore.getInstance().getActionManager().getCloseAllDiagramAction());
		fileMenu.add(AppCore.getInstance().getActionManager().getCloseProjectAction());
		add(fileMenu);
		
		JMenu windowMenu=new JMenu ("Window");
		windowMenu.add(AppCore.getInstance().getActionManager().getCascadeDiagramAction());
		windowMenu.add(AppCore.getInstance().getActionManager().getTileHorizontallyDiagramAction());
		windowMenu.add(AppCore.getInstance().getActionManager().getTileVerticallyDiagramAction());
		
		windowMenu.addSeparator();
		windowMenu.add(AppCore.getInstance().getActionManager().getDiagramPreviusAction());
		windowMenu.add(AppCore.getInstance().getActionManager().getDiagramNextAction());
		

		
		add(windowMenu);
		
		JMenu helpMenu=new JMenu("Help");
		helpMenu.add(AppCore.getInstance().getActionManager().getHelpAboutAction());
		add(helpMenu);
		
		
		
	}

}
