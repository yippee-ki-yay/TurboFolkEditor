package editorLook;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import model.WorkspaceTreeModel;


import actions.ActionManager;

import com.alee.laf.WebLookAndFeel;

import frame.FrameManager;
import gui.MyMenuBar;
import gui.MyToolBar;
import gui.StatusBar;
import gui.ToolBarPalet;
import gui.WorkspaceTree;

@SuppressWarnings("serial")

public class MainFrame extends JFrame
{
	
	public static int frame_id = 0;
	private static MainFrame instance = null;
	
	private MyMenuBar menu;
	private MyToolBar toolbar;
	private FrameManager desktopManager;
	private ActionManager actionManager;
	private ToolBarPalet toolPalet;
	private WorkspaceTree workspaceTree;
	private WorkspaceTreeModel workspaceTreeModel;
	

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
		setSize(850, 600);
		setTitle("Graphics editor");
		setLocationRelativeTo(null);
		
		ImageIcon iconImg = new ImageIcon("img/icon.png");
		setIconImage(iconImg.getImage());
		this.addWindowListener(new WindowHandler()); 	
		
		/*try {
			WebLookAndFeel.install();
		} catch (Exception e) {
		    e.printStackTrace();
		}*/
	}
	
	private void populateWindow()
	{	
		
		workspaceTreeModel = new WorkspaceTreeModel();
		workspaceTree = new WorkspaceTree();
		workspaceTree.setModel(workspaceTreeModel);
		
		JScrollPane scrollPane = new JScrollPane(workspaceTree);
		
		desktopManager = new FrameManager();
		
		actionManager = new ActionManager();
		
		menu = new MyMenuBar();
		setJMenuBar(menu);
		
		toolPalet = new ToolBarPalet();
		add(toolPalet, BorderLayout.EAST);
		
		JSplitPane sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPane,desktopManager);
		sp1.setDividerLocation(170);
		
		
		toolbar = new MyToolBar();
		add(toolbar, BorderLayout.NORTH);
		
		StatusBar statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		
		add(sp1, BorderLayout.CENTER);
		
		
	}
	
	
	public WorkspaceTree getWorkspaceTree() {
		return workspaceTree;
	}

	public void setWorkspaceTree(WorkspaceTree workspaceTree) {
		this.workspaceTree = workspaceTree;
	}

	public ActionManager getActionManager() {
		return actionManager;
	}

	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}
	

	public FrameManager getDesktopManager() {
		return desktopManager;
	}

	public void setDesktopManager(FrameManager desktopManager) {
		this.desktopManager = desktopManager;
	}
	
	
	
	/**
	 * Ova klasa odgovara na eventove sa glavnog prozora
	 * u ovom slucaju pred zatvaranje izbacuje dialog
	 */

	class WindowHandler extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			int response = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure you want to quit?",
					"Exit", 
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
