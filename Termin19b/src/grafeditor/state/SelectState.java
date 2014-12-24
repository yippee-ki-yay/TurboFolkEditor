package grafeditor.state;

import grafeditor.app.AppCore;
import grafeditor.model.elements.DiagramElement;
import grafeditor.view.DiagramView;
import grafeditor.view.DiagramView.Handle;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

@SuppressWarnings("serial")
public class SelectState extends State{
	private DiagramView med; 
	
	//indeks elementa koji je selektovan
	private int elementInMotion = -1;
	private Handle handleInMotion = null;
	
	public SelectState(DiagramView md) {
	med = md;
	}
	
	
	public void mousePressed(MouseEvent e) {
		if(!e.isControlDown()){
		med.getDiagram().getSelectionModel().removeAllFromSelectionList();
		}
		
		Point position = e.getPoint();
		if (e.getButton()==MouseEvent.BUTTON1){
			//provera se da li je korisnik uhvatio neki od hand-lova
			//trebace nam kad krenemo raditi resize elemenata
			handleInMotion = med.getDeviceAndHandleForPoint(position);
			if(handleInMotion == null){
				elementInMotion = med.getDiagram().getModel().getElementAtPosition(position);
				if(elementInMotion != -1){
					//pogodjen je element, ukoliko je selektovan treba ga ukloniti iz liste,
					//ako nije treba ga dodati u listu
					DiagramElement element=med.getDiagram().getModel().getElementAt(elementInMotion);
					
					if (med.getDiagram().getSelectionModel().isElementSelected(element)){
						med.getDiagram().getSelectionModel().removeFromSelectionList(element);
					}else{
						med.getDiagram().getSelectionModel().addToSelectionList(element);
					}	
					
				}else{
					//nije pogodjen nijedan element
					
				}
			}	
		}
		

	}
	
	public void mouseMoved(MouseEvent e) {
		// Promena pokazivača miša u zavisnosti od toga iznad čega se nalazi
		Point2D point = e.getPoint();
		med.setMouseCursor(point);
		AppCore.getInstance().getStatusBar().setPosition(e.getPoint().toString());
		
	}	

	public void mouseDragged(MouseEvent e) {

			med.startLassoState();

		
	}
}
