package editorLook;


import javax.swing.JDesktopPane;

@SuppressWarnings("serial")
public class FormManager extends JDesktopPane
{
	JDesktopPane desktop;
	
	public FormManager()
	{
		desktop = new JDesktopPane();
		//desktop.setMinimumSize(new Dimension(400, 400));
	}

	public JDesktopPane getDesktop() {
		return desktop;
	}

	public void setDesktop(JDesktopPane desktop) {
		this.desktop = desktop;
	}
}
