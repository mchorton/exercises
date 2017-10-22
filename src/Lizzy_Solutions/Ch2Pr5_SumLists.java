/**
 * Problem: CtCi Chapter 2 (linked lists) - Question 5
 * You have two numbers represented by a linked list, where each node contains a single ditig. The 
 * digits are stored in REVERSE order, such that the 1's digit is at the head of the list. Write a 
 * function that adds the two numbers and returns the sum as a linked list.
 * 
 * Class purpose: 
 * This class tests the algorithm implementation and displays the results.
 * The algorithm implementation is a static method in this test class. 
 * 
 * @author lizzy
 */
public class Ch2Pr5_SumLists {
    
    public static void main(String[] args) {
        
        // test 1
        SimpleList list1 = new SimpleList();
        list1.addToEnd(7);
        list1.addToEnd(1);
        list1.addToEnd(6);
        
        SimpleList list2 = new SimpleList();
        list2.addToEnd(5);
        list2.addToEnd(9);
        list2.addToEnd(2);
        
        SimpleList test1 = sumLists(list1, list2);
        System.out.println("Test 1\nInitial List 1: " + list1.toString() + "\nInitial List 2: " + list2.toString());
        System.out.println("Result: " + test1.toString()); 
                
        // test 1
        SimpleList list3 = new SimpleList();
        list3.addToEnd(1);
        list3.addToEnd(1);
        list3.addToEnd(1);
        
        SimpleList list4 = new SimpleList();
        list4.addToEnd(8);
        list4.addToEnd(9);
        list4.addToEnd(9);
        list4.addToEnd(9);
        list4.addToEnd(9);
        
        SimpleList test2 = sumLists(list3, list4);
        System.out.println("Test 2\nInitial List 1: " + list3.toString() + "\nInitial List 2: " + list4.toString());
        System.out.println("Result: " + test2.toString()); 
    }
    
    /**
     * Solution to CtCi problem
     * @param list1 The linked list containing the first number to be summed
     * @param list2 The linked list containing the second number to be summed
     * @return The sum of the two arguments, expressed as a linked list of digits 0-9
     */
    public static SimpleList sumLists(SimpleList list1, SimpleList list2) {
        SimpleList result = new SimpleList();
        int val1 = 0;
        int val2 = 0;
        int carry = 0;
        SimpleNode node1 = list1.front;
        SimpleNode node2 = list2.front;
        while (node1 != null || node2 != null || carry != 0) {
                if (node1 != null) {
                    val1 = node1.data;
                    node1 = node1.next;
                } else {
                    val1 = 0;
                }
                if (node2 != null) {
                    val2 = node2.data;
                    node2 = node2.next;
                } else {
                    val2 = 0;
                }
                result.addToEnd((val1 + val2 + carry) % 10);
                carry = (val1 + val2 + carry) / 10;
            }
        
        return result;
    }    
}
