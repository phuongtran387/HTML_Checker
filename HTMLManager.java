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
  public Queue<HTMLTag> getTags() {
        return tags;
  }
  
  public String toString() {
      String result = "";
      
      int size = tags.size();
      for(int i = 0; i < size; i ++){
          HTMLTag tag = tags.remove();
          result += tag.toString().trim();
          tags.add(tag);
      }
      
      return result;
  }
  public void fixHTML() {
       Stack<HTMLTag> stack = new Stack<HTMLTag>();
       Queue<HTMLTag> fixed = new Queue<HTMLTag>();
       
       while (!html.isEmpty()) {
           HTMLTag current = html.remove();
           
           A
       }
  }
}
