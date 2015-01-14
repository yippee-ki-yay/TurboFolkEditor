package events;

import java.util.EventObject;

@SuppressWarnings("serial")
public class UpdateElementsEvent extends EventObject
{
	public UpdateElementsEvent(Object source)
	{
		super(source);
	}
}
