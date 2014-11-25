package editorLook;


import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

//TODO Za sada rasporedi prozore random po JDesktopPane
//Kasnije napravi neku LayoutKlasu koja na razlicite nacine
//rasporedjuje i resizuje framove

public class DefaultForm extends JInternalFrame
{
	private static final long serialVersionUID = -7657600321157734995L;
	
	private int myId = 0;
	
	public DefaultForm(String title, int id)
	{
		super(title, true, true, true, true);
		setSize(200, 200);
		setVisible(true);
		
		myId = id;
		
		this.addInternalFrameListener(new InternalFrameListener() {
			
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameIconified(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameDeiconified(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameDeactivated(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameClosing(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				setVisible(false);
				/*MainFrame.getInstance().getTree()
				         .deleteNode(e.getInternalFrame().getTitle());*/
				
			}
			
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				String name = e.getInternalFrame().getTitle();
				MainFrame.getInstance().getTree().setSelected(name);
				
			}
		});
	
	}
	
	public int getId()
	{
		return myId;
	}
}
