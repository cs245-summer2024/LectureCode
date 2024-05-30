public class ArraySorter {
    public static void swap(int[] numbers, int idx1, int idx2){
        // TODO
        int temp = numbers[idx1];
        numbers[idx1] = numbers[idx2];
        numbers[idx2] = temp;
    }

    public static int findIndexOfSmallest(int[] numbers, int startingIdx) {
        int returnIdx = startingIdx;
        int arrLen = numbers.length;
        for(int runningIdx = startingIdx; runningIdx < arrLen; runningIdx ++){
            if(numbers[runningIdx] < numbers[returnIdx]){
                returnIdx = runningIdx;
            }
        }
        return returnIdx;
    }

    public static void sort(int[] numbers) {
        if(numbers == null){
            return;
        }
        int arrLen = numbers.length;
        for(int idx = 0; idx < arrLen; idx ++){
            int smallestIdx = findIndexOfSmallest(numbers, idx);
            swap(numbers, idx, smallestIdx);
        }
    }
}
