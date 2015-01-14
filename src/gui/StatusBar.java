package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class StatusBar extends JPanel {
	private JLabel state;
	private JLabel type;
	private JLabel name;
	private JLabel pos;
	private JLabel dimension;

	public StatusBar() {
		setLayout(new GridLayout(1, 5));
		setBorder(new BevelBorder(BevelBorder.LOWERED));

		state = new JLabel("Select", JLabel.CENTER);
		state.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(state);

		type = new JLabel(" ", JLabel.CENTER);
		type.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(type);

		name = new JLabel(" ", JLabel.CENTER);
		name.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(name);

		pos = new JLabel(" ", JLabel.CENTER);
		pos.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(pos);

		dimension = new JLabel(" ", JLabel.CENTER);
		dimension.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(dimension);
	}

	public JLabel getState() {
		return state;
	}

	public void setState(String state) {
		this.state.setText(state);
	}

	public JLabel getType() {
		return type;
	}

	public void setType(String type) {
		this.type.setText(type);
	}

	public JLabel getElementName() {
		return name;
	}

	public void setElementName(String name) {
		this.name.setText(name);
	}

	public JLabel getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos.setText(pos);
	}

	public JLabel getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension.setText(dimension);
	}
	
	public void selectedReset()
	{
		name.setText(" ");
		type.setText(" ");
		dimension.setText(" ");
		pos.setText(" ");
	}

	
}
