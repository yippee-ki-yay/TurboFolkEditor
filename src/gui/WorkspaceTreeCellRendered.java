package gui;

import java.awt.Component;
import java.lang.annotation.ElementType;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.ElementNode;
import model.FrameNode;
import model.ProjectNode;
import model.ElementNode.ElemType;

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

			Icon icon = null;
		
	      if (value instanceof FrameNode ) {
                  
              icon = new ImageIcon("img/frame_node.png");
              setIcon(icon);

          } else if (value instanceof ProjectNode ) {                  
              icon = new ImageIcon("img/project_node.png");
              setIcon(icon);
          } else if(value instanceof ElementNode)
          {
        	  if(((ElementNode)value).getType() == ElemType.RECTANGLE)
        	  {
        		  icon = new ImageIcon("img/rectangle_node.png");
        	  }
        	  else if(((ElementNode)value).getType() == ElemType.TRIANGLE)
        	  {
        		  icon = new ImageIcon("img/triangle_node.png"); 
        	  }
        	  else if(((ElementNode)value).getType() == ElemType.CIRCLE)
        	  {
        		  icon = new ImageIcon("img/circle_node.png"); 
        	  }
        	
              setIcon(icon);
          }
              
              return this;
	}
}
