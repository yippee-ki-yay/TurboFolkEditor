package model;

import java.util.ArrayList;

import javax.swing.DefaultSingleSelectionModel;

import model.elements.FrameElement;

public class FrameSelectionModel extends DefaultSingleSelectionModel
{

	private static final long serialVersionUID = 1380193394149555735L;
	
	ArrayList<FrameElement> selectedElements = new ArrayList<FrameElement>();
	
	public FrameSelectionModel()
	{
		
	}
	
	public void addSelectedElement(FrameElement e)
	{
		selectedElements.add(e);
	}
	
	public void removeSelectedElement(FrameElement e)
	{
		selectedElements.remove(e);
	}
	
	public boolean isElementSelected(FrameElement e)
	{
		return selectedElements.contains(e);	
	}
	
	public void removeAllSelectedElements()
	{
		selectedElements.clear();
	}

	public ArrayList<FrameElement> getSelectedElements() {
		return selectedElements;
	}

	public void setSelectedElements(ArrayList<FrameElement> selectedElements) {
		this.selectedElements = selectedElements;
	}
	
	

}
