/**
 * Problem: CtCi Chapter 2 (linked lists) - Question 2.3
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
public class TestDeleteMiddleNode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleList myList = new SimpleList();
        myList.addToList(1);
        myList.addToList(47);
        myList.addToList(838);
        System.out.println("Test 1\nInitial list: " + myList.printList());
        deleteMiddleNode(myList.front.next);
        System.out.println("Deleting 2nd node \nResulting list: " + myList.printList());
        
        
        System.out.println("\nTest 2");
        myList.addToList(4);
        myList.addToList(83);
        myList.addToList(37);
        myList.addToList(673484);
        
        System.out.println("Initial list: " + myList.printList());
        deleteMiddleNode(myList.front.next.next.next);
        System.out.println("Deleting 4th node\nResulting list: " + myList.printList());
        
        System.out.println("\nTest 3 - last list item?");
        System.out.println("Initial list: " + myList.printList());
        deleteMiddleNode(myList.front.next.next.next.next);
        System.out.println("Deleting last node\nResulting list: " + myList.printList());
        
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
