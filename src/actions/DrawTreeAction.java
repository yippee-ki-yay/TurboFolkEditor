package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import editorLook.MainFrame;
import frame.FrameView;

public class DrawTreeAction extends AbstractAction
{

    private static final long serialVersionUID = 8694871055944814060L;

    public DrawTreeAction()
    {
        putValue(ACCELERATOR_KEY,
                KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));

        putValue(SHORT_DESCRIPTION, "Draw tree");
        putValue(SMALL_ICON, new ImageIcon("img/tree_icon.png"));
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {

        ((FrameView) (MainFrame.getInstance().getDesktopManager()
                .getSelectedFrame())).getStateManager().setTreeState();
        MainFrame.getInstance().getStatusBar().setState("Add element");

    }

}
