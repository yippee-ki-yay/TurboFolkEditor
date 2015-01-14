package frame;

import java.awt.Adjustable;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import model.FrameNode;
import model.elements.FrameElement;
import states.StateManager;

import commands.CommandManager;

import editorLook.MainFrame;
import events.UpdateElementsEvent;
import events.UpdateElementsListener;

public class FrameView extends JInternalFrame implements
        UpdateElementsListener, AdjustmentListener
{
    private static final long serialVersionUID = -7657600321157734995L;

    private int myId = 0;
    private FrameNode frameNode; // referenca ka nodu u drvetu koja predstavlja
                                 // frame
    private DrawArea drawArea;

    private JScrollBar horizontalScroll;
    private JScrollBar verticalScroll;

    private int translateX = 0;
    private int translateY = 0;

    private double scaling = 1;

    private int hScroll = 100;
    private int vScroll = 100;

    private double scaleFactor = 0.2;

    private CommandManager commandManager = new CommandManager();

    private AffineTransform transformation = new AffineTransform();

    public enum Handle
    {
        North, NorthEast, NorthWest, South, SouthWest, SouthEast, West, East
    };

    static int handle_size = 7;

    transient private StateManager stateManager = new StateManager();

    private Rectangle2D.Double selectionRectangle = new Rectangle2D.Double();
    private Point pocetnaTacka;

    public FrameView(String title, int id, final FrameNode frameNode)
    {
        super(title, true, true, true, true);
        setSize(200, 200);
        setResizable(true);
        setVisible(true);
        this.frameNode = frameNode;
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setFrameIcon(new ImageIcon("img/frame_node.png"));

        myId = id;

        horizontalScroll = new JScrollBar(JScrollBar.HORIZONTAL, hScroll, 20,
                0, 200);
        verticalScroll = new JScrollBar(JScrollBar.VERTICAL, vScroll, 20, 0,
                200);
        horizontalScroll.addAdjustmentListener(this);
        verticalScroll.addAdjustmentListener(this);

        drawArea = new DrawArea();
        add(drawArea, BorderLayout.CENTER);

        frameNode.getModel().addUpdateElementsListener(FrameView.this);

        this.addInternalFrameListener(new InternalFrameAdapter()
        {
            @Override
            public void internalFrameActivated(InternalFrameEvent e)
            {
                MainFrame.getInstance().getWorkspaceTree()
                        .selectNode(frameNode);
            }
        });

        FrameViewListener frameListener = new FrameViewListener();

        drawArea.addMouseListener(frameListener);
        drawArea.addMouseMotionListener(frameListener);
        drawArea.addMouseWheelListener(frameListener);

        add(horizontalScroll, BorderLayout.SOUTH);
        add(verticalScroll, BorderLayout.EAST);

    }

    @SuppressWarnings("serial")
    private class DrawArea extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponents(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // updateTransformation();
            g2.transform(transformation);

            for (FrameElement elem : frameNode.getModel().getFrameElements())
            {
                elem.getElemPainter().paint(g2, elem);

            }

            drawHandle(g2);

            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke((float) 1, BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_BEVEL, 1f, new float[]
                    { (float) 3, (float) 6 }, 0));
            g2.draw(selectionRectangle);

        }
    }

    public void drawHandle(Graphics2D g2)
    {
        // prolazimo kroz listu selektovanih elementa
        for (FrameElement elem : frameNode.selectionModel.getSelectedElements())
        {
            g2.setStroke(new BasicStroke((float) 1, BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_BEVEL, 1f, new float[]
                    { 3f, 6f }, 0));
            g2.setPaint(Color.BLACK);

            g2.drawRect((int) elem.getPos().getX(), (int) elem.getPos().getY(),
                    (int) elem.getSize().getWidth(), (int) elem.getSize()
                            .getHeight());

            // for(Handle h : Handle.values())
            {

                double size = handle_size;
                double x = elem.getPos().getX();
                double y = elem.getPos().getY();
                double w = elem.getSize().getWidth();
                double h = elem.getSize().getHeight();

                g2.fill(new Rectangle2D.Double(x - size / 2, y - size / 2,
                        size, size));
                g2.fill(new Rectangle2D.Double(x - size / 2 + w / 2, y - size
                        / 2, size, size));
                g2.fill(new Rectangle2D.Double(x - size / 2 + w, y - size / 2,
                        size, size));

                g2.fill(new Rectangle2D.Double(x - size / 2, y - size / 2 + h
                        / 2, size, size));
                g2.fill(new Rectangle2D.Double(x - size / 2 + w, y - size / 2
                        + h / 2, size, size));

                g2.fill(new Rectangle2D.Double(x - size / 2, y - size / 2 + h,
                        size, size));
                g2.fill(new Rectangle2D.Double(x - size / 2 + w / 2, y - size
                        / 2 + h, size, size));
                g2.fill(new Rectangle2D.Double(x - size / 2 + w, y - size / 2
                        + h, size, size));
            }
        }

    }
    
    //Vraca poziciju handela
    Point2D.Double getPointOfHandle(Point2D elemPos, Dimension size,
            Handle handle)
    {
        double x = 0, y = 0;

        // Određivanje y koordinate

        // Ako su gornji hendlovi
        if (handle == Handle.NorthWest || handle == Handle.North
                || handle == Handle.NorthEast)
        {
            y = elemPos.getY();
        }
        // Ako su centralni po y osi
        if (handle == Handle.East || handle == Handle.West)
        {
            y = elemPos.getY() + size.getHeight() / 2;
        }
        // Ako su donji
        if (handle == Handle.SouthWest || handle == Handle.South
                || handle == Handle.SouthEast)
        {
            y = elemPos.getY() + size.getHeight();
        }

        // Određivanje x koordinate

        // Ako su levi
        if (handle == Handle.NorthWest || handle == Handle.West
                || handle == Handle.SouthWest)
        {
            x = elemPos.getX();
        }
        // ako su centralni po x osi
        if (handle == Handle.North || handle == Handle.South)
        {
            x = elemPos.getX() + size.getWidth() / 2;
        }
        // ako su desni
        if (handle == Handle.NorthEast || handle == Handle.East
                || handle == Handle.SouthEast)
            x = elemPos.getX() + size.getWidth();

        return new Point2D.Double(x, y);

    }

    public void setMouseCursor(Point2D point)
    {
        Handle handle = getHandleFromPoint(point);

        if (handle != null)
        {
            Cursor cursor = null;

            switch (handle)
            {
            case SouthEast:
                cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
                break;
            case NorthWest:
                cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
                break;
            case SouthWest:
                cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
                break;
            case NorthEast:
                cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
                break;
            default:
                break;
            }
            drawArea.setCursor(cursor);
        }
        else
        drawArea.setCursor(Cursor.getDefaultCursor());
    }

    public Handle getHandleFromPoint(Point2D p)
    {
        for(FrameElement elem : frameNode.selectionModel.getSelectedElements())
        {
            for(Handle h : Handle.values())
            {
                if(isPointInHandle(elem, h, p))
                {
                    return h;
                }
            }
        }
        return null;
    }

    public boolean isPointInHandle(FrameElement element, Handle handle, Point2D p)
    {

        Point2D h = getPointOfHandle(element.getPos(), element.getSize(),
                handle);

        // ako se nalazi u x opsegu
     /*   if (p.getX() >= h.getX() && p.getX() <= h.getX() + element.getSize().width)
        {
            // ako u y opsegu
            if (p.getY() >= h.getY() && p.getY() <= h.getY() + element.getSize().height)
                return true;
        }*/

        return ( (Math.abs(p.getX()-h.getX())<=(double)handle_size/2) && 
                (Math.abs(p.getY()-h.getY())<=(double)handle_size/2) );
    }

    private class FrameViewListener extends MouseAdapter implements
            MouseMotionListener, MouseWheelListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {

            if (e.getButton() == MouseEvent.BUTTON1)
            {
                // treba nam ovo kad crtamo selection rectangle da znamo odakle
                // krece
                setPocetnaTacka(pointToUserSpace(e.getPoint()));
                stateManager.getState().draw(e, FrameView.this);
            }
        }
        
        @Override
        public void mousePressed(MouseEvent e)
        {
            
        }
        @Override
        public void mouseDragged(MouseEvent e)
        {
            stateManager.getState().drag(e, FrameView.this);
        }
        

        @Override
        public void mouseReleased(MouseEvent e)
        {
            stateManager.getState().released(e, FrameView.this);
        }
        
        @Override
        public void mouseMoved(MouseEvent e)
        {
            stateManager.getState().moved(e, FrameView.this);
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e)
        {

            if (e.getWheelRotation() > 0)
            {
                scaling += e.getWheelRotation() * scaleFactor;
            } else
            {
                scaling = 1;
                scaling += e.getWheelRotation() * scaleFactor;
            }

            Point preZuma = pointToUserSpace(e.getPoint());

            updateTransformation();

            Point posleZuma = pointToUserSpace(e.getPoint());

            translateX = posleZuma.x - preZuma.x;
            translateY = posleZuma.y - preZuma.y;

            updateTransformation();

            repaint();
        }
    }

    public void updateTransformation()
    {
        // transformation.setToIdentity();
        transformation.translate(translateX, translateY);
        transformation.scale(scaling, scaling);

    }

    public Point pointToUserSpace(Point p)
    {
        Point usrPoint = new Point();
        try
        {
            transformation.inverseTransform(p, usrPoint);
        } catch (NoninvertibleTransformException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return usrPoint;
    }

    public FrameNode getFrameNode()
    {
        return frameNode;
    }

    public void setFrame(FrameNode frameNode)
    {
        this.frameNode = frameNode;
    }

    public int getId()
    {
        return myId;
    }

    @Override
    public void updatePerformed(UpdateElementsEvent e)
    {
        this.repaint();
    }

    public StateManager getStateManager()
    {
        return stateManager;
    }

    public void setStateManager(StateManager stateManager)
    {
        this.stateManager = stateManager;
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        if (e.getAdjustable().getOrientation() == Adjustable.HORIZONTAL)
        {
            translateX = e.getValue() - hScroll;
            hScroll = e.getValue();
            updateTransformation();
            repaint();
        } else if (e.getAdjustable().getOrientation() == Adjustable.VERTICAL)
        {
            translateY = e.getValue() - vScroll;
            vScroll = e.getValue();
            updateTransformation();
            repaint();
        }

    }

    public Rectangle2D.Double getSelectionRectangle()
    {
        return selectionRectangle;
    }

    public void setSelectionRectangle(Rectangle2D.Double selectionRectangle)
    {
        this.selectionRectangle = selectionRectangle;
    }

    public Point getPocetnaTacka()
    {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(Point pocetnaTacka)
    {
        this.pocetnaTacka = pocetnaTacka;
    }

    public CommandManager getCommandManager()
    {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager)
    {
        this.commandManager = commandManager;
    }

}
