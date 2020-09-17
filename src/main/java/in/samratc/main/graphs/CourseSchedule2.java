import java.util.stream.*;
import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0)
			return IntStream.range(0, numCourses).toArray();
		List<List<Integer>> graph = new ArrayList<>();
		IntStream.range(0, numCourses).forEach(i -> graph.add(new ArrayList<>()));
		int[] inDegree = new  int[numCourses];
		for(int[] prerequisite : prerequisites){
			graph.get(prerequisite[1]).add(prerequisite[0]);
			inDegree[prerequisite[0]]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < numCourses; i++){
			if(inDegree[i] == 0)
				q.add(i);
		}
		List<Integer> order = new ArrayList<>();
		while(!q.isEmpty()){
			int curr = q.remove();
			for(int i : graph.get(curr)){
				inDegree[i]--;
				if(inDegree[i] == 0)
					q.add(i);
			}
			order.add(curr);
		}
		return order.size() == numCourses ? order.stream().mapToInt(i -> i).toArray() : new int[]{};
    }
}
