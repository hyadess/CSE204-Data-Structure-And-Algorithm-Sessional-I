Assalamu Alaikum...

In this project, I created queue classes using array and linked list. I also
implemented bank concept using array and linked list.


In queue interface I kept all the functions I needed to implement through array or
linked list.arrayQueue and listQueue implemented this stack interface.


arrayQueue class has used circular array to simulate the queue. we can access the front and rear element
added in the array. enqueue function append a new rear in the array and dequeue function
delete the current front. leaveQueue is used to delete the rear value

I created a Node class to simulate the nodes of listQueue class.This node class has the classic node's
components: data and address to the next node.

listQueue class used nodal idea to implement the stack. Here, enqueueing means creating a new node with a data
and the previous front becomes its next node. dequeue deletes the current top and make the next node its new top.

I created a main function called queue_testing to check my queue.

to implement bank, I created a customerInfo class to track a customer's entry and service time. Basically my queues are consist of these
customerInfo objects.


In implementations class, I simulated the bank with array and  linkedList.
Both of them are basically same except the instantiation part.