import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  public HTMLManager(Queue<HTMLTag> html) {
      if (html == null) {
          throw new IllegalArgumentException("htlm queue cannot be null");
      }
      
      tags = new LinkedList<HTMLTag>();
      
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
  
  //return all tags as a String
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
  
  //fix HTML tags
  public void fixHTML() {
       Stack<HTMLTag> stack = new Stack<HTMLTag>();
       Queue<HTMLTag> fixed = new LinkedList<HTMLTag>();
       
       while (!tags.isEmpty()) {
           HTMLTag current = tags.remove();
           
           
           // Case 1: self-closing tag
           if (current.isSelfClosing()) {
               fixed.add(current);
           }
           
           
           //case 2: opening tag
           else if (current.isOpening()) {
               fixed.add(current);
               stack.push(current);
           }
           
           //closing tag
           else if (current.isClosing()) {
           
           //no opening tag to match
                if (stack.isEmpty()) {
                   continue;
                }
                
                
              //close any opening tags that are out of order
                while (!stack.isEmpty() && !stack.peek().matches(current)) {
                
                HTMLTag missingClose = stack.pop().getMatching();
                fixed.add(missingClose);
                }
                
               //match the current closing tag
                if (!stack.isEmpty()) {
                   fixed.add(current);
                   stack.pop();
                }
           }
       }
       //close any remaining opening tags
       while(!stack.isEmpty()) {
           fixed.add(stack.pop().getMatching());
       }
       tags = fixed;
  }
}
