public class AList<Item> {
    private int listSize = 0;
    private Item[] elements;
    static final int growthFactor = 2;

    public AList(int initialCapacity){
        this.elements = (Item[]) new Object[initialCapacity];
    }

    // Retrieves the Item at index i in the AList
    public Item get(int i){
        if(i < 0 || i > size()){
            throw new ArrayIndexOutOfBoundsException("Index out of bounds for list of size " + size());
        }
        return elements[i];
    }

    // Returns the number of elements in the AList
    public int size(){
        return listSize;
    }

    // Insert value at the location at a specified index
    public void insertElement(int insertionIdx, Item value){
        if(insertionIdx < 0 || insertionIdx > size()) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds for list of size " + size());
        }
        if(elements.length == size()) {
            resize();
        }
        for(int idx = size() - 1; idx >= insertionIdx; idx --) {
            elements[idx + 1] = get(idx);
        }
        elements[insertionIdx] = value;
        listSize += 1;
    }

    // Remove the value at a specified index
    public void removeElement(int removalIdx){
        if(size() < 0 || removalIdx < 0 || removalIdx > size()) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds for list of size " + size());
        }
        for(int idx = removalIdx; idx < size() - 1; idx ++) {
            elements[idx] = get(idx + 1);
        }
        elements[size() - 1] = null;
        listSize -= 1;
        // Dynamically shrinking the underlying array when required can be added here.
    }

    private void resize() {
        Item[] newElements =  (Item[]) new Object[growthFactor * size()];
        System.arraycopy(elements, 0, newElements, 0, size());
        this.elements = newElements;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int idx = 0; idx < size(); idx++){
            if(get(idx) != null){
                builder.append(get(idx).toString());
                if(idx < size() - 1) {
                    builder.append(",");
                }
            }
        }
        return builder.toString();
    }
}
