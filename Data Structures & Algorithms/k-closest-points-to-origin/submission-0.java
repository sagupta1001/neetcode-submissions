class Solution {
    // approach
    // find distance of each point from the origin
    // and return the top K

    // store in a min heap
    // object stored in the min heap would be
    // distance to origin -> index of point in the points array

    // iterate through points
    // compute distance to origin
    // add to min heap of size K

    // iterate through min heap
    // for each node in min heap get the index in the points array
    // add to result array the coordinate at the index in the points array

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (Integer.compare(b[0], a[0])));

        for (int[] point : points) {
            int distanceSquared = point[0]*point[0] + point[1]*point[1];

            maxHeap.offer(new int[]{distanceSquared, point[0], point[1]});

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int cur = 0;
        while (maxHeap.size() != 0) {
            int[] point = maxHeap.poll();
            res[cur][0] = point[1];
            res[cur++][1] = point[2];
        }

        return res;
    }
}
