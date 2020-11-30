package Lesson3;


import java.util.Arrays;

class Node {
    public Node(Object data) {
        this.data = data;
    }
    Object data;
    Node next;
}

public class LList {
    private Node root;

    public void add(Object item) {
        Node tmpItem = new Node(item);
        Node lastItem = findLast();

        if (lastItem!=null){
            lastItem.next=tmpItem;
        } else {
            root=tmpItem;
        }
    }

    public Object get(int id) {
        int currIndex = 0;
        Node currNode = root;
        while (currNode!=null) {
                if (currIndex==id){
                    return currNode.data;
                } else {
                    currIndex++;
                    currNode= currNode.next;
                }
        }
        System.out.println("Задан неверный id листа");
        return null;
    }

    public int size() {
        int size = 0;
        if (root == null) {
            return 0;
        } else {
            size = 1;

            Node current = root;
            while (current.next != null) {
                size++;
                current = current.next;
            }
        }
        return size;
    }

    public  Node findLast() {
        Node current = null;

        if (root == null) {
            return current;
        } else {
            current = root;
            while (current.next != null) {
                current = current.next;
            }
        }
        return current;
    }

    public String toString()
    {
     String strArr[] = new String[size()];
     int idx = 0;
     Node tmp = root;

     while (tmp!=null){
         strArr[idx++]=tmp.data.toString();
         tmp=tmp.next;
     }
    return Arrays.toString(strArr);
    }
}
