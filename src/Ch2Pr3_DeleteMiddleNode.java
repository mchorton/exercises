/**
 * Problem: CtCi Chapter 2 (linked lists) - Question 3  
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node. Problem specifies that the node is not the first 
 * or last node in the list, so direct access to list reference is not explicitly
 * required, and more importantly, is not a precondition to the problem.
 * 
 * Class purpose: 
 * This class tests the algorithm implementation and displays the results.
 * The algorithm implementation is a static method in this test class. An 
 * implementation which does not require a direct reference to the list/list front
 * is ideal, and such an implementation would not require iteration over the 
 * entire list. 
 * 
 * @author lizzy
 */
public class Ch2Pr3_DeleteMiddleNode {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleList myList = new SimpleList();
        myList.addToEnd(1);
        myList.addToEnd(47);
        myList.addToEnd(838);
        System.out.println("Test 1\nInitial list: " + myList.toString());
        deleteMiddleNode(myList.front.next);
        System.out.println("Deleting 2nd node \nResulting list: " + myList.toString());
        
        
        System.out.println("\nTest 2");
        myList.addToEnd(4);
        myList.addToEnd(83);
        myList.addToEnd(37);
        myList.addToEnd(673484);
        
        System.out.println("Initial list: " + myList.toString());
        deleteMiddleNode(myList.front.next.next.next);
        System.out.println("Deleting 4th node\nResulting list: " + myList.toString());
        
        System.out.println("\nTest 3 - last list item?");
        System.out.println("Initial list: " + myList.toString());
        deleteMiddleNode(myList.front.next.next.next.next);
        System.out.println("Deleting last node\nResulting list: " + myList.toString());
        
    }
    
    /**
     * Solution to CtCi problem.
     * @param node The list node which must be acted upon.
     */
    private static void deleteMiddleNode(SimpleNode node) {
        if (node.next == null) {
            node = null;
        } else {
            node.data = node.next.data;
            if (node.next.next == null) {
                node.next = null;
            } else {
                SimpleNode temp = node.next.next;
                node.next = temp;
            }
        }
        
    }
    
}
