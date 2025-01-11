package List_implementation;

class node<E> {
    private E data;
    private node next;
    node(E data,node next)
    {
        this.data=data;
        this.next=next;
    }

    void setNext(node next) {
        this.next = next;
    }

    node getNext() {
        return next;
    }

    E getData() {
        return data;
    }
}
