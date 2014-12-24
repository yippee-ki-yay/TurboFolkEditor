package dialogs;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.elements.FrameElement;
import editorLook.MainFrame;

public class PropertyDialog extends JDialog {

	private static final long serialVersionUID = -7047955150791500854L;

    private JLabel nameLabel;
    private JLabel descLabel;
    
    private JTextField nameField;
    private JTextField descField;
	
    private JButton colorBtn;
    private JButton okBtn;
	
    private FrameElement fe;
    
	public PropertyDialog() 
	{
		super(MainFrame.getInstance(), "Property", true);
		setLocationRelativeTo(MainFrame.getInstance());
		
		setLayout(new GridLayout(3, 3));
		
		//JPanel mainLayout = new JPanel(new BoxLayout(this, BoxLayout.Y_AXIS));

		
		nameLabel = new JLabel("Element name: ");
		descLabel = new JLabel("Element description: ");
		
		nameField = new JTextField("");
		descField = new JTextField("");	
		
		colorBtn = new JButton("Choose color");
		
		//colorBtn.addActionListener(new ColorAction());
		
		okBtn = new JButton("Ok");
		
		okBtn.addActionListener(new OkAction());
		
		setResizable(false);
		
		add(nameLabel);
		add(nameField);
		add(descLabel);
		add(descField);
		add(colorBtn);
		add(okBtn);
		
		//add(mainLayout);
	
		pack();
		
		//setVisible(true);
		
	}
	
	public void setCurrElement(FrameElement elem)
	{
		fe = elem;
		nameField.setText(elem.getName());
		descField.setText(elem.getDesc());
		colorBtn.addActionListener(new ColorAction());
		
		setVisible(true);
	}
	
	private class ColorAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			Color color = JColorChooser.showDialog(PropertyDialog.this, 
					"Choose a color", Color.blue);
			
			fe.setPaint(color);
		}
		
	}
	
	private class OkAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			fe.setName(nameField.getText());
			fe.setDesc(descField.getText());
			fe.getNode().setName(nameField.getText());
			
			PropertyDialog.this.dispose();
		}
		
	}

}
