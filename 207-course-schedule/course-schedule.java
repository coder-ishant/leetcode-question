class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Step 1: Build graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Step 2: Add all courses with 0 in-degree to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int completedCourses = 0;

        // Step 3: Process queue
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCourses++;

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 4: Check if all courses are completed
        return completedCourses == numCourses;
    }
}