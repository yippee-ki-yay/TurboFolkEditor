package editorLook;


import javax.swing.JMenu;
import javax.swing.JMenuBar;

/*
 * klasa nasleđuje JMenuBar i predstavlja kontejner
 * za komponente JMenu. Instanca ove klase će se 
 * smeštati u glavni prozor aplikacije
 * 
 */

//TODO ubaci onaj layout prozora da moze iz menija
//TODO exit stavka

public class MyMenuBar extends JMenuBar{
	
	private static final long serialVersionUID = 3801887044625659388L;

	public MyMenuBar (){
		
	    JMenu file=new JMenu("File");
	    JMenu edit =new JMenu("Edit");
	    JMenu select = new JMenu("Select");
	    JMenu help = new JMenu("Help");

		//File stavka
		file.add(MainFrame.getInstance().getActionManager().getProjectAction());
		file.add(MainFrame.getInstance().getActionManager().getFormAction());
		file.add(MainFrame.getInstance().getActionManager().getSaveAction());
		file.add(MainFrame.getInstance().getActionManager().getImportAction());
		file.add(MainFrame.getInstance().getActionManager().getExportAction());

		//JMenuItem miExit =new JMenuItem("Exit");

		file.addSeparator();
		
		//Edit stavka
		edit.add(MainFrame.getInstance().getActionManager().getUndoAction());
		edit.add(MainFrame.getInstance().getActionManager().getRedoAction());
		edit.add(MainFrame.getInstance().getActionManager().getDeleteAction());
		
		//Select
		select.add(MainFrame.getInstance().getActionManager().getPrevAction());
		select.add(MainFrame.getInstance().getActionManager().getNextAction());
		
		help.add(MainFrame.getInstance().getActionManager().getAboutAction());
			
		add(file);
		add(edit);
		add(select);
		add(help);
		
	}

}
