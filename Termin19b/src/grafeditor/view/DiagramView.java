package grafeditor.view;



import grafeditor.app.AppCore;
import grafeditor.event.UpdateEvent;
import grafeditor.event.UpdateListener;
import grafeditor.model.elements.DiagramDevice;
import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.LinkElement;
import grafeditor.model.workspace.Diagram;
import grafeditor.model.workspace.Project;
import grafeditor.model.workspace.Workspace;
import grafeditor.state.StateManager;
import grafeditor.view.painters.ElementPainter;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.tree.TreePath;

/**
 * Predstavlja View deo MVC arhitekture, buduće unutrašnje klase će predstavljati Controller-a
 * Ova klasa će na sebe iscrtati sve komponente koje se nalaze u DiagramModel-u
 * DiagramModel se dobija iz dijagrama
 * @author Igor Z.
 *
 */

@SuppressWarnings("serial")
public class DiagramView extends JInternalFrame implements UpdateListener{

	
	static int openFrameCount = 0;
	
	// služe nam za određivanje pozicije unutrašnjeg prozora
	static final int xOffset = 30, yOffset = 30;
	
	private Diagram diagram;
	//framework nam predstavlja radnu povrsinu za dijagram
 
	private JPanel framework;
	private JScrollBar sbVertical;
	private JScrollBar sbHorizontal;
	
	
	
	private StateManager stateManager=new StateManager(this);
	
	//tacka koja nam za sada sluzi za lasso
	private Point2D lastPosition=null;
	private Rectangle2D selectionRectangle=new Rectangle2D.Double();
	
	
	
	//podrska za rad sa StateManagerom
	//----------------------------------------------
	
	
	public void startCircleState() {
		diagram.getSelectionModel().removeAllFromSelectionList();
		stateManager.setCircleState();
		}
	
	public void startRectangleState() {
		diagram.getSelectionModel().removeAllFromSelectionList();
		stateManager.setRectangleState();
		}	
	

    public void startSelectState() {
    	stateManager.setSelectState();
		}
    public void startLinkState(){
    	diagram.getSelectionModel().removeAllFromSelectionList();
    	stateManager.setLinkState();
    }
    public void startLassoState() {

    	stateManager.setLassoState();
		}
    
    
	public StateManager getStateManager() {
		return stateManager;
	}
   //-----------------------------------------------
	
	
	

	
	/**
	 * Handlovi za selekciju su identifikovani stranama sveta.
	 * 
	 *
	 */
	public enum Handle {
		North, South, East, West, SouthEast, SouthWest, NorthEast, NorthWest
	}
	static final int handleSize = 7;
	
	
	
	
	public DiagramView() {
		
		super("" ,
		          true, //resizable
		          true, //closable
		          true, //maximizable
		          true);//iconifiable
		++openFrameCount;
		setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
		setIconifiable(true);
		setClosable(true);
		
		
		setSize(400,400);
 	    setVisible(true);
		
 	    framework=new Framework();
 	    framework.setCursor(new Cursor(Cursor.HAND_CURSOR));
		framework.setBackground(Color.WHITE);
		getContentPane().add(framework,BorderLayout.CENTER);
		
		//postavljanje horiyontalnog i vertikalnog skrol bara
		sbHorizontal=new JScrollBar(JScrollBar.HORIZONTAL, 140, 20, 0, 300);
		sbVertical=new JScrollBar(JScrollBar.VERTICAL, 140, 20, 0, 300);
		sbHorizontal.setUnitIncrement(2);
		sbHorizontal.setBlockIncrement(1);
		sbVertical.setUnitIncrement(2);
		sbVertical.setBlockIncrement(1);
		
		this.add(sbHorizontal,BorderLayout.SOUTH);
		this.add(sbVertical,BorderLayout.EAST);
		
		
		DiagramController c=new DiagramController();
		framework.addMouseListener(c);
		framework.addMouseMotionListener(c);
		framework.addMouseWheelListener(c);
		
		
	}
	
	public void setDiagram(Diagram diagram){
		this.diagram = diagram; 
		this.setName(diagram.getName());
		this.diagram.getModel().addUpdateListener(this);
		this.diagram.getSelectionModel().addUpdateListener(this);
		setTitle(diagram.getName());

	}

	



	public Diagram getDiagram() {
		return diagram;
	}

	
	
	
	private class DiagramController extends MouseAdapter implements MouseMotionListener{

		public void mousePressed(MouseEvent e) {
			   lastPosition=e.getPoint();
			   getStateManager().getCurrentState().mousePressed(e);
		}

		public void mouseReleased(MouseEvent e) {
			   getStateManager().getCurrentState().mouseReleased(e);
		}
		
		public void mouseDragged(MouseEvent e ){
			   getStateManager().getCurrentState().mouseDragged(e);
		}
		public void mouseMoved(MouseEvent e) {
			getStateManager().getCurrentState().mouseMoved(e);
		}

	
	}




	public void updatePerformed(UpdateEvent e) {
		repaint();
		
	}
	
	
	private class Framework extends JPanel{
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
			
			
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			
			Iterator<DiagramElement> it = diagram.getModel().getElementsIterator();
			while(it.hasNext()){
				DiagramElement d = (DiagramElement) it.next();
				ElementPainter paint =  (ElementPainter) d.getPainter();
				paint.paint(g2, d);
				
			}
			

			
			paintSelectionHandles(g2);
			
			//iscrtavanje pravougaonika za lasso
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, 
					BasicStroke.JOIN_BEVEL, 1f, new float[]{(float)3, (float)6}, 0 ));
			g2.draw(selectionRectangle);			
		}

		}
	
	/**
	 * Iscrtavanje selekcionih hendlova oko selektovanog elementa
	 */
	private void paintSelectionHandles(Graphics2D g2) {
		
		Iterator<DiagramElement> it = diagram.getSelectionModel().getSelectionListIterator();
		while(it.hasNext()){
			DiagramElement element =  it.next();
			if (element instanceof DiagramDevice){
				DiagramDevice device=(DiagramDevice)element;
				// Iscrtavanje pravougaonika sa isprekidanom linijom
				g2.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, 
						BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0 ));
				g2.setPaint(Color.BLACK);
			
				g2.drawRect((int)device.getPosition().getX(), (int)device.getPosition().getY(),
						(int)device.getSize().getWidth(), (int)device.getSize().getHeight());
			
				// 	Iscrtavanje hendlova
				for(Handle e: Handle.values()){
					paintSelectionHandle(g2, getHandlePoint(device.getPosition(), device.getSize(), e));
				}
			
			
			}else {
				//isrtavanje handlova za link
				LinkElement link=(LinkElement)element;
			

				Point2D bp=null;
				bp=link.getOutput().getPosition();
				g2.setPaint(Color.BLACK);
				g2.setStroke(new BasicStroke((float)2, BasicStroke.CAP_SQUARE, 
							BasicStroke.JOIN_BEVEL));
				
				g2.drawRect((int)bp.getX()-handleSize/2, (int)bp.getY()-handleSize/2,
						handleSize, handleSize);
	
				Iterator<Point2D> itp = link.getPointsIterator();
				while(itp.hasNext()){
					bp = (Point2D) itp.next();
					g2.drawRect((int)bp.getX()-handleSize/2, (int)bp.getY()-handleSize/2,
							handleSize, handleSize);
				
				}
				bp=link.getInput().getPosition();
				g2.drawRect((int)bp.getX()-handleSize/2, (int)bp.getY()-handleSize/2,
						handleSize, handleSize);
			}

		}
	}	
	
	private void paintSelectionHandle(Graphics2D g2, Point2D position){
		double size = handleSize;
		g2.fill(new Rectangle2D.Double(position.getX()-size/2, position.getY()-size/2, 
				size, size));	
	}
	
	
	private Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handlePosition ){
		double x=0, y=0;
		
		// Određivanje y koordinate
		
		// Ako su gornji hendlovi
		if(handlePosition == Handle.NorthWest || handlePosition == Handle.North || handlePosition == Handle.NorthEast){
			y = topLeft.getY();
		}
		// Ako su centralni po y osi
		if(handlePosition == Handle.East || handlePosition == Handle.West){
			y = topLeft.getY()+size.getHeight()/2;
		}
		//Ako su donji
		if(handlePosition == Handle.SouthWest || handlePosition == Handle.South || handlePosition == Handle.SouthEast){
			y = topLeft.getY() + size.getHeight();
		}

		// Određivanje x koordinate
		
		// Ako su levi
		if(handlePosition == Handle.NorthWest || handlePosition == Handle.West || handlePosition == Handle.SouthWest){
			x = topLeft.getX();
		}
		// ako su centralni po x osi
		if(handlePosition == Handle.North || handlePosition == Handle.South){
			x = topLeft.getX() + size.getWidth()/2;
		}
		// ako su desni
		if(handlePosition == Handle.NorthEast || handlePosition == Handle.East || handlePosition == Handle.SouthEast){
			x = topLeft.getX() + size.getWidth();
		}
		
		return new Point2D.Double(x,y);
		
	}
	
	/**
	 * Na osnovu hendla iznad koga se nalazi postavlja kursor
	 */
	public void setMouseCursor(Point2D point){
		
		Handle handle = getDeviceAndHandleForPoint(point);

		if(handle != null){
			Cursor cursor = null;
			
			switch(handle){
			case North: cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);break;
			case South: cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);break;
			case East: cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);break;
			case West: cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);break;
			case SouthEast: cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);break;
			case NorthWest: cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);break;
			case SouthWest: cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);break;
			case NorthEast: cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);break;
			}
			framework.setCursor(cursor);
		}
		else
			framework.setCursor(Cursor.getDefaultCursor());
	}
	
	/**
	 * Određuje handl i uređaj koji se nalazi na zadatoj lokaciji 
	 * @param point Ulazni parametar koji određuje lokaciju
	 * @return Hendl za zadatu poziciju. Ukoliko je null tada je device nedefinisan.
	 */
	public Handle getDeviceAndHandleForPoint(Point2D point){
		DiagramElement element;
		
		Iterator<DiagramElement> it = diagram.getSelectionModel().getSelectionListIterator();
		while(it.hasNext()){
			element = it.next();
			return getHandleForPoint(element, point);
		}
		return null;
	}
	
	/**
	 * Za zadatu tačku i uređaj vraća hendl.
	 * @param device
	 * @param point
	 * @return Hendl ukoliko je "pogođen", u suprotnom vraća null
	 */
	private Handle getHandleForPoint(DiagramElement element, Point2D point){
		for(Handle h: Handle.values()){
			if(isPointInHandle(element, point, h)){
				return h;
			}
		}
		return null;
	}
	
	/**
	 * Za zadati uređaj, tačku i hendl određuje da li je tačka unutar hendla
	 * @param device
	 * @param point
	 * @param handle
	 * @return
	 */
	private boolean isPointInHandle(DiagramElement element, Point2D point, Handle handle){
		if (element instanceof DiagramDevice){
			DiagramDevice device=(DiagramDevice)element;
			Point2D handleCenter = getHandlePoint(device.getPosition(), device.getSize(), handle);
			return ( (Math.abs(point.getX()-handleCenter.getX())<=(double)handleSize/2) && 
					(Math.abs(point.getY()-handleCenter.getY())<=(double)handleSize/2) );
		}else 
			return false;
	}

	public Point2D getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Point2D lastPosition) {
		this.lastPosition = lastPosition;
	}

	public Rectangle2D getSelectionRectangle() {
		return selectionRectangle;
	}

	public void setSelectionRectangle(Rectangle2D selectionRectangle) {
		this.selectionRectangle = selectionRectangle;
	}

		}






