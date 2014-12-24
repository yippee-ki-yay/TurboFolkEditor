package grafeditor.state;

import grafeditor.view.DiagramView;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StateManager implements Serializable {
	private State currentState;
	
	LinkState linkState;
	CircleState circleState; 
	RectangleState rectangleState; 
	SelectState selectState;
	LassoState lassoState;
	
	
	public StateManager(DiagramView med)
	{
		linkState = new LinkState(med); 
		circleState = new CircleState(med);
		rectangleState=new RectangleState(med);
		selectState=new SelectState(med);
		lassoState=new LassoState(med);
     	currentState = selectState;
	}
	public void setLinkState(){ currentState = linkState; }
	public void setSelectState(){ currentState = selectState; }
	public void setLassoState(){ currentState = lassoState; }
	public void setCircleState() { currentState = circleState; }
	public void setRectangleState() { currentState = rectangleState; }
	
	public State getCurrentState() {
		return currentState;
	}
}
