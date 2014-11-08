package editorLook;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

@SuppressWarnings({ "serial", "unused" })
public class MyToolBar extends JToolBar{
	
	public MyToolBar(){
		
		JButton btnProject = new JButton();
		btnProject.setToolTipText("New Project");
		btnProject.setIcon(new ImageIcon("img/projectBtn.png"));
		add(btnProject);
		
		
		JButton btnForm = new JButton();
		btnForm.setAction(MainFrame.getInstance().getActionManager().getFormAction());
		
		btnForm.setToolTipText("New Form");
		btnForm.setIcon(new ImageIcon("img/new_22x22.jpg"));
		add(btnForm);

		addSeparator();

		//import, export, save
		
		JButton btnImport = new JButton();
		btnImport.setToolTipText("Import");
		btnImport.setIcon(new ImageIcon("img/import.png"));
		add(btnImport);
	
		JButton btnExport = new JButton();
		btnExport.setToolTipText("Export");
		btnExport.setIcon(new ImageIcon("img/export.png"));
		add(btnExport);
		
		JButton btnSave = new JButton();
		btnSave.setToolTipText("Save");
		btnSave.setIcon(new ImageIcon("img/save.png"));
		add(btnSave);
		
		addSeparator();
		
		//Undo, redo
		
		JButton btnUndo = new JButton();
		btnUndo.setToolTipText("Undo");
		btnUndo.setIcon(new ImageIcon("img/undo.png"));
		add(btnUndo);
		
		JButton btnRedo = new JButton();
		btnRedo.setToolTipText("Redo");
		btnRedo.setIcon(new ImageIcon("img/redo.png"));
		add(btnRedo);
		
		addSeparator();
		
		//Next and previos forms
		
		JButton btnNextLeft = new JButton();
		btnNextLeft.setToolTipText("Next Form");
		btnNextLeft.setIcon(new ImageIcon("img/next_left.png"));
		add(btnNextLeft);
		
		JButton btnNextRight = new JButton();
		btnNextRight.setToolTipText("Previous Form");
		btnNextRight.setIcon(new ImageIcon("img/next_right.png"));
		add(btnNextRight);
		
		addSeparator();
		
		//Maximize, Minimize, Delete, Select All
		JButton btnMaximize = new JButton();
		btnMaximize.setToolTipText("Maximize");
		btnMaximize.setIcon(new ImageIcon("img/maximize.jpg"));
		add(btnMaximize);
		
		JButton btnMinimize = new JButton();
		btnMinimize.setToolTipText("Minimize");
		btnMinimize.setIcon(new ImageIcon("img/minimize.png"));
		add(btnMinimize);
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("img/delete.png"));
		add(btnDelete);
		
		JButton btnSelectAll = new JButton();
		btnSelectAll.setToolTipText("Select all");
		btnSelectAll.setIcon(new ImageIcon("img/select_all.png"));
		add(btnSelectAll);
		
		//toolbar je pokretljiv, probati i sa statičnim toolbarom
		setFloatable(true);
		setBackground(new Color(255,255,204));
	
}

}
