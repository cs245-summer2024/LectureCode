
import java.util.Iterator;
public class SList<T> implements Iterable<T> {
    private class ListNode<T>{
        T item;
        ListNode next;

        private ListNode(T value){
            this.item = value;
            this.next = null;
        }

        private ListNode(T value, ListNode next){
            this.item = value;
            this.next = next;
        }
    }

    private class SListIterator implements Iterator<T>{
        ListNode runner;
        private SListIterator(ListNode node){
            runner = node;
        }

        public boolean hasNext(){
            return runner != null;
        }

        public T next(){
            T valueToReturn = (T)runner.item;
            runner = runner.next;
            return (T)valueToReturn;
        }
    }

    ListNode sentinelNode;
    public SList(){
        sentinelNode = new ListNode(-1);
    }
    public SList(T value){
        ListNode headNode = new ListNode(value);
        sentinelNode = new ListNode(null, headNode);
    }

    public void addFirst(T value){
        ListNode currentHeadNode = sentinelNode.next;
        ListNode newHeadNode = new ListNode(value, currentHeadNode);
        sentinelNode.next = newHeadNode;
    }

    public T removeFirst(){
        if(sentinelNode.next == null){
            return null;
        }
        ListNode headNode = sentinelNode.next;
        sentinelNode.next = headNode.next;
        headNode.next = null;
        return (T)headNode.item;
    }
    public T getFirst(){
        if(sentinelNode.next == null){
            return null;
        }
        return (T)sentinelNode.next.item;
    }

    private int size(ListNode node){
        if(node == null){
            return 0;
        }
        return 1 + size(node.next);
    }
    public int size(){
        return size(sentinelNode.next);
    }

    public String toString(){
        StringBuilder stringRepr = new StringBuilder();
        ListNode runner = sentinelNode.next;
        while(runner != null){
            stringRepr.append(runner.item);
            if(runner.next != null){
                stringRepr.append(",");
            }
            runner = runner.next;
        }
        return stringRepr.toString();
    }

    public SListIterator iterator(){
        return new SListIterator(sentinelNode.next);
    }
}
