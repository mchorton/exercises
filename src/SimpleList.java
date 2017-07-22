/**
 * Problem: CtCi Chapter 2 (linked lists)
 * 
 * Class purpose:  
 * Setting up data structure for problem. This class defines a linked list.
 * 
 * @author lizzy
 */
public class SimpleList {
    
    public SimpleNode front;
    
    public SimpleList() {
        front = null;
    }
    
    /**
     * Method to build a list so the list can be operated on.
     * @param data An integer value to be stored in an ordered list
     */
    public void addToFront(int data) {
        SimpleNode newNode = new SimpleNode(data);
        if (front == null) {
            front = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
    }
    
    public void addToEnd(int data) {
        SimpleNode newNode = new SimpleNode(data);
        if (front == null) {
            front = newNode;
        } else {
            SimpleNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    /**
     * A way to display the existing list.
     * @return A string representation of the list.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (front != null) {
            result.append(front.data);
            if (front.next != null) {
                SimpleNode current = front.next;
                while (current.next != null) {
                    result.append(", " + current.data);
                    current = current.next;
                }
                result.append(", " + current.data);
            }
        } else {
            result.append("List is empty");
        }
        return result.toString();
    }
    
    /*
    public void deleteMiddleNode(SimpleNode node) {
        if (node == front) {
            front = node.next;
        } else {
            SimpleNode current = front;

            
        }
    }
    */
    
}
