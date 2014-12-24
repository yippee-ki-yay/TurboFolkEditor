package grafeditor.view;

import grafeditor.model.workspace.Diagram;
import grafeditor.model.workspace.Project;

import java.awt.Component;
import java.net.URL;
import java.util.EventObject;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;

public class WorkspaceTreeCellRendered extends DefaultTreeCellRenderer {

	public WorkspaceTreeCellRendered() {
		//setOpaque(true);
	
		// TODO Auto-generated constructor stub
	}

	  public Component getTreeCellRendererComponent(
              JTree tree,
              Object value,
              boolean sel,
              boolean expanded,
              boolean leaf,
              int row,
              boolean hasFocus) {
                  super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);
                  
             
             if (value instanceof Diagram ) {
                 URL imageURL = getClass().getResource("images/tdiagram.gif");
                 Icon icon = null;
                 if (imageURL != null)                       
                     icon = new ImageIcon(imageURL);
                 setIcon(icon);
                 setToolTipText(((Diagram)value).toString());
                 
                 
 
             } else if (value instanceof Project ) {
                 URL imageURL = getClass().getResource("images/tproject.gif");
                 Icon icon = null;
                 if (imageURL != null)                       
                     icon = new ImageIcon(imageURL);
                 setIcon(icon);
                 setToolTipText(value.toString());

                 
                   
            } 
            return this;
}


	  }  



