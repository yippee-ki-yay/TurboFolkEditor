package events;

public class ActionManager 
{
	private NewDefaultFormAction formAction = new NewDefaultFormAction();

	public NewDefaultFormAction getFormAction() {
		return formAction;
	}

	public void setFormAction(NewDefaultFormAction formAction) {
		this.formAction = formAction;
	}
	
	
}
