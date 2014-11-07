package editorLook;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;

import events.ActionManager;

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	
	private static MainFrame instance = null;
	
	private MyMenuBar menu;
	private MyToolBar toolbar;
	private FormManager desktopManager;
	private ActionManager actionManager;
	
	public FormManager getDesktopManager() {
		return desktopManager;
	}

	public void setDesktopManager(FormManager desktopManager) {
		this.desktopManager = desktopManager;
	}

	public static MainFrame getInstance()
	{
		if(instance == null)
		{
			instance = new MainFrame();
		}
		return instance;
	}
	
	public MainFrame()
	{
	}
	
	public void createApp()
	{
		createWindow();
		populateWindow();
	}
	
	private void createWindow()
	{
		setSize(800, 600);
		setTitle("Super senzetivni, turbo folk ekstra editor");
		this.addWindowListener(new WindowHandler());  //dodao svoj event listener za sam prozor
		try {
		   // UIManager.setLookAndFeel("napkin.NapkinLookAndFeel");
		    UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	private void populateWindow()
	{
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		desktopManager = new FormManager();
		
		actionManager = new ActionManager();
		
		menu = new MyMenuBar();
		setJMenuBar(menu);
		
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Workspace");
		
		JTree tree = new JTree(root);
		add(tree, BorderLayout.WEST);
		
		JSplitPane sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,tree,desktopManager);
		//sp1.setOneTouchExpandable(true);
		sp1.setDividerLocation(170);
        //zbog ove linije koda crveni panel se može smanjiti samo do 200px širine
		//tree.setMinimumSize(new Dimension(200,200));
		
		
		toolbar = new MyToolBar();
		add(toolbar, BorderLayout.NORTH);
		
		JLabel statusLabel = new JLabel("Status Bar");
		add(statusLabel, BorderLayout.SOUTH);
		add(mainPanel);
		
		add(sp1, BorderLayout.CENTER);
	}
	
	
	public ActionManager getActionManager() {
		return actionManager;
	}

	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
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
