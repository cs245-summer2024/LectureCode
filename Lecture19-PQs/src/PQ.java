import java.util.*;
/*
    Priority Queue powered by a min-heap demo implementation
 */
public class PQ<Item extends Comparable>{

    private int heapSize;
    private ArrayList<Item> heap;

    public PQ(){
        heapSize = 0;
        heap = new ArrayList<>();
        heap.add(null);
    }

    public void insert(Item value){
        heap.add(value);
        heapSize += 1;
        bubbleUp(heapSize);
    }

    public Item peek(){
        if(heapSize == 0){
            return null;
        }
        return heap.get(1);
    }

    public Item poll(){
        if(heapSize == 0){
            return null;
        }
        Item value = heap.get(1);
        heap.set(1, heap.get(heapSize));
        heap.remove(heapSize);
        heapSize -= 1;

        bubbleDown(1);
        return value;
    }

    private void bubbleUp(int nodeIdx){
        int parentIdx = nodeIdx / 2;
        if(parentIdx != 0) {
            Item childValue = heap.get(nodeIdx);
            Item parentVal = heap.get(parentIdx);
            if(parentVal.compareTo(childValue) > 0) { // Swap if parent > child
                swap(nodeIdx, parentIdx);
                bubbleUp(parentIdx);
            }
        }
    }

    private void bubbleDown(int nodeIdx){
        int listSize = heapSize + 1;
        Item parentVal = heap.get(nodeIdx);

        if(2 * nodeIdx < listSize) {// Check to see if there is left child
            int childIdx = 2 * nodeIdx;
            Item leftChildValue = heap.get(2 * nodeIdx);
            if(2 * nodeIdx + 1 < listSize) { // Check to see if there is right child
                Item rightChildValue = heap.get(2 * nodeIdx + 1);
                if(leftChildValue.compareTo(rightChildValue) >= 0) { // Determine which child is smaller
                    childIdx = 2 * nodeIdx + 1;
                }
            }
            if(parentVal.compareTo(heap.get(childIdx)) > 0) { // Swap if parent > child
                swap(nodeIdx, childIdx);
                bubbleDown(childIdx);
            }
        }
    }

    public void swap(int a, int b){
        Item temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i = 1; i < 1 + heapSize; i ++){
            result.append(heap.get(i).toString());
            if(i < heapSize){
                result.append(",");
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        int[] n = {1, 2, 4, 5, 8, 3, 20, 15};
        PQ<Integer> pq = new PQ<>();
        for(int i: n){
            pq.insert(i);
        }
        System.out.println(pq);

        System.out.println(pq.peek());

        pq.poll();

        System.out.println(pq.peek());

        System.out.println(pq);
    }
}
