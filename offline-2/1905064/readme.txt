Assalamu Alaikum...

In this project, I created stack classes using array and linked list. I also
implemented dishwasher concept using array, linked list and 1 array 2 stack idea.


In stack interface I kept all the functions I needed to implement through array or
linked list.stack_array and stack_list implemented this stack interface.


stack_array class has used array to simulate the stack. we can only access the current element
added in the array. we call that top. push function append a new top in the array and pop function 
delete the current top. 

I created a Node class to simulate the nodes of stack_list class.this node class has the classic node's 
components: data and address to the next node.

stack_list class used nodal idea to implement the stack. Here, pushing means creating a new node with a data
and the previous top becomes its next node. pop deletes the current top and make the next node its new top.

I created a main function called stack_testing to check my stack.

to implement dishwasher, I created a dishInfo class to track a dish's owner friend,
pushing time and cleaning time. Basically my dirty and clean stacks are consist of these
dishInfo objects. whenever a dish is cleaned, i update its cleaning time. 


In implementations class, I simulated the dishwashing with array, linkedList and
1 array 2 stack implementation of stack. All of them are basically same except the
instantiation part.