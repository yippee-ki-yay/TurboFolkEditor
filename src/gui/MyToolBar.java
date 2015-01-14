package gui;

import java.awt.Color;

import javax.swing.JToolBar;

import editorLook.MainFrame;

@SuppressWarnings("serial")
public class MyToolBar extends JToolBar{
	
	public MyToolBar(){
		//New project, new form
		add(MainFrame.getInstance().getActionManager().getProjectAction());
		add(MainFrame.getInstance().getActionManager().getFormAction());

		addSeparator();

		//import, export, save
		add(MainFrame.getInstance().getActionManager().getImportAction());
		add(MainFrame.getInstance().getActionManager().getExportAction());
		add(MainFrame.getInstance().getActionManager().getSaveAction());
		
		addSeparator();
		
		//Undo, redo
		add(MainFrame.getInstance().getActionManager().getUndoAction());
		add(MainFrame.getInstance().getActionManager().getRedoAction());
		
		addSeparator();
		
		//Next and previos forms
		add(MainFrame.getInstance().getActionManager().getPrevAction());
		add(MainFrame.getInstance().getActionManager().getNextAction());
		
		addSeparator();
		
		//Maximize, Minimize, Delete, Select All
		add(MainFrame.getInstance().getActionManager().getMaxAction());
		add(MainFrame.getInstance().getActionManager().getMinAction());
		add(MainFrame.getInstance().getActionManager().getDeleteAction());
		
		addSeparator();
		
		//cascade, horizontal, vertical
		add(MainFrame.getInstance().getActionManager().getCascadeLayout());
		add(MainFrame.getInstance().getActionManager().getHorizontalLayout());
		add(MainFrame.getInstance().getActionManager().getVerticalLayout());
		
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getZoomInAction());
		add(MainFrame.getInstance().getActionManager().getZoomOutAction());	
		
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getRotateAction());
		add(MainFrame.getInstance().getActionManager().getRotateLeftAction());
		
		
		//toolbar je pokretljiv, probati i sa statičnim toolbarom
		setFloatable(true);
		setBackground(new Color(255,255,204));//wtf otkud ti ova boja?
	
}

}
