//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    public Node sort(Node head) {
        Node ascendingHead = new Node(0);
        Node descendingHead = new Node(0);
        splitList(head, ascendingHead, descendingHead);
        ascendingHead = ascendingHead.next;
        descendingHead = descendingHead.next;
        descendingHead = reverseList(descendingHead);
        head = mergeLists(ascendingHead, descendingHead);
        return head;
    }
    private Node reverseList(Node head) {
        Node current = head;
        Node prev = null;
        Node nextNode;
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    private Node mergeLists(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Node mergedHead = new Node(0);
        Node current = mergedHead;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        current.next = (head1 != null) ? head1 : head2;
        return mergedHead.next;
    }
    private void splitList(Node head, Node ascendingHead, Node descendingHead) {
        Node ascendingNode = ascendingHead;
        Node descendingNode = descendingHead;
        Node current = head;
        while (current != null) {
            ascendingNode.next = current;
            ascendingNode = ascendingNode.next;
            current = current.next;
            if (current != null) {
                descendingNode.next = current;
                descendingNode = descendingNode.next;
                current = current.next;
            }
        }
        ascendingNode.next = null;
        descendingNode.next = null;
    }
}