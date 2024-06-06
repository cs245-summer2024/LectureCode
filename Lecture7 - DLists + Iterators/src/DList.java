import java.util.PriorityQueue;
import java.util.Queue;
public class DList<T> {
    private class DListNode {
        DListNode prev;
        DListNode next;
        T item;

        private DListNode(T value){
            this.item = value;
            this.prev = null;
            this.next = null;
        }

        private DListNode(T value, DListNode prev, DListNode next){
            this.item = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private DListNode sentFront;
    private DListNode sentBack;

    public DList(T value){
        sentFront = new DListNode(null);
        sentBack = new DListNode(null);
        
        DListNode headNode = new DListNode(value, sentFront, sentBack);
        
        sentFront.next = headNode;
        sentBack.prev = headNode;
    }

    public DList(){
        sentFront = new DListNode(null);
        sentBack = new DListNode(null, sentFront, null);
        sentFront.next = sentBack;
    }

    public void insertElement(int index, T value){
        /*
            Examples:

            List: sf <--> 10 <-->5 <--> 7 <--> 12 <--> 3 <--> 4 <--> sb



            insert 100 at index 2: sf <--> 10 <--> 5 <--> 100 <--> 7 <--> 12 <--> 3 <--> 4 <--> sb
         */
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds for list of size " + size());
        } else {
            DListNode runner = sentFront.next;
            int runnerCount = 0;
            while(runnerCount < index) {
                runner = runner.next;
                runnerCount += 1;
            }

            DListNode prevNode = runner.prev; // 5 Node and runner is 7 node
            DListNode nodeToInsert = new DListNode(value, prevNode, runner);
            prevNode.next = nodeToInsert; // Set 5 node.next to point to 100 node
            runner.prev = nodeToInsert; // set 7 node.prev to poin to 100 node
        }
    }

    public int size(DListNode node){
        if(node.next == null || node == sentBack){
            return 0;
        }
        return 1 + size(node.next);
    }
    public int size(){
        return size(sentFront.next);
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        DListNode runner = sentFront.next;
        while(runner != sentBack){
            result.append(runner.item);
            runner = runner.next;
            if(runner != sentBack){
                result.append(",");
            }
        }
        return result.toString();
    }
}
