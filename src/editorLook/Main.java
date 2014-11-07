package editorLook;

import javax.swing.SwingUtilities;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MainFrame mf = MainFrame.getInstance();
				mf.createApp();
				mf.setVisible(true);
				
			}
		});

	}

}
