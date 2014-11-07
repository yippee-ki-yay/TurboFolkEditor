package editorLook;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MyToolBar extends JToolBar{
	
	public MyToolBar(){
		//u konstruktor nadklase, tj klse JToolbar prosleđuje
		//se orijentacija toolbar-a, moguća i sa konstantom: SwingConstants.VERTICAL
		
		super(SwingConstants.HORIZONTAL);
		JButton btnNew = new JButton();
		btnNew.setAction(MainFrame.getInstance().getActionManager().getFormAction());
		
		btnNew.setToolTipText("New");
		btnNew.setIcon(new ImageIcon("img/new_22x22.jpg"));
		
		
		add(btnNew);

		addSeparator();

		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("img/open_22x22.jpg"));
		add(btnOpen);
	
		addSeparator();
		
		JToggleButton tglBtnBold=new JToggleButton();
		tglBtnBold.setToolTipText("Bold");
		tglBtnBold.setIcon(new ImageIcon("img/bold_22x22.jpg"));
		add(tglBtnBold);
		

		//toolbar je pokretljiv, probati i sa statičnim toolbarom
		setFloatable(true);
		setBackground(new Color(255,255,204));
	
}

}
