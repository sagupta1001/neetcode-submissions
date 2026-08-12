class MedianFinder {

    // problem
    // implement a data structure to return median of elements
    // so far

    // approach
    // the list should be sorted at all times
    // then computing median is easy, can be done in constant time

    // how to keep a sorted list at all times
    // list
    // lets say 1 comes in
    // add to the end
    // lets say 2 comes in
    // find the position using binary search
    // so logarithmic time at best for addNum to find the index
    // and then adding the element to a list is O(N)
    // findMedian would be constant time

    // can we do better than O(N) for addNum?
    // do we need to even store all nums?
    // most likely we do because median depends on maintaining the 
    // two central elements
    // binary search tree?
    // add would be logarithmic to find the index and add to BST

    // findMedian would be to look at the root if odd size, or root & root.right
    // 3, 1, 2, 4
    //   3
    // 1.  4
    //   2

    // 5, 2, 3, 1, 0, 6
    // 0, 1, 2, 3, 5, 6
    //     5
    //   2.   6
    //  1   3 
    // 0
    // median would be root & root.left's rightmost child
    // in a BST looks like finding median is not straightforward

    // heap?
    // only helps with tracking min and max
    // won't work here

    // feels like we need a custom data structure, the standard
    // ones like list, trees, heaps etc won't work here

    // Smaller half — largest element is at the top
    private PriorityQueue<Integer> maxHeap;

    // Larger half — smallest element is at the top
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            minHeap.offer(num);
            return;
        }

        if (num <= minHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Rebalance
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
