package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.DefaultSingleSelectionModel;
import javax.swing.event.EventListenerList;

import model.elements.FrameElement;
import editorLook.MainFrame;
import events.UpdateElementsEvent;
import events.UpdateElementsListener;

public class FrameSelectionModel extends DefaultSingleSelectionModel implements Serializable
{

	private static final long serialVersionUID = 1380193394149555735L;
	
	ArrayList<FrameElement> selectedElements = new ArrayList<FrameElement>();
	
	EventListenerList listenerList = new EventListenerList();
	 UpdateElementsEvent event = null;
	
	private boolean multiSelection = false;
	
	public FrameSelectionModel()
	{
		
	}
	
	public boolean isEmpty()
	{
		return selectedElements.isEmpty();
	}
	
	public void addSelectedElement(FrameElement e)
	{
		String pos = "x: " + e.getPos().x +  " y: " + e.getPos().y;
		String size = "width: " + e.getSize().width +  " height: " + e.getSize().height;
		
		MainFrame.getInstance().getStatusBar().setElementName(e.getName());
		MainFrame.getInstance().getStatusBar().setType(e.getType());
		MainFrame.getInstance().getStatusBar().setPos(pos);
		MainFrame.getInstance().getStatusBar().setDimension(size);
		selectedElements.add(e);
		//fireUpdatePerformed();
		ProjectNode.updateChanged(true);
	}
	
	public FrameElement getSelectedElement()
	{
		if(selectedElements.size() > 0)
		{
			return selectedElements.get(selectedElements.size()-1);
		}
		
		return null;
	}
	
	public void removeSelectedElement(FrameElement e)
	{
		MainFrame.getInstance().getStatusBar().selectedReset();
		selectedElements.remove(e);
		//fireUpdatePerformed();
		ProjectNode.updateChanged(true);
	}
	
	public boolean isElementSelected(FrameElement e)
	{
		return selectedElements.contains(e);	
	}
	
	public void removeAllSelectedElements()
	{
		MainFrame.getInstance().getStatusBar().selectedReset();
		selectedElements.clear();
		//fireUpdatePerformed();
		ProjectNode.updateChanged(true);
	}

	public ArrayList<FrameElement> getSelectedElements() {
		return selectedElements;
	}

	public void setSelectedElements(ArrayList<FrameElement> selectedElements) {
		this.selectedElements = selectedElements;
	}

	public boolean isMultiSelection() {
		return multiSelection;
	}

	public void setMultiSelection(boolean multiSelection) {
		this.multiSelection = multiSelection;
	}
	
	 public void addUpdateListener(UpdateElementsListener l) {
         listenerList.add(UpdateElementsListener.class, l);
     }

     public void removeUpdateListener(UpdateElementsListener l) {
         listenerList.remove(UpdateElementsListener.class, l);
     }
     
     /**
         * Javljamo svim listenerima da se događaj desio 
         */
        public void fireUpdatePerformed() {
             Object[] listeners = listenerList.getListenerList();
             for (int i = listeners.length-2; i>=0; i-=2) {
                 if (listeners[i]==UpdateElementsListener.class) {
                     if (event == null)
                         event = new UpdateElementsEvent(this);
                     ((UpdateElementsListener)listeners[i+1]).updatePerformed(event);
                 }
             }
         }

}
