package actions;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ProjectFileFilter extends FileFilter
{

    @Override
    public boolean accept(File f)
    {
        return (f.isDirectory() || 
                f.getName().toLowerCase().endsWith(".xxx"));
    }

    @Override
    public String getDescription()
    {
        return "EditorLook project files .xxx";
    }

}
