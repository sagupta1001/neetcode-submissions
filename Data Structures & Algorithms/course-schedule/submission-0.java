class Solution {
    // problem
    // return true if it is possible to finish all courses

    // approach
    // brute force
    // check if it is possible to take course 0
    // then 1, 2 and all the way up to nc-1
    // to check if it is possible take course "i"
    // see if it has any pre-reqs by checking the 
    // prerequisites array
    // we could store the prereqs in an adjacency list
    // to help
    // also this feels like a topological sort
    // algorithm question but i don't remember how to implement
    // that algo from university
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            adjList.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]] += 1;
        }

        // add indegree 0 to queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        // while queue not empty
        int numCoursesCompleted = 0;
        while (queue.size() != 0) {
            Integer currentCourse = queue.poll();
            numCoursesCompleted++;
            for (Integer nei : adjList.get(currentCourse)) {
                indegree[nei] -= 1;
                if (indegree[nei] == 0) queue.add(nei);
            }
            
        }
        // - take the course
        // - "complete it"
        // - decrement indegree of dependent courses
        // - add courses with indegree zero

        // return numCourses completed == numCourses

        return numCoursesCompleted == numCourses;
    }
}
