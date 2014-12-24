package grafeditor.state;

import grafeditor.model.elements.DiagramDevice;
import grafeditor.model.elements.InputOutputElement;
import grafeditor.model.elements.LinkElement;
import grafeditor.view.DiagramView;

import java.awt.Point;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class LinkState extends State{
	private DiagramView med; 
	private LinkElement link;
	
	public LinkState(DiagramView md) {
	       med = md;
	}
	
	
	
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		if (e.getButton()==MouseEvent.BUTTON1){
			  //pritisnut je levi taster miša
			  //1. ako nije u toku iscrtavanje i ako je na poziciji element kreiraj link i kreni u isrtavanje
			  //2. ako je u toku isctavanje i na poziciji nema elementa dodaj prekidnu tacku
			  //3. ako je u toku iscrtavanje i na poziciji postoji element zavrsi iscrtavanje
			  if (link==null){
				  //1. nije u toku iscrtavanje
				  int devicePos=med.getDiagram().getModel().getElementAtPosition(position);
				  if (devicePos!=-1){
					  DiagramDevice startDevice=  (DiagramDevice) med.getDiagram().getModel().getElementAt(devicePos);
					  InputOutputElement ouput=startDevice.getOutputAt(0);
				 
				      link=(LinkElement) LinkElement.createDefault(startDevice,ouput,med.getDiagram().getModel().getElementsCount());
				      med.getDiagram().getModel().addDiagramElement((LinkElement) link);
				  }    
			  }else{
			     //u toku je iscrtavanje
				  int devicePos=med.getDiagram().getModel().getElementAtPosition(position);
				  if (devicePos!=-1){
					  //3. imamo krajnji element, zavrsi link
					  DiagramDevice endDevice=  (DiagramDevice) med.getDiagram().getModel().getElementAt(devicePos);
					  InputOutputElement input=endDevice.getInputAt(0);
				 
				      link.setEndDevice(endDevice);
				      link.setInput(input);
				      link.setPainter(link);
				      med.getDiagram().getModel().fireUpdatePerformed();
				      link=null;
				  }else{
					  //2. nije krajnji element, dodaj prekidnu tacku
					 // ((LinkElement)link).addPoint(position);
				  }
				 
			  }
			
		}else if (e.getButton()==MouseEvent.BUTTON3){
			//pritisnut desni taster misa, ako je u toku iscrtavanje linka
			//treba prekinuti iscrtavanje i obrisati link
			 if (link!=null){
   	      	 		med.getDiagram().getModel().removeElement(link);
   	      	 		link=null;
			 }	
		}
	}
	
	
	
	public void mouseReleased(MouseEvent e) {
		Point position = e.getPoint();
		if (link==null)return;
		
		
		//u toku je iscrtavajne linka
		if (e.getButton()==MouseEvent.BUTTON1){//otpusten levi taster misa
		      int devicePos=med.getDiagram().getModel().getElementAtPosition(position);
		      if (devicePos!=-1){
			         //miš je otpušten na nekom elementu, daj mi njegov prvi ulaz, ukoliko postoji
		    	     DiagramDevice endDevice=(DiagramDevice) med.getDiagram().getModel().getElementAt(devicePos);
		    	     if (endDevice.getInputCount()>0){
		    	    	 InputOutputElement input=endDevice.getInputAt(0);
		    	    	 ((LinkElement)link).setEndDevice(endDevice);
			             ((LinkElement)link).setInput(input);
			             ((LinkElement)link).setPainter(link);
			             med.getDiagram().getModel().fireUpdatePerformed();
			             link=null;
		    	     }else{
		    	    	 //device nema ulaza
		    	    	 med.getDiagram().getModel().removeElement((LinkElement) link);
		    	    	 link=null;
		    	     }
		   
		      }else{
		    	  //link je otpušten na mestu gde nema elemenata, dodati prekidnu tacku:
		    	  ((LinkElement)link).addPoint(position);
		    	  
		      }
		 }
	}
	
	
	
	public void mouseDragged(MouseEvent e){
		if (link!=null){
		
			// 	povlačenje linka, ažuriranje lokacije poslednje tačke
			link.getLastPoint().setLocation(e.getPoint());
			link.setPainter(link);
			med.getDiagram().getModel().fireUpdatePerformed();
		}
	}
	
	
	public void mouseMoved(MouseEvent e) {
		if (link!=null){
				//pomeranje miša, ažuriranje lokacije poslednje tačke
				link.getLastPoint().setLocation(e.getPoint());
				link.setPainter(link);
				med.getDiagram().getModel().fireUpdatePerformed();
		}
	}		
}
