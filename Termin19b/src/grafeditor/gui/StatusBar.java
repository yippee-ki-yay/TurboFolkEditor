package grafeditor.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StatusBar extends JPanel{
	
	private StatusPane status=new StatusPane("State");
	private StatusPane elementType=new StatusPane("Element type");
	private StatusPane elementName=new StatusPane("Element name");
	private StatusPane position=new StatusPane("Position");
	private StatusPane dimension=new StatusPane("Dimension");
	
	public StatusBar(){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(status);
		add(elementType);
		add(elementName);
		add(position);
		add(dimension);
	}
	
	private class StatusPane extends JLabel{
		public StatusPane (String text){
			setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
			setBackground(Color.GRAY);
			setPreferredSize(new Dimension(170,20));
			setHorizontalAlignment(CENTER);
			setText(text);
		}
	}
	
	public void setStatus(String status){
		this.status.setText(status);
	}
	public void setElementType(String elementType){
		this.elementType.setText(elementType);
	}
	public void setElementName(String elementName){
		this.elementName.setText(elementName);
	}
	public void setPosition(String position){
		this.position.setText(position);
	}
	public void setDimension(String dimension){
		this.dimension.setText(dimension);
	}
	
}
