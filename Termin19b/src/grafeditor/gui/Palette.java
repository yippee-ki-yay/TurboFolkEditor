package grafeditor.gui;

import grafeditor.app.AppCore;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class Palette extends JToolBar{

	public Palette() {
		super(JToolBar.VERTICAL);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ButtonGroup group = new ButtonGroup();


		JToggleButton btn2=new JToggleButton(AppCore.getInstance().getActionManager().getPhandCursorAction());
		group.add(btn2);
		add(btn2);
		
		addSeparator();

		
		

		JToggleButton btn3=new JToggleButton(AppCore.getInstance().getActionManager().getpRectangleAction());
		group.add(btn3);
		add(btn3);
		
		
		

		
		JToggleButton btn4=new JToggleButton(AppCore.getInstance().getActionManager().getpCircleAction());
		group.add(btn4);
		add(btn4);


		
		JToggleButton btn6=new JToggleButton(AppCore.getInstance().getActionManager().getPlinkAction());
		group.add(btn6);
		add(btn6);		
		
	}

}
