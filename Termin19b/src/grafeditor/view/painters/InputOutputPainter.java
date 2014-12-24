package grafeditor.view.painters;

import grafeditor.model.elements.InputOutputElement;

import java.awt.geom.GeneralPath;

/**
 * Konkretan painter je zadužen za definisanje Shape objekta koji predstavlja dati element
 * @author Igor Z.
 *
 */
@SuppressWarnings("serial")
public class InputOutputPainter extends DevicePainter{

	public InputOutputPainter(InputOutputElement device) {
		super(device);

		shape=new GeneralPath();
		
		if (device.getType()==InputOutputElement.INPUT){
 	           	((GeneralPath)shape).moveTo(device.getPosition().getX(),device.getPosition().getY());
                ((GeneralPath)shape).lineTo(device.getPosition().getX()-5,device.getPosition().getY());
		}else if (device.getType()==InputOutputElement.OUTPUT){
			    ((GeneralPath)shape).moveTo(device.getPosition().getX(),device.getPosition().getY());
                ((GeneralPath)shape).lineTo(device.getPosition().getX()+5,device.getPosition().getY());
        }
	}
		
}
