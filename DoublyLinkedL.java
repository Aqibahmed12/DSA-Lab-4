/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author EURO COMPUTERS
 */
public class DoublyLinkedL{
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
    Node head;
    Node tail;
    
    void addAtStart(int data){
        
        Node newNode = new Node(data) ;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    void addAtEnd(int data){
    
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    void addAtPos(int data, int position){
    
        Node newNode=new Node(data);
        Node current=head;
        
        if(position < 0){
            System.out.println("invalid");
        }
        else if(position == 0){
            addAtStart(data);
        }
        else if (current == tail) {
            addAtEnd(data);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
        }
        
    }
    void deleteFromStart() {
        if (head == null) {
            System.out.println("List is null");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }
    void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
    void deleteByValue(int data){
        
        Node current = head;
        
        while (current != null) {
            
            if (current.data == data) {
                
                if (current == head) {
                    deleteFromStart();
                    
                } else if (current == tail) {
                    deleteFromEnd();
                    
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Value is not available");
    
    }
    void displayFromStart(){
    
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }
    void displayFromEnd(){
    
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.prev;
        }
        System.out.println("null");
        
    }
        
    void search(int value){
        
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Value found at position: " + position);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("not found");
    }
    
    void reverse() {
        Node current = head;
        Node temp = null;
        
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }
    
    void countNodes(){
    
        Node current=head;
        int count=0;
    
        while(current != null){
        count++;
        current=current.next;
        }
        System.out.println("total values in List :"+ count);
    }
    
    public static void main(String[] args) {
    
        DoublyLinkedL list=new DoublyLinkedL();
        
        list.addAtStart(10);
        list.addAtPos(20, 1);
        list.addAtPos(30, 2);
        list.addAtPos(40, 3);
        list.addAtPos(50, 4);
        list.addAtEnd(40);
        
        list.displayFromStart();
//        list.displayFromEnd();
        list.deleteByValue(10);
//        list.reverse();
//        list.search(20);
        list.displayFromStart();
        list.countNodes();
        
    }
}