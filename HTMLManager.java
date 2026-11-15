import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  public HTMLManager(Queue<HTMLTag> htlm) {
      if (html == null) {
          throw new IllegalAgrumentException("htlm queue cannot be null");
      }
      
      tag = new LinkedList<HTMLTag>();
      
      int size = html.size();
      for (int i = 0; i < size; i++) {
          HTMLTag tag = html.remove();
          tags.add(tag);
          html.add(tag);
      }
  }
}
