package frame;


import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import model.FrameNode;
import editorLook.MainFrame;

public class FrameView extends JInternalFrame
{
	private static final long serialVersionUID = -7657600321157734995L;
	
	
	private int myId = 0;
	private FrameNode frameNode;
	
	public FrameView(String title, int id, final FrameNode frameNode)
	{
		super(title, true, true, true, true);
		setSize(200, 200);
		setVisible(true);
		this.frameNode = frameNode;
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setFrameIcon(new ImageIcon("img/frame_node.png"));
		
		myId = id;
		
		this.addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				MainFrame.getInstance().getWorkspaceTree().selectNode(frameNode);
			}
		});
		
	
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

}
