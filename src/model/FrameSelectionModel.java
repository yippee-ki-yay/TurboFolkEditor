package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.DefaultSingleSelectionModel;

import editorLook.MainFrame;

import model.elements.FrameElement;

public class FrameSelectionModel extends DefaultSingleSelectionModel implements Serializable
{

	private static final long serialVersionUID = 1380193394149555735L;
	
	ArrayList<FrameElement> selectedElements = new ArrayList<FrameElement>();
	
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
	}
	
	public boolean isElementSelected(FrameElement e)
	{
		return selectedElements.contains(e);	
	}
	
	public void removeAllSelectedElements()
	{
		MainFrame.getInstance().getStatusBar().selectedReset();
		selectedElements.clear();
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
	
	

}
