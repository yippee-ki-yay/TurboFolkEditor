package gui;


import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class StatusBar extends JPanel
{
	JLabel welcomeMsg;
	JLabel stageMsg;
	JLabel progressMsg;
	
	JLabel Msg1;
	JLabel Msg2;
	
	public StatusBar()
	{
		setLayout(new GridLayout(1, 5));
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		welcomeMsg  = new JLabel("Status", JLabel.CENTER);
		welcomeMsg.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(welcomeMsg);
		
		
		Msg1 = new JLabel("Status", JLabel.CENTER);
		Msg1.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(Msg1);
		
		
		Msg2 = new JLabel("Status", JLabel.CENTER);
		Msg2.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(Msg2);
	
		
	    stageMsg    = new JLabel("Status", JLabel.CENTER);
	    stageMsg.setBorder(new BevelBorder(BevelBorder.LOWERED));
	    add(stageMsg);

	    
	    progressMsg = new JLabel("Status", JLabel.CENTER);
	    progressMsg.setBorder(new BevelBorder(BevelBorder.LOWERED));
	    add(progressMsg);
	}
}
