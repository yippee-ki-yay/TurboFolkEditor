package grafeditor.model.elements;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Igor Z.
 *
 */
@SuppressWarnings("serial")
public abstract class DiagramDevice extends DiagramElement {

	protected Dimension size;
	protected Point2D position;
	
	protected int inputNo;
	protected int outputNo;
	
	protected ArrayList<InputOutputElement> inputs=new ArrayList<InputOutputElement>();
	protected ArrayList<InputOutputElement> outputs=new ArrayList<InputOutputElement>();
	
	public DiagramDevice(Point2D position, Dimension size, Stroke stroke, Paint paint,Color  strokeColor,int inputNo,int outputNo){
		super(stroke, paint,strokeColor);
		this.size = size;
		//ovo omogućava translaciju tačaka tako da se element kreira u centru
		position.setLocation(position.getX()-size.getWidth()/2,position.getY()-size.getHeight()/2);
		this.position = position;
		this.inputNo=inputNo;
		this.outputNo=outputNo;
		this.strokeColor=strokeColor;
		
		
		//kreiranje ulaza
		
		for (int i=0;i<inputNo;i++){

			Point2D ioPos = new Point2D.Double(position.getX(), 
					                           position.getY()+(getSize().getHeight()/(getInputNo() +1))*(i+1)) ;
			addInput((InputOutputElement) InputOutputElement.createDefault(ioPos,stroke,paint,this,i+1,InputOutputElement.INPUT));
		  
      	}
		
		//kreiranje izlaza
		for (int i=0;i<outputNo;i++){
			Point2D ioPos = new Point2D.Double(position.getX()+size.width,
					                           position.getY()+(getSize().getHeight()/(getOutputNo() +1))*(i+1)) ;
			addOutput((InputOutputElement) InputOutputElement.createDefault(ioPos,stroke,paint,this,i+1,InputOutputElement.OUTPUT));
		  
      	}		
		
	}
	
	
	
	
    //metode za rad sa kolekcijom ulaza
	public void addInput(InputOutputElement p){
		inputs.add(p);
	}
	
	public void removeInput(InputOutputElement p){
		inputs.remove(p);
	}
	
	public InputOutputElement getInputAt(int i){
		return inputs.get(i);
	}
	
	public int getInputCount(){
		return inputs.size();
	}
	
	public Iterator<InputOutputElement> getInputIterator(){
		return inputs.iterator();
	}
	//------------------------------------------------------
	
	
	
    //metode za rad sa kolekcijom izlaza
	public void addOutput(InputOutputElement p){
		outputs.add(p);
	}
	
	public void removeOutput(InputOutputElement p){
		outputs.remove(p);
	}
	
	public InputOutputElement getOutputAt(int i){
		return outputs.get(i);
	}
	
	public int getIOutputCount(){
		return outputs.size();
	}
	
	public Iterator<InputOutputElement> getOutputIterator(){
		return outputs.iterator();
	}
	//------------------------------------------------------
	
	
	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}




	public int getInputNo() {
		return inputNo;
	}




	public ArrayList<InputOutputElement> getInputs() {
		return inputs;
	}




	public int getOutputNo() {
		return outputNo;
	}

	
}
