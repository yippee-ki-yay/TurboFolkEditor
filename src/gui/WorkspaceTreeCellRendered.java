package gui;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.FrameNode;
import model.ProjectNode;

public class WorkspaceTreeCellRendered  extends DefaultTreeCellRenderer
{
	private static final long serialVersionUID = 721606794428157750L;

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

	      if (value instanceof FrameNode ) {
                  
              Icon icon = new ImageIcon("img/frame_node.png");
              setIcon(icon);

          } else if (value instanceof ProjectNode ) {                  
              Icon icon = new ImageIcon("img/project_node.png");
              setIcon(icon);
          }
              
              return this;
	}
}
