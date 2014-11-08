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
		JMenuItem miNewProject =new JMenuItem("New Project");
		JMenuItem miNewFile =new JMenuItem("New File");
		JMenuItem miSaveProject =new JMenuItem("Save Project");
		JMenuItem miImport =new JMenuItem("Import");
		JMenuItem miExport =new JMenuItem("Export");
		JMenuItem miExit =new JMenuItem("Exit");
				
		file.add(miNewProject);
		file.add(miNewFile);
		file.addSeparator();
		file.add(miSaveProject);
		file.add(miImport);
		file.add(miExport);
		file.add(miExit);
		
		//Edit stavka
		JMenuItem miUndo =new JMenuItem("Undo");
		JMenuItem miRedo =new JMenuItem("Redo");
		JMenuItem miDelete =new JMenuItem("Delete");
		
		edit.add(miUndo);
		edit.add(miRedo);
		edit.add(miDelete);
		
		//Select
		JMenuItem miSelectLeft =new JMenuItem("Select left");
		JMenuItem miSelectRight =new JMenuItem("Select right");
		JMenuItem miSelectAll =new JMenuItem("Select all");
		
		select.add(miSelectLeft);
		select.add(miSelectRight);
		select.add(miSelectAll);
		
		
		add(file);
		add(edit);
		add(select);
		add(about);
		add(help);
		
	}

}
