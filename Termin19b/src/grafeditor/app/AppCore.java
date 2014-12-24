package grafeditor.app;

import grafeditor.actions.ActionManager;
import grafeditor.gui.Menu;
import grafeditor.gui.Palette;
import grafeditor.gui.StatusBar;
import grafeditor.gui.Toolbar;
import grafeditor.gui.WorkspaceTree;
import grafeditor.model.workspace.Project;
import grafeditor.model.workspace.WorkspaceModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class AppCore extends JFrame{

	
    /**
	 * 
	 */
	
	private static AppCore instance = null;
    private ActionManager actionManager;
    private Toolbar toolbar;
    private JMenuBar menu;
    private Palette palette;
    private StatusBar statusBar;
    
    private WorkspaceModel workspaceModel;
    private WorkspaceTree workspaceTree;
    
    
    //desktop u stvari u sebi će sadržati kolekciju DiagramView-a
    // svaki od njih predstavlja jedan JInternalFrame i na sebe
    //će iscrtati sve komponente
    private JDesktopPane desktop;
    
	private AppCore() {
		
	}
	
	
	private void initialise(){
		actionManager=new ActionManager();
		
		
		initialiseWorkspaceTree();
		initialiseGUI();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void initialiseGUI(){
		menu=new Menu();
		setJMenuBar(menu);
		
		
		toolbar = new Toolbar();
		getContentPane().add(toolbar,BorderLayout.NORTH);
		
		palette =new Palette();
		getContentPane().add(palette,BorderLayout.EAST);
		
		
		desktop=new JDesktopPane();
		
		JScrollPane scroll=new JScrollPane(workspaceTree);
		scroll.setMinimumSize(new Dimension(200,150));
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
		getContentPane().add(split,BorderLayout.CENTER);
		split.setDividerLocation(250);
		split.setOneTouchExpandable(true);
		
		statusBar=new StatusBar();
		getContentPane().add(statusBar,BorderLayout.SOUTH);
		
		setSize(900,600);
		setLocationRelativeTo(null);
		setTitle("Grafički editor");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		
		Action doNothing = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	if (workspaceTree.getSelectionPath().getLastPathComponent() instanceof Project){  
		    		workspaceTree.startEditingAtPath(workspaceTree.getSelectionPath());
		    	}
		    	
		    }
		};
		workspaceTree.getInputMap().put(KeyStroke.getKeyStroke("F2"),
		                            "doNothing");
		workspaceTree.getActionMap().put("doNothing",
		                             doNothing);
		
		
		
	}
	private void initialiseWorkspaceTree(){
		workspaceTree=new WorkspaceTree();
		//ToolTipManager.sharedInstance().registerComponent(workspaceTree);
	
		workspaceModel = new WorkspaceModel();
		

		workspaceTree.setModel(workspaceModel);
	}
	public ActionManager getActionManager(){
		return actionManager;
	}
	
	
	
	
	public static AppCore getInstance(){
		if (instance==null){
			instance=new AppCore();
			instance.initialise();
		}
		return instance;
	}


	public JDesktopPane getDesktop() {
		return desktop;
	}


	public WorkspaceTree getWorkspaceTree() {
		return workspaceTree;
	}


	public WorkspaceModel getWorkspaceModel() {
		return workspaceModel;
	}


	public StatusBar getStatusBar() {
		return statusBar;
	}


	public void setStatusBar(StatusBar statusBar) {
		this.statusBar = statusBar;
	}

	
  

}
