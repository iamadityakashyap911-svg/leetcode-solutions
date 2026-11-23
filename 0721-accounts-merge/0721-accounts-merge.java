import java.util.*;

class Solution {
    Map<String, String> parent = new HashMap<>();

    private String find(String x) {
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    private void union(String a, String b) {
        String rootA = find(a);
        String rootB = find(b);

        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parent.putIfAbsent(email, email);
                emailToName.put(email, name);

                union(account.get(1), email);
            }
        }

        Map<String, List<String>> groups = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(email);
            groups.computeIfAbsent(root, x -> new ArrayList<>())
                  .add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> emails : groups.values()) {
            Collections.sort(emails);

            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(emails.get(0)));
            merged.addAll(emails);

            result.add(merged);
        }

        return result;
    }
}