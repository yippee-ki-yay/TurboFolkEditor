package gui;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Frame;
import model.Project;

public class WorkspaceTreeCellRendered  extends DefaultTreeCellRenderer
{

	public WorkspaceTreeCellRendered() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Component getTreeCellRendererComponent( JTree tree, Object value,
													boolean sel, boolean expanded,
													boolean leaf, int row,
													boolean hasFocus)
	{
		
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

	      if (value instanceof Frame ) {
                  
              Icon icon = new ImageIcon("img/tdiagram.gif");
              setIcon(icon);

          } else if (value instanceof Project ) {                  
              Icon icon = new ImageIcon("img/tproject.gif");
              setIcon(icon);
          }
              
              return this;
	}
}
