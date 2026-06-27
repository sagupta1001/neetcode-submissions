class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int s : stones) {
            minHeap.offer(-s);
        }

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();

            if (first < second) {
                minHeap.offer(first - second);
            }
        }

        minHeap.offer(0);
        return Math.abs(minHeap.peek());
    }
}
