package events;

public class ActionManager 
{
	private NewDefaultFormAction formAction = new NewDefaultFormAction();
	private DeleteFormAction deleteAction = new DeleteFormAction();

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
