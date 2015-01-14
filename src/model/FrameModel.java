package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.event.EventListenerList;

import model.elements.FrameElement;
import events.UpdateElementsEvent;
import events.UpdateElementsListener;

public class FrameModel implements Serializable
{
	private static final long serialVersionUID = -6639337467009523942L;
	
	
	 private ArrayList<FrameElement> frameElements = new ArrayList<FrameElement>();
	transient private EventListenerList listenerList = new EventListenerList();
	transient UpdateElementsEvent updateEvent = null;
	
	public void addElement(FrameElement elem)
	{
		frameElements.add(elem);
		fireUpdatePreformed();
	}
	
	public void removeElement(FrameElement elem)
	{
		frameElements.remove(elem);
		fireUpdatePreformed();
	}
	
	public ArrayList<FrameElement> getFrameElements() {
		return frameElements;
	}

	public void setFrameElements(ArrayList<FrameElement> frameElements) {
		this.frameElements = frameElements;
	}
	
	
	/**
	 * Proverava da li vec postoji neki element na tom mestu
	 * da bi smo znali da li mozes nacrtati tu novi element
	 * 
	 * @return
	 */
	public boolean isSpaceFree(Point p)
	{
		for(FrameElement e : frameElements)
		{
			if(e.getElemPainter().isElementAt(p))
				return false;
		}
		return true;
	}
	
	public FrameElement getElementAt(Point p)
	{
		
		for(FrameElement e : frameElements)
		{
			if(e.getElemPainter().isElementAt(p))
				return e;
		}
		return null;
	}
	
	public void addUpdateElementsListener(UpdateElementsListener l)
	{
		listenerList.add(UpdateElementsListener.class, l);
		fireUpdatePreformed();
	}
	
	public void removeUpdateElementsListener(UpdateElementsListener l)
	{
		listenerList.remove(UpdateElementsListener.class, l);
	}
	
	private Object readResolve(){
		listenerList = new EventListenerList();
		return this;
		}

	
	public void fireUpdatePreformed()
	{
	     // Guaranteed to return a non-null array
	     Object[] listeners = listenerList.getListenerList();
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
