import static org.junit.jupiter.api.Assertions.*;

class FunkyQueueTest {
    @org.junit.jupiter.api.Test
    void testEmpty() {
        FunkyQueue<Integer> myQueue = new FunkyQueue<>();
        assertTrue(myQueue.toString().equals(""));
    }

    @org.junit.jupiter.api.Test
    void testEnqueue() {
        int[] valuestoAdd = {1, 5, 9, 3, 2, 9, 15, 21};
        String expected = "1,5,9,3,2,9,15,21";
        FunkyQueue<Integer> myQueue = new FunkyQueue<>();

        for(Integer i: valuestoAdd) {
            myQueue.enqueue(i);
        }
        assertTrue(myQueue.toString().equals(expected));
    }

    @org.junit.jupiter.api.Test
    void testDequeueEmpty() {
        FunkyQueue<Integer> myQueue = new FunkyQueue<>();
        assertTrue(myQueue.dequeue() == null);
    }
    @org.junit.jupiter.api.Test
    void testDequeue() {
        int[] valuestoAdd = {1, 5, 9, 3, 2, 9, 15, 21};
        String expected = "9,3,2,9,15,21";
        FunkyQueue<Integer> myQueue = new FunkyQueue<>();
        for(Integer i: valuestoAdd) {
            myQueue.enqueue(i);
        }
        myQueue.dequeue();
        assertTrue((int)myQueue.dequeue() == 5);
        assertTrue(myQueue.toString().equals(expected));
    }

    @org.junit.jupiter.api.Test
    void testEnqueueDequeue() {
        int[] valuestoAdd = {1, 5, 9, 3, 2, 9, 15, 21};
        String expected = "1,5,9,3,2,9,15,21";
        int numValues = valuestoAdd.length;
        FunkyQueue<Integer> myQueue = new FunkyQueue<>();

        for(Integer i: valuestoAdd) {
            myQueue.enqueue(i);
        }
        for(int i = 0; i < numValues; i ++) {
            myQueue.dequeue();
        }
        assertTrue(myQueue.toString().equals(""));

        for(Integer i: valuestoAdd) {
            myQueue.enqueue(i);
        }
        assertTrue(myQueue.toString().equals(expected));
    }

}