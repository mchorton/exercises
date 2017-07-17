/**
 * Problem: CtCi Chapter 2 (linked lists) - Question 2.3
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
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
    public void addToList(int data) {
        SimpleNode newNode = new SimpleNode(data);
        if (front == null) {
            front = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
    }
    
    /**
     * A way to display the existing list.
     * @return A string representation of the list.
     */
    public String printList() {
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
