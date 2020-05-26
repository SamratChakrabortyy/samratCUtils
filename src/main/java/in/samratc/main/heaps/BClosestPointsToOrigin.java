package in.samratc.main.heaps;

import in.samratc.util.Heap;
import in.samratc.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BClosestPointsToOrigin {

    public static void main(String... args) {
        int b = 65, arr[][] = {
                {927, -858},
                {-682, 620},
                {900, -890},
                {-962, 939},
                {672, -805},
                {-949, 711},
                {944, -1050},
                {-683, 758},
                {1015, -881},
                {-630, 1048},
                {818, -705},
                {-630, 809},
                {646, -646},
                {-781, 998},
                {840, -871},
                {-824, 1017},
                {895, -806},
                {-1011, 957},
                {857, -601},
                {-648, 1051},
                {991, -967},
                {-783, 980},
                {627, -1018},
                {-714, 743},
                {725, -1000},
                {-497, 252},
                {112, -447},
                {-339, 187},
                {340, -142},
                {-175, 212},
                {104, -257},
                {-160, 411},
                {411, -491},
                {-353, 335},
                {88, -404},
                {-311, 119},
                {416, -221},
                {-215, 388},
                {389, -305},
                {-177, 492},
                {205, -93},
                {-455, 261},
                {164, -148},
                {-370, 268},
                {211, -460},
                {-8, 155},
                {33, -322},
                {-489, 368},
                {463, -346},
                {-179, 83},
                {352, -197},
                {-16, 462},
                {486, -406},
                {-238, 135},
                {240, -463},
                {-45, 234},
                {467, -488},
                {-272, 335},
                {211, -303},
                {-226, 207},
                {387, -93},
                {-249, 286},
                {426, -165},
                {-351, 102},
                {435, -138},
                {-326, 164},
                {337, -251},
                {-32, 45},
                {53, -130},
                {-82, 247},
                {63, -319},
                {-128, 162},
                {71, -182},
                {-26, 202},
                {218, -269},
                {-249, 483},
                {246, -421},
                {-203, 119},
                {246, -319},
                {-397, 476},
                {41, -332},
                {-403, 234},
                {258, -363},
                {-407, 61},
                {269, -102},
                {-71, 31},
                {23, -382},
                {-306, 175},
                {391, -431},
                {-349, 299}
        };
        ArrayList<ArrayList<Integer>> points = new ArrayList<>();
        for (int[] p : arr) {
            ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.stream(p).boxed().collect(Collectors.toList()));
            points.add(temp);
        }
        System.out.println(new BClosestPointsToOriginSol().solve(points, b));
    }

}

class BClosestPointsToOriginSol {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> points, int b) {
        ArrayList<ArrayList<Integer>> closePoints = new ArrayList<>();
        List<Pair<Integer, Integer>> pointPair = points.stream().map(p -> new Pair<>(p.get(0), p.get(1))).collect(Collectors.toList());
        Heap<Pair<Integer, Integer>> minhPairHeap = new Heap<>(pointPair, this::compareDistanceBetweenPoints);
        while (!minhPairHeap.isEmpty() && b-- > 0) {
            Pair<Integer, Integer> closestPoint = minhPairHeap.removeRoot();
            closePoints.add(new ArrayList<Integer>(Arrays.asList(closestPoint.val1, closestPoint.val2)));
        }
        return closePoints;
    }

    private long distanceFromOrigin(long x, long y) {
        return x * x + y * y;
    }

    private int compareDistanceBetweenPoints(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        return Long.compare(distanceFromOrigin(a.val1, a.val2), distanceFromOrigin(b.val1, b.val2));
    }
}