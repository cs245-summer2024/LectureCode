package Solver;

import java.util.*;
/*
    Priority Queue powered by a min-heap demo implementation
 */
public class PQ<Item extends Comparable>{

    private int heapSize;
    private Comparator comparator;
    private ArrayList<Item> heap;

    public PQ(){
        heapSize = 0;
        this.comparator = null;
        heap = new ArrayList<>();
        heap.add(null);
    }

    public PQ(Comparator comparator){
        heapSize = 0;
        this.comparator = comparator;
        heap = new ArrayList<>();
        heap.add(null);
    }

    /*
        Insert element into the Priority Queue
     */
    public void insert(Item value){
        heap.add(value);
        heapSize += 1;
        bubbleUp(heapSize);
    }

    /*
        Inspect but don't remove the element at top of the priority queue.
     */
    public Item peek(){
        if(heapSize == 0){
            return null;
        }
        return heap.get(1);
    }

    /*
       Remove and return the element at top of the priority queue.
    */
    public Item poll(){
        if(heapSize == 0){
            return null;
        }
        Item value = heap.get(1);
        if(size() == 1) {
            heap.remove(1);
            heapSize = 0;
        } else {
            heap.set(1, heap.remove(heapSize));
            heapSize -= 1;
            bubbleDown(1);
        }
        return value;
    }

    /*
        Helper function used during insert() operation.
     */
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

    /*
       Helper function used during poll() operation.
    */
    private void bubbleDown(int nodeIdx){
        int listSize = heapSize + 1;
        Item parentVal = heap.get(nodeIdx);

        if(2 * nodeIdx < listSize) {// Check to see if there is left child
            int childIdx = 2 * nodeIdx;
            Item leftChildValue = heap.get(2 * nodeIdx);
            Item childValue = leftChildValue;
            if(2 * nodeIdx + 1 < listSize) { // Check to see if there is right child
                Item rightChildValue = heap.get(2 * nodeIdx + 1);
                if(leftChildValue.compareTo(rightChildValue) >= 0) { // Determine which child is smaller
                    childIdx = 2 * nodeIdx + 1;
                    childValue = heap.get(2 * nodeIdx + 1);
                }
            }

            // Use the comparator if specified, otherwise use item's compareTo method
            if(comparator != null) {
                if(comparator.compare(parentVal, childValue) > 0) {// Swap if parent > child
                    swap(nodeIdx, childIdx);
                    bubbleDown(childIdx);
                }
            } else {
                if(parentVal.compareTo(childValue) > 0) { // Swap if parent > child
                    swap(nodeIdx, childIdx);
                    bubbleDown(childIdx);
                }
            }
        }
    }

    public void swap(int a, int b){
        Item temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    public int size() {
        return heapSize;
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
}