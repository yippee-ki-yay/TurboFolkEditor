package events;

import java.util.EventListener;

public interface UpdateElementsListener extends EventListener
{
  
  public void updatePerformed(UpdateElementsEvent e);
}
