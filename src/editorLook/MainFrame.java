package editorLook;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.alee.laf.WebLookAndFeel;

import events.ActionManager;

@SuppressWarnings({ "serial", "unused" })
public class MainFrame extends JFrame
{
	
	private static MainFrame instance = null;
	
	private MyMenuBar menu;
	private MyToolBar toolbar;
	private FormManager desktopManager;
	private ActionManager actionManager;
	private TreeView tree;
	private ToolBarPalet toolPalet;
	

	public static MainFrame getInstance()
	{
		if(instance == null)
		{
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame()
	{
	}
	
	public void createApp()
	{
		createWindow();
		populateWindow();
	}
	
	private void createWindow()
	{
		Toolkit tool = Toolkit.getDefaultToolkit();
		
		//get that d
		Dimension d = tool.getScreenSize();
		
		setSize(850, 600);
		setTitle("Super senzetivni, turbo folk ekstra editor");
		setLocationRelativeTo(null);
		
		ImageIcon iconImg = new ImageIcon("img/icon.png");
		setIconImage(iconImg.getImage());
		this.addWindowListener(new WindowHandler());  //dodao svoj event listener za sam prozor
		
		
		try {
		   // UIManager.setLookAndFeel("napkin.NapkinLookAndFeel");
		   // UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
			WebLookAndFeel.install();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	private void populateWindow()
	{	
		tree = new TreeView();
		
		desktopManager = new FormManager();
		
		actionManager = new ActionManager();
		
		menu = new MyMenuBar();
		setJMenuBar(menu);
		
		
		toolPalet = new ToolBarPalet();
		add(toolPalet, BorderLayout.EAST);
		
		add(tree, BorderLayout.WEST);
		
		JSplitPane sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,tree,desktopManager);
		sp1.setDividerLocation(170);
		
		
		toolbar = new MyToolBar();
		add(toolbar, BorderLayout.NORTH);
		
		StatusBar statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		
		add(sp1, BorderLayout.CENTER);
		
		
	}
	
	
	public ActionManager getActionManager() {
		return actionManager;
	}

	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}
	
	public TreeView getTree() {
		return tree;
	}

	public void setTree(TreeView tree) {
		this.tree = tree;
	}

	public FormManager getDesktopManager() {
		return desktopManager;
	}

	public void setDesktopManager(FormManager desktopManager) {
		this.desktopManager = desktopManager;
	}
	
	
	
	/*
	 * Ova klasa odgovara na eventove sa glavnog prozora
	 * u ovom slucaju pred zatvaranje izbacuje dialog
	 */

	class WindowHandler extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			int response = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure you want to quit?",
					"Don't leave me :(", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			
			if(response == JOptionPane.YES_OPTION)
			{
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			else
			{
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		}
		
	}
	
}
