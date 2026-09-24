package Graph;

import java.util.*;

public class LC_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            String name = accounts.get(i).get(0);

            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                emailToName.put(email, name);
                graph.putIfAbsent(email, new ArrayList<>());

                if (j < accounts.get(i).size() - 1) {
                    String nextEmail = accounts.get(i).get(j + 1);

                    graph.putIfAbsent(nextEmail, new ArrayList<>());

                    graph.get(email).add(nextEmail);
                    graph.get(nextEmail).add(email);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();

        HashSet<String> visited = new HashSet<>();
        for (String email : graph.keySet()) {
            List<String> emails = new ArrayList<>();

            if (!visited.contains(email)) {
                dfs(graph, visited, emails, email);
                Collections.sort(emails);
                emails.add(0, emailToName.get(email));
                ans.add(emails);
            }
        }
        return ans;
    }

    private  void dfs (HashMap<String, List<String>> graph, HashSet<String> visited, List<String> emails, String email){
        if (visited.contains(email)) return;
        visited.add(email);
        emails.add(email);
        for (String currEmail : graph.get(email)) {
            dfs(graph, visited, emails, currEmail);
        }
    }
}
