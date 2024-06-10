/*
    Class the mimicks the behavior of a queue using two stacks implemented
    as Singly Linked Lists
 */
public class FunkyQueue<T> {
    SList queueContents;
    SList bufferStack;

    public FunkyQueue() {
        queueContents = new SList<T>();
        bufferStack = new SList<T>();
    }

    public boolean enqueue(T item) {
        queueContents.addFirst(item);
        return true;
    }

    public T dequeue() {
        /*
            queueContents: 1, 2, 3, 4, 5 and goal is to return 5
            bufferStack: 4, 3, 2, 1
         */
        while(queueContents.size() > 0) {
            bufferStack.addFirst(queueContents.removeFirst());
        }

        T valueToReturn = (T)bufferStack.removeFirst();

        while(bufferStack.size() > 0) {
            queueContents.addFirst(bufferStack.removeFirst());
        }
        return valueToReturn;
    }

    public String toString() {
        while(queueContents.size() > 0) {
            bufferStack.addFirst(queueContents.removeFirst());
        }

        String stringRepr = bufferStack.toString();

        while(bufferStack.size() > 0) {
            queueContents.addFirst(bufferStack.removeFirst());
        }
        return stringRepr;
    }
}
