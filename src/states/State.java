package states;

import java.awt.event.MouseEvent;

import model.FrameNode;

public interface State {
	public void draw(MouseEvent e, FrameNode node);
}
