package grafeditor.gui;

import grafeditor.app.AppCore;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar{

	public Toolbar() {
		super();
		add(AppCore.getInstance().getActionManager().getOpenWorkspaceAction());
		add(AppCore.getInstance().getActionManager().getOpenDiagramAction());
		
		addSeparator();
		
		add(AppCore.getInstance().getActionManager().getNewProjectAction());
		add(AppCore.getInstance().getActionManager().getNewDiagramAction());
		
		addSeparator();
		
		add(AppCore.getInstance().getActionManager().getSaveDiagramAction());
		add(AppCore.getInstance().getActionManager().getSaveProjectAction());
		add(AppCore.getInstance().getActionManager().getSaveWorkspaceAction());
		
		addSeparator();
		
		add(AppCore.getInstance().getActionManager().getCloseDiagramAction());
		add(AppCore.getInstance().getActionManager().getCloseAllDiagramAction());
		add(AppCore.getInstance().getActionManager().getCloseProjectAction());
		
		
		
		add(AppCore.getInstance().getActionManager().getCascadeDiagramAction());
		add(AppCore.getInstance().getActionManager().getTileHorizontallyDiagramAction());
		add(AppCore.getInstance().getActionManager().getTileVerticallyDiagramAction());
		
		addSeparator();
		add(AppCore.getInstance().getActionManager().getDeleteElementAction());
		addSeparator();
		
		add(AppCore.getInstance().getActionManager().getHelpAboutAction());
	}

}
