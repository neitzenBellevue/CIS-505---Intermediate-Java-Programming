/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package BowlingShopApp;
import java.util.LinkedList;

public class GenericQueue<E> {
    // The following is a Generic Linked List.
    private LinkedList<E> list = new LinkedList<E>();

    /*
     * This method takes any object and queues it into the front of this classes linked list.
     * @param item E
     */
    public void enqueue(E item){
        list.addFirst(item);
    } // End enqueue

    // This removes the first object in this classes linked list.
    public E dequeue(){
        return list.removeFirst();
    } // End dequeue()

    // This returns the size of this classes linked list.
    public int size(){
        return list.size();
    } // End size()
} // End GenericQueue
