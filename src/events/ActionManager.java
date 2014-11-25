package events;

public class ActionManager 
{
	private NewDefaultFormAction formAction = new NewDefaultFormAction();
	private DeleteFormAction deleteAction = new DeleteFormAction();
	private NewProjectAction projectAction = new NewProjectAction();
	private MinimizeAction minAction = new MinimizeAction();
	private MaximizeAction maxAction = new MaximizeAction();
	private PreviousFormAction prevAction = new PreviousFormAction();
	private NextFormAction nextAction = new NextFormAction();
	private UndoAction undoAction = new UndoAction();
	private RedoAction redoAction = new RedoAction();
	private ImportAction importAction = new ImportAction();
	private ExportAction exportAction = new ExportAction();
	private SaveAction saveAction = new SaveAction();
	private AboutAction aboutAction = new AboutAction();

	private CascadeLayoutAction cascadeLayout = new CascadeLayoutAction();
	private HorizontalLayoutAction horizontalLayout =
			                        new HorizontalLayoutAction();
	
	private DrawCircleAction circleAction = new DrawCircleAction();
	private DrawSquareAction squareAction = new DrawSquareAction();
	private DrawTriangleAction triangleAction = new DrawTriangleAction();
	
	
	
	public AboutAction getAboutAction() {
		return aboutAction;
	}

	public void setAboutAction(AboutAction aboutAction) {
		this.aboutAction = aboutAction;
	}
	
	public DrawSquareAction getSquareAction() {
		return squareAction;
	}

	public void setSquareAction(DrawSquareAction squareAction) {
		this.squareAction = squareAction;
	}

	public DrawTriangleAction getTriangleAction() {
		return triangleAction;
	}

	public void setTriangleAction(DrawTriangleAction triangleAction) {
		this.triangleAction = triangleAction;
	}

	public DrawCircleAction getCircleAction() {
		return circleAction;
	}

	public void setCircleAction(DrawCircleAction circleAction) {
		this.circleAction = circleAction;
	}

	public CascadeLayoutAction getCascadeLayout() {
		return cascadeLayout;
	}

	public void setCascadeLayout(CascadeLayoutAction cascadeLayout) {
		this.cascadeLayout = cascadeLayout;
	}

	public HorizontalLayoutAction getHorizontalLayout() {
		return horizontalLayout;
	}

	public void setHorizontalLayout(HorizontalLayoutAction horizontalLayout) {
		this.horizontalLayout = horizontalLayout;
	}

	public VerticalLayoutAction getVerticalLayout() {
		return verticalLayout;
	}

	public void setVerticalLayout(VerticalLayoutAction verticalLayout) {
		this.verticalLayout = verticalLayout;
	}

	private VerticalLayoutAction verticalLayout = 
									new VerticalLayoutAction();

	public MinimizeAction getMinAction() {
		return minAction;
	}

	public void setMinAction(MinimizeAction minAction) {
		this.minAction = minAction;
	}

	public MaximizeAction getMaxAction() {
		return maxAction;
	}

	public void setMaxAction(MaximizeAction maxAction) {
		this.maxAction = maxAction;
	}

	public PreviousFormAction getPrevAction() {
		return prevAction;
	}

	public void setPrevAction(PreviousFormAction prevAction) {
		this.prevAction = prevAction;
	}

	public NextFormAction getNextAction() {
		return nextAction;
	}

	public void setNextAction(NextFormAction nextAction) {
		this.nextAction = nextAction;
	}

	public UndoAction getUndoAction() {
		return undoAction;
	}

	public void setUndoAction(UndoAction undoAction) {
		this.undoAction = undoAction;
	}

	public RedoAction getRedoAction() {
		return redoAction;
	}

	public void setRedoAction(RedoAction redoAction) {
		this.redoAction = redoAction;
	}

	public ImportAction getImportAction() {
		return importAction;
	}

	public void setImportAction(ImportAction importAction) {
		this.importAction = importAction;
	}

	public ExportAction getExportAction() {
		return exportAction;
	}

	public void setExportAction(ExportAction exportAcion) {
		this.exportAction = exportAcion;
	}

	public SaveAction getSaveAction() {
		return saveAction;
	}

	public void setSaveAction(SaveAction saveAction) {
		this.saveAction = saveAction;
	}

	public NewProjectAction getProjectAction() {
		return projectAction;
	}

	public void setProjectAction(NewProjectAction projectAction) {
		this.projectAction = projectAction;
	}

	public DeleteFormAction getDeleteAction() {
		return deleteAction;
	}

	public void setDeleteAction(DeleteFormAction deleteAction) {
		this.deleteAction = deleteAction;
	}

	public NewDefaultFormAction getFormAction() {
		return formAction;
	}

	public void setFormAction(NewDefaultFormAction formAction) {
		this.formAction = formAction;
	}
	
	
}
