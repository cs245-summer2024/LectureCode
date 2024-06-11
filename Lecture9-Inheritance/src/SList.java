import java.util.List;

public class SList<T>{
    protected static class ListNode<T> {
        T item;
        ListNode next;

        ListNode(T value) {
            this.item = value;
            this.next = null;
        }
    }

    private ListNode sentinelNode;
    public SList() {
        this.sentinelNode = new ListNode(null);
    }

    public SList(T value) {
        ListNode headNode = new ListNode(value);
        this.sentinelNode = new ListNode(null);
        this.sentinelNode.next = headNode;
    }

    public void addFirst(T item) {
        ListNode newHead = new ListNode(item);
        ListNode oldHead = sentinelNode.next;
        newHead.next = oldHead;
        sentinelNode.next = newHead;
    }

    public int size(){
        return sizeHelper(sentinelNode.next);
    }

    private int sizeHelper(ListNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + sizeHelper(node.next);
    }
}
