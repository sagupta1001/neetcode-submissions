class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // return k most frequent elements 
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freqMap.merge(nums[i], 1, Integer::sum);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        for (Map.Entry<Integer, Integer> mapEntry : freqMap.entrySet()) {
            minHeap.add(new int[]{mapEntry.getValue(), mapEntry.getKey()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        int resCounter = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            res[resCounter++] = curr[1];
        }

        return res;
    }
}
