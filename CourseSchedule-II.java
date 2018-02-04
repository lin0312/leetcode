class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //initialize inCount
        int[] inCount = new int[numCourses];
        //construct inCount
        for(int i = 0; i < prerequisites.length; i++) {
            inCount[prerequisites[i][0]]++;
        }
        //initialize queue
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(inCount[i] == 0) {
                queue.offer(i);
            }
        }
        //BFS
        int count = 0;
        int[] res = new int[numCourses];
        while(!queue.isEmpty()) {
            int course = queue.poll();
            res[count] = course;
            count++;
            for(int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == course) {
                    int post = prerequisites[i][0];
                    inCount[post]--;
                    if(inCount[post] == 0) {
                        queue.offer(post);
                    }
                }
            }
        }
        if(count == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }
}
