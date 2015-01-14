package states;

import java.awt.Point;
import java.awt.event.MouseEvent;

import model.elements.FrameElement;
import frame.FrameView;
import frame.FrameView.Handle;

public class ResizeState extends State
{

    private Handle handle = null;
    
    @Override
    public void draw(MouseEvent e, FrameView node)
    {

    }

    @Override
    public void drag(MouseEvent e, FrameView node)
    {
        Point pos = node.pointToUserSpace(e.getPoint());

        FrameElement resizeElement = node.getFrameNode().selectionModel
                .getSelectedElement();

        //Uzmi koj handle smo uhvatili samo na pocetku 
        if(handle == null)
            handle = node.getHandleFromPoint(pos);

        if (resizeElement != null && handle != null)
        {
           if(handle == Handle.SouthEast)
           {
                //Trenutna pozicija misa minus pozicija elemnta daju nove velicine elemnta
                double scaledWidth = pos.getX() - resizeElement.getPos().getX();
                double scaledHeight = pos.getY() - resizeElement.getPos().getY();
                
                //Koliki je faktor uvecanja
                double scaleX=scaledWidth/resizeElement.getInitSize().getWidth();
                double scaleY=scaledHeight/resizeElement.getInitSize().getHeight();
                
                //da ocuvamo oblik koja osa je najmanje pomerena za toliko sve skaliramo
                double newScale = 1;
                    if(scaleX<scaleY)
                        newScale=scaleX;
                    else
                        newScale=scaleY;
                    
                //ogranicenja maksimalnog skaliranja    
                if(newScale<0.2)
                    resizeElement.setScale(0.2);
                else if(newScale>3)
                    resizeElement.setScale(3);
                else
                    resizeElement.setScale(newScale);

            }
           else if(handle == Handle.SouthWest)
           {
             //Trenutna pozicija misa minus pozicija elemnta daju nove velicine elemnta
               double scaledWidth = resizeElement.getSize().getWidth()+
                                  (resizeElement.getPos().getX() - pos.getX());
               double scaledHeight = pos.getY() - resizeElement.getPos().getY();
               
               //Koliki je faktor uvecanja
               double scaleX=scaledWidth/resizeElement.getInitSize().getWidth();
               double scaleY=scaledHeight/resizeElement.getInitSize().getHeight();
               
               double oldWidth = resizeElement.getSize().getWidth();
               
               //da ocuvamo oblik koja osa je najmanje pomerena za toliko sve skaliramo
               double newScale = 1;
                   if(scaleX<scaleY)
                       newScale=scaleX;
                   else
                       newScale=scaleY;
                   
               //ogranicenja maksimalnog skaliranja    
               if(newScale<0.2)
                   resizeElement.setScale(0.2);
               else if(newScale>3)
                   resizeElement.setScale(3);
               else
                   resizeElement.setScale(newScale);
               
               resizeElement.getPos().x = 
                        (int) (resizeElement.getPos().getX() + oldWidth - resizeElement.getSize().getWidth());

           }
           else if(handle == Handle.NorthEast)
           {
             //Trenutna pozicija misa minus pozicija elemnta daju nove velicine elemnta
               double scaledWidth = pos.getX() - resizeElement.getPos().getX();
               double scaledHeight = (resizeElement.getPos().getY() - pos.getY())
                                       + resizeElement.getSize().getHeight();
               
               //Koliki je faktor uvecanja
               double scaleX=scaledWidth/resizeElement.getInitSize().getWidth();
               double scaleY=scaledHeight/resizeElement.getInitSize().getHeight();
               
               double oldWidth = resizeElement.getSize().getWidth();
               
               //da ocuvamo oblik koja osa je najmanje pomerena za toliko sve skaliramo
               double newScale = 1;
                   if(scaleX<scaleY)
                       newScale=scaleX;
                   else
                       newScale=scaleY;
                   
               //ogranicenja maksimalnog skaliranja    
               if(newScale<0.2)
                   resizeElement.setScale(0.2);
               else if(newScale>3)
                   resizeElement.setScale(3);
               else
                   resizeElement.setScale(newScale);
               
               resizeElement.getPos().y = 
                       (int) (resizeElement.getPos().getY() + oldWidth - resizeElement.getSize().getWidth());
           }
           else if(handle == Handle.NorthWest)
           {
               //Trenutna pozicija misa minus pozicija elemnta daju nove velicine elemnta
               double scaledWidth = (resizeElement.getPos().getX() - pos.getX())
                       + resizeElement.getSize().getWidth();
               double scaledHeight = (resizeElement.getPos().getY() - pos.getY())
                                       + resizeElement.getSize().getHeight();
               
               //Koliki je faktor uvecanja
               double scaleX=scaledWidth/resizeElement.getInitSize().getWidth();
               double scaleY=scaledHeight/resizeElement.getInitSize().getHeight();
               
               double oldWidth = resizeElement.getSize().getWidth();
               double oldHeight = resizeElement.getSize().getHeight();
               
               //da ocuvamo oblik koja osa je najmanje pomerena za toliko sve skaliramo
               double newScale = 1;
                   if(scaleX<scaleY)
                       newScale=scaleX;
                   else
                       newScale=scaleY;
                   
               //ogranicenja maksimalnog skaliranja    
               if(newScale<0.2)
                   resizeElement.setScale(0.2);
               else if(newScale>3)
                   resizeElement.setScale(3);
               else
                   resizeElement.setScale(newScale);
               
               int newX = (int) 
                        (resizeElement.getPos().getX() + oldWidth - resizeElement.getSize().getWidth());
               int newY = (int) 
                       (resizeElement.getPos().getY() + oldHeight - resizeElement.getSize().getHeight());
               resizeElement.setPos(new Point(newX, newY));
           }
            
        }

        node.repaint();

    }

    @Override
    public void released(MouseEvent e, FrameView node)
    {
        handle = null;
        node.getStateManager().setSelectionState();
    }

}
