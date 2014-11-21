package editorLook;


import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/*
 * klasa nasleđuje JMenuBar i predstavlja kontejner
 * za komponente JMenu. Instanca ove klase će se 
 * smeštati u glavni prozor aplikacije
 * 
 */
@SuppressWarnings({ "serial", "unused" })
public class MyMenuBar extends JMenuBar{
	
	public MyMenuBar (){
		
	    JMenu file=new JMenu("File");
	    JMenu edit =new JMenu("Edit");
	    JMenu select = new JMenu("Select");
	    JMenu about = new JMenu("About");
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
			
		add(file);
		add(edit);
		add(select);
		add(about);
		add(help);
		
	}

}
