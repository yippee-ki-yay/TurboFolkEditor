package frame;


import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import model.FrameNode;
import model.elements.FrameElement;
import model.elements.RectangleElement;
import painters.ElementPainter;
import editorLook.MainFrame;
import events.UpdateElementsEvent;
import events.UpdateElementsListener;

public class FrameView extends JInternalFrame implements UpdateElementsListener
{
	private static final long serialVersionUID = -7657600321157734995L;
	
	
	private int myId = 0;
	private FrameNode frameNode; //referenca ka nodu u drvetu koja predstavlja frame
	private DrawArea drawArea;
	
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
		
		drawArea = new DrawArea();
		add(drawArea, BorderLayout.CENTER);
		
		frameNode.getModel().addUpdateElementsListener(FrameView.this);
		
		
		this.addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				MainFrame.getInstance().getWorkspaceTree().selectNode(frameNode);
			}
		});
		
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				if (e.getButton()==MouseEvent.BUTTON1)
				{
					Point p = e.getPoint();
					
					System.out.println(p.x + "  " + p.y);
					
					Paint paint = new Color(255, 255, 255);
					Stroke stroke = new BasicStroke(1);
					RectangleElement mojElement = new RectangleElement(paint, stroke, 
							p, new Dimension(10, 10));
					
					frameNode.getModel().addElement(mojElement);
				}
			}
		});
	
	}
	
	
	@SuppressWarnings("serial")
	private class DrawArea extends JPanel
	{
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponents(g);
			Graphics2D g2 = (Graphics2D)g;

			
			for(FrameElement elem : frameNode.getModel().getFrameElements())
			{
				elem.getElemPainter().paint(g2, elem);
			}

		}
	}
	
	public FrameNode getFrame() {
		return frameNode;
	}

	public void setFrame(FrameNode frameNode) {
		this.frameNode = frameNode;
	}

	public int getId()
	{
		return myId;
	}

	@Override
	public void updatePerformed(UpdateElementsEvent e) {
		this.repaint();
	}

}
