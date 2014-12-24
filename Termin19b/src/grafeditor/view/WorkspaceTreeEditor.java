package grafeditor.view;

import grafeditor.model.workspace.Project;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

public class WorkspaceTreeEditor  extends DefaultTreeCellEditor implements ActionListener{
    private Object tt=null;
    private JTextField edit=null;
    private JTree arg0;
    
	public WorkspaceTreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
		super(arg0, arg1);
		
		// TODO Auto-generated constructor stub
	}

	public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
		// TODO Auto-generated method stub
		super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
		tt=arg1;
		this.arg0 = arg0;
		edit=new JTextField(arg1.toString());
		
		edit.addActionListener(this);

		return edit;
	}
/*

	public boolean isCellEditable(EventObject arg0) {
		if (arg0!=null){
		if (arg0 instanceof MouseEvent)
			System.out.println(arg0);
			
			if (((MouseEvent)arg0).getButton()==3){
				return true;
			}
			else return false;
		
		//	if (((MouseEvent)arg0).getClickCount()==3){
				
		//	}
			//	return false;
		}
		return false;
	}
*/
	

	public void actionPerformed(ActionEvent e){
      ((Project)tt).setName(e.getActionCommand());	
      arg0.requestFocus();
      
      
      
	 	
	 
	}





	

}
