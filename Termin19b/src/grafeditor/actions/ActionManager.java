package grafeditor.actions;

/**
 * 
 * @author Igor Z.
 * Obična klasa koja na jednom mestu grupiše sve akcije iz menije i toolbara
 *
 */

public class ActionManager {
    
	private OpenWorkspaceAction openWorkspaceAction; 
	private OpenProjectAction openDiagramAction;
	
	
	private SaveDiagramAction saveDiagramAction;
	private SaveProjectAction saveProjectAction;
	private SaveWorkspaceAction saveWorkspaceAction;
	
	
	private NewProjectAction newProjectAction;
	private NewDiagramAction  newDiagramAction;
	
	private CascadeDiagramAction cascadeDiagramAction;
	private TileHorizontallyDiagramAction tileHorizontallyDiagramAction;
	private TileVerticallyDiagramAction tileVerticallyDiagramAction;

	
	private DiagramNextAction diagramNextAction;
	private DiagramPreviusAction diagramPreviusAction;
	
	private HelpAboutAction helpAboutAction;
	
	private CloseAllDiagramAction closeAllDiagramAction;
	private CloseDiagramAction closeDiagramAction;
	private CloseProjectAction closeProjectAction;
	private DeleteElementAction deleteElementAction;

	
	//paletta:
	private PCircleAction pCircleAction;
	private PRectangleAction pRectangleAction;
	
	private PHandCursorAction phandCursorAction;
	private PLinkAction plinkAction;
	
	
	
	public ActionManager(){
		initialiseActions();
	}

	private void initialiseActions() {
		openWorkspaceAction=new OpenWorkspaceAction(); 
		openDiagramAction=new OpenProjectAction();
     	saveDiagramAction=new SaveDiagramAction();
		saveProjectAction=new SaveProjectAction();
		saveWorkspaceAction=new SaveWorkspaceAction();
		newProjectAction=new NewProjectAction();
		newDiagramAction=new NewDiagramAction();
		cascadeDiagramAction=new CascadeDiagramAction();
		tileHorizontallyDiagramAction=new TileHorizontallyDiagramAction();
		tileVerticallyDiagramAction=new TileVerticallyDiagramAction();
    	diagramNextAction=new DiagramNextAction();
		diagramPreviusAction=new DiagramPreviusAction();
		helpAboutAction=new HelpAboutAction();
		closeAllDiagramAction=new CloseAllDiagramAction();
		closeDiagramAction=new CloseDiagramAction();
		closeProjectAction=new CloseProjectAction();
		deleteElementAction=new DeleteElementAction();
		
		phandCursorAction=new PHandCursorAction();
		plinkAction=new PLinkAction();
		
		pCircleAction=new PCircleAction();
		pRectangleAction=new PRectangleAction();
	}

	public OpenProjectAction getOpenDiagramAction() {
		return openDiagramAction;
	}

	public SaveDiagramAction getSaveDiagramAction() {
		return saveDiagramAction;
	}

	public NewDiagramAction getNewDiagramAction() {
		return newDiagramAction;
	}

	public NewProjectAction getNewProjectAction() {
		return newProjectAction;
	}

	public CascadeDiagramAction getCascadeDiagramAction() {
		return cascadeDiagramAction;
	}

	public void setCascadeDiagramAction(CascadeDiagramAction cascadeDiagramAction) {
		this.cascadeDiagramAction = cascadeDiagramAction;
	}

	public CloseAllDiagramAction getCloseAllDiagramAction() {
		return closeAllDiagramAction;
	}

	public void setCloseAllDiagramAction(CloseAllDiagramAction closeAllDiagramAction) {
		this.closeAllDiagramAction = closeAllDiagramAction;
	}

	public CloseDiagramAction getCloseDiagramAction() {
		return closeDiagramAction;
	}

	public void setCloseDiagramAction(CloseDiagramAction closeDiagramAction) {
		this.closeDiagramAction = closeDiagramAction;
	}

	public DiagramNextAction getDiagramNextAction() {
		return diagramNextAction;
	}

	public void setDiagramNextAction(DiagramNextAction diagramNextAction) {
		this.diagramNextAction = diagramNextAction;
	}

	public DiagramPreviusAction getDiagramPreviusAction() {
		return diagramPreviusAction;
	}

	public void setDiagramPreviusAction(DiagramPreviusAction diagramPreviusAction) {
		this.diagramPreviusAction = diagramPreviusAction;
	}

	public HelpAboutAction getHelpAboutAction() {
		return helpAboutAction;
	}

	public void setHelpAboutAction(HelpAboutAction helpAboutAction) {
		this.helpAboutAction = helpAboutAction;
	}

	public TileHorizontallyDiagramAction getTileHorizontallyDiagramAction() {
		return tileHorizontallyDiagramAction;
	}

	public void setTileHorizontallyDiagramAction(
			TileHorizontallyDiagramAction tileHorizontallyDiagramAction) {
		this.tileHorizontallyDiagramAction = tileHorizontallyDiagramAction;
	}

	public TileVerticallyDiagramAction getTileVerticallyDiagramAction() {
		return tileVerticallyDiagramAction;
	}

	public void setTileVerticallyDiagramAction(
			TileVerticallyDiagramAction tileVerticallyDiagramAction) {
		this.tileVerticallyDiagramAction = tileVerticallyDiagramAction;
	}

	public void setNewDiagramAction(NewDiagramAction newDiagramAction) {
		this.newDiagramAction = newDiagramAction;
	}

	public void setNewProjectAction(NewProjectAction newProjectAction) {
		this.newProjectAction = newProjectAction;
	}

	public void setOpenDiagramAction(OpenProjectAction openDiagramAction) {
		this.openDiagramAction = openDiagramAction;
	}

	public void setSaveDiagramAction(SaveDiagramAction saveDiagramAction) {
		this.saveDiagramAction = saveDiagramAction;
	}

	public OpenWorkspaceAction getOpenWorkspaceAction() {
		return openWorkspaceAction;
	}

	public void setOpenWorkspaceAction(OpenWorkspaceAction openWorkspaceAction) {
		this.openWorkspaceAction = openWorkspaceAction;
	}

	public SaveProjectAction getSaveProjectAction() {
		return saveProjectAction;
	}

	public void setSaveProjectAction(SaveProjectAction saveProjectAction) {
		this.saveProjectAction = saveProjectAction;
	}

	public SaveWorkspaceAction getSaveWorkspaceAction() {
		return saveWorkspaceAction;
	}

	public void setSaveWorkspaceAction(SaveWorkspaceAction saveWorkspaceAction) {
		this.saveWorkspaceAction = saveWorkspaceAction;
	}

	public CloseProjectAction getCloseProjectAction() {
		return closeProjectAction;
	}

	public void setCloseProjectAction(CloseProjectAction closeProjectAction) {
		this.closeProjectAction = closeProjectAction;
	}

	
	public PHandCursorAction getPhandCursorAction() {
		return phandCursorAction;
	}

	public void setPhandCursorAction(PHandCursorAction phandCursorAction) {
		this.phandCursorAction = phandCursorAction;
	}



	public PLinkAction getPlinkAction() {
		return plinkAction;
	}

	public void setPlinkAction(PLinkAction plinkAction) {
		this.plinkAction = plinkAction;
	}


	public DeleteElementAction getDeleteElementAction() {
		return deleteElementAction;
	}

	public void setDeleteElementAction(DeleteElementAction deleteElementAction) {
		this.deleteElementAction = deleteElementAction;
	}

	public PCircleAction getpCircleAction() {
		return pCircleAction;
	}

	public void setpCircleAction(PCircleAction pCircleAction) {
		this.pCircleAction = pCircleAction;
	}

	public PRectangleAction getpRectangleAction() {
		return pRectangleAction;
	}

	public void setpRectangleAction(PRectangleAction pRectangleAction) {
		this.pRectangleAction = pRectangleAction;
	}


}
