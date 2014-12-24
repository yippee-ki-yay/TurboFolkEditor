package grafeditor.model;



import grafeditor.event.UpdateEvent;
import grafeditor.event.UpdateListener;
import grafeditor.model.elements.DiagramElement;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.event.EventListenerList;


/**
 * 
 * U sebi će sadržati kolekciju grafičkih elemenata
 * takođe će imati i podršku za tree view komponentu
 * @author ASCOM
 *
 */
@SuppressWarnings("serial")
public class DiagramModel implements Serializable{


	private String name;
	
	protected ArrayList<DiagramElement> diagramElements =new ArrayList <DiagramElement>();

	
	
	
	transient  EventListenerList listenerList = new EventListenerList();
	UpdateEvent updateEvent = null;
	 
	 
	private Object readResolve(){
		listenerList = new EventListenerList();	
		return this;
	}	

	/**
	 * Pronalazi indeks elementa koji se nalazi na zadatim logičkim koordinatama
	 * @param point
	 * @return
	 */
	public int getElementAtPosition(Point point) {
		for(int i=getElementsCount()-1;i>=0;i--){
			DiagramElement element = getElementAt(i);
			if(element.getPainter().isElementAt(point)){
				return i;
			}
		}
		return -1;
	}	
	public void removeElement(DiagramElement element){
		
		diagramElements.remove(element);
		fireUpdatePerformed();
	}		
	public int getElementsCount(){
		return diagramElements.size();
	}
	
	public DiagramElement getElementAt(int i){
		return diagramElements.get(i);
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}	
	
	public Iterator<DiagramElement> getElementsIterator(){
		return diagramElements.iterator();
	}
	
	public void addDiagramElement(DiagramElement element){
		diagramElements.add(element);
		fireUpdatePerformed();
	}	
	
		
	 public void addUpdateListener(UpdateListener l) {
	     listenerList.add(UpdateListener.class, l);
	 }

	 public void removeUpdateListener(UpdateListener l) {
	     listenerList.remove(UpdateListener.class, l);
	 }
	 
	public ArrayList<DiagramElement>  getDiagramElements() {
			return diagramElements;
	}
		

	 /**
	 * Javljamo svim listenerima da se događaj desio 
	 */
	public void fireUpdatePerformed() {
	     Object[] listeners = listenerList.getListenerList();
	     for (int i = listeners.length-2; i>=0; i-=2) {
	         if (listeners[i]==UpdateListener.class) {
	             if (updateEvent == null)
	                 updateEvent = new UpdateEvent(this);
	             ((UpdateListener)listeners[i+1]).updatePerformed(updateEvent);
	         }
	     }
	 }	
	
}
