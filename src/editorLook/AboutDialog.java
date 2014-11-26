package editorLook;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class AboutDialog extends JDialog
{
	private static final long serialVersionUID = 4304325916606827425L;

	JLabel imgLabel;
	JTextArea textArea;
	
	JLabel surLabel;
	JLabel nameLabel;
	JLabel emailLabel;
	JLabel indeksLabel;
	
	JButton closeBtn;
	
	public AboutDialog()
	{
		super(MainFrame.getInstance(), "About", true);
		setResizable(false);
		
		imgLabel = new JLabel();
		Icon icon = new ImageIcon("img/mojaslika.jpg");
		imgLabel.setBorder(new TitledBorder("Image"));
		imgLabel.setIcon(icon);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		nameLabel = new JLabel("<html><b>Name</b>: Nenad </html>");
		surLabel = new JLabel("<html><b>Surname</b>: Palinkasevic </html>");
		emailLabel = new JLabel("<html><b>Email</b>:<u> nesa993@gmail.com </u> </html>");
		indeksLabel = new JLabel("<html> <b>Index</b>: <i>RA-191/2012 </i> <html>");
		
		
		leftPanel.setBorder(new TitledBorder("Information"));
		
		leftPanel.add(nameLabel);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		leftPanel.add(surLabel);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		leftPanel.add(emailLabel);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		leftPanel.add(indeksLabel);
		
		JPanel southPanel = new JPanel();
		closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AboutDialog.this.dispose();
				
			}
		});
		
		southPanel.add(closeBtn);
		
		add(leftPanel, BorderLayout.WEST);
		add(imgLabel, BorderLayout.EAST);
		add(new JLabel(" "), BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(MainFrame.getInstance());
	}
	
}
