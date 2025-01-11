package Linked_list_based_implementation;

class Node<E> {
    private E data;
    private Node next;
    Node(E data,Node next)
    {
        this.data=data;
        this.next=next;
    }

    void setNext(Node next) {
        this.next = next;
    }

    Node getNext() {
        return next;
    }

    E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
