package gui;

import javax.swing.JToolBar;

import editorLook.MainFrame;

public class ToolBarPalet extends JToolBar
{
	private static final long serialVersionUID = 8682572116787789541L;

	public ToolBarPalet()
	{
		
		super(VERTICAL);
		setFloatable(true);
		
		add(MainFrame.getInstance().getActionManager().getSelectAction());
		add(MainFrame.getInstance().getActionManager().getCircleAction());
		add(MainFrame.getInstance().getActionManager().getTriangleAction());
		add(MainFrame.getInstance().getActionManager().getSquareAction());
		add(MainFrame.getInstance().getActionManager().getTreeAction());
	}
}
