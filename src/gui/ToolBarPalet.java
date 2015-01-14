package gui;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import editorLook.MainFrame;

public class ToolBarPalet extends JToolBar
{
    private static final long serialVersionUID = 8682572116787789541L;

    public ToolBarPalet()
    {

        super(JToolBar.VERTICAL);
        setFloatable(true);

        ButtonGroup btnGroup = new ButtonGroup();

        JToggleButton bt1 = new JToggleButton(MainFrame.getInstance()
                .getActionManager().getSelectAction());
        JToggleButton bt3 = new JToggleButton(MainFrame.getInstance()
                .getActionManager().getCircleAction());
        JToggleButton bt4 = new JToggleButton(MainFrame.getInstance()
                .getActionManager().getTriangleAction());
        JToggleButton bt5 = new JToggleButton(MainFrame.getInstance()
                .getActionManager().getSquareAction());
        JToggleButton bt6 = new JToggleButton(MainFrame.getInstance()
                .getActionManager().getTreeAction());

        btnGroup.add(bt1);
        btnGroup.add(bt3);
        btnGroup.add(bt4);
        btnGroup.add(bt5);
        btnGroup.add(bt6);

        add(bt1);
        add(bt3);
        add(bt4);
        add(bt5);
        add(bt6);

    }
}
