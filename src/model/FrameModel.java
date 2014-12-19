package model;

import java.util.ArrayList;

import javax.swing.event.EventListenerList;

import model.elements.FrameElement;
import events.UpdateElementsEvent;
import events.UpdateElementsListener;

public class FrameModel 
{
	private ArrayList<FrameElement> frameElements = new ArrayList<FrameElement>();
	private EventListenerList eventsList = new EventListenerList();
	UpdateElementsEvent updateEvent = null;
	
	public void addElement(FrameElement elem)
	{
		frameElements.add(elem);
		fireUpdatePreformed();
	}
	
	public ArrayList<FrameElement> getFrameElements() {
		return frameElements;
	}

	public void setFrameElements(ArrayList<FrameElement> frameElements) {
		this.frameElements = frameElements;
	}
	
	public void addUpdateElementsListener(UpdateElementsListener l)
	{
		eventsList.add(UpdateElementsListener.class, l);
		fireUpdatePreformed();
	}
	
	public void removeUpdateElementsListener(UpdateElementsListener l)
	{
		eventsList.remove(UpdateElementsListener.class, l);
	}
	
	public void fireUpdatePreformed()
	{
	     // Guaranteed to return a non-null array
	     Object[] listeners = eventsList.getListenerList();
	     // Process the listeners last to first, notifying
	     // those that are interested in this event
	     for (int i = listeners.length-2; i>=0; i-=2) {
	         if (listeners[i]==UpdateElementsListener.class) {
	             // Lazily create the event:
	             if (updateEvent == null)
	                 updateEvent = new UpdateElementsEvent(this);
	             ((UpdateElementsListener)listeners[i+1]).updatePerformed(updateEvent);
	         }
	     
	 }	
	
	}
	
	
	
}
