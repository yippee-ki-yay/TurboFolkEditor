package editorLook;

import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public class DefaultForm extends JInternalFrame
{
	public DefaultForm()
	{
		super("New Frame", true, true, true, true);
		setLocation(100, 100);
		setSize(200, 200);
		setVisible(true);
	}
}
