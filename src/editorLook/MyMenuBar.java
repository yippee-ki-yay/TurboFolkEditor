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
@SuppressWarnings("serial")
public class MyMenuBar extends JMenuBar{
	
	public MyMenuBar (){
		
	    JMenu file=new JMenu("File");
	    JMenu miNew =new JMenu("New");
	    JMenu about = new JMenu("About");
	    JMenu help = new JMenu("Help");
		JMenuItem miProject=new JMenuItem("Project");
		JMenuItem miPackage=new JMenuItem("Package");
		miNew.add(miProject);
		miNew.addSeparator();
		miNew.add(miPackage);
		
		JMenuItem miOpen =new JMenuItem("Open");
		JMenuItem miClose =new JMenuItem("Close");
		JMenuItem miCloseAll =new JMenuItem("Close All");
				
		file.add(miNew);
		file.addSeparator();
		file.add(miOpen);
		file.addSeparator();
		file.add(miClose);
		file.add(miCloseAll);
		file.addSeparator();
		
		//radio button-i u ovom primeru rade kao grupa:
		ButtonGroup bg1=new ButtonGroup();
		JRadioButtonMenuItem rmiInsert=new 
		JRadioButtonMenuItem("Insert",true);
		JRadioButtonMenuItem rmiOver=new
		JRadioButtonMenuItem("Overtype");
		bg1.add(rmiInsert);
		bg1.add(rmiOver);
		
		file.add(rmiInsert);
		file.add(rmiOver);
		
		JMenu edit=new JMenu("Edit");
		JMenu source=new JMenu("View");
		
		add(file);
		add(edit);
		add(source);
		add(about);
		add(help);
		
	}

}
