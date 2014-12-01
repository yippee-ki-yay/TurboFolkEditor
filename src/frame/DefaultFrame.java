package frame;


import javax.swing.JInternalFrame;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import model.Frame;
import editorLook.MainFrame;

public class DefaultFrame extends JInternalFrame
{
	private static final long serialVersionUID = -7657600321157734995L;
	
	
	private int myId = 0;
	
	public DefaultFrame(String title, int id)
	{
		super(title, true, true, true, true);
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(
                WindowConstants.HIDE_ON_CLOSE);
		
		myId = id;
		
		this.addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				MainFrame.getInstance().getWorkspaceTree().selectNode(myId);
			}
		});
		
	
	}
	
	public int getId()
	{
		return myId;
	}

}
