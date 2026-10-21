import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations,
                                double[] values,
                                List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                result[i] = -1.0;
            } else if (a.equals(b)) {
                result[i] = 1.0;
            } else {
                result[i] = dfs(graph, a, b, 1.0, new HashSet<>());
            }
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph,
                       String current,
                       String target,
                       double product,
                       Set<String> visited) {

        if (current.equals(target)) {
            return product;
        }

        visited.add(current);

        for (Map.Entry<String, Double> entry :
                graph.get(current).entrySet()) {

            String next = entry.getKey();

            if (!visited.contains(next)) {
                double result = dfs(
                    graph, next, target,
                    product * entry.getValue(), visited
                );

                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}