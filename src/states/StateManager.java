package states;

public class StateManager {
	
	private CircleState circleState;
	private RectangleState recState;
	private TriangleState triangleState;
	private SelectionState selectionState;
	
	private State currState = null;
	
	public StateManager()
	{
		circleState = new CircleState();
		recState = new RectangleState();
		triangleState = new TriangleState();
		selectionState = new SelectionState();
		
		currState = selectionState;
	}
	
	public void setState(State state)
	{
		currState = state;
	}
	
	public State getState()
	{
		return currState;
	}

	public CircleState getCircleState() {
		return circleState;
	}

	public void setCircleState() {
		currState = circleState;
	}

	public RectangleState getRecState() {
		return recState;
	}

	public void setRecState() {
		currState = recState;
	}

	public TriangleState getTriangleState() {
		return triangleState;
	}

	public void setTriangleState() {
		currState = triangleState;
	}

	public SelectionState getSelectionState() {
		return selectionState;
	}

	public void setSelectionState() {
		currState = selectionState;
	}
	
	

}
