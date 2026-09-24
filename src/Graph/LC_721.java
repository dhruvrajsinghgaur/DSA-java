package Graph;

import java.util.*;

public class LC_721 {

    // N = total number of email occurrences across all accounts
    // U = number of unique emails
    // K = total cost of sorting all merged email groups
    // Here α(U) is the inverse Ackermann function, which is effectively a tiny constant for any practical input approx O(1).

    // Method 0. (it uses DisjointSet).
    // TC: O(N α(U) + K log K).
    // SC: O(U).
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> emailId = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();
        int Id = 0;

        for (int i = 0; i < accounts.size(); i++) {
            String name = accounts.get(i).get(0);

            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                emailToName.put(email, name);

                if(!emailId.containsKey(email)) {
                    emailId.put(email, Id);
                    Id++;
                }
            }
        }

        DisjointSet ds = new DisjointSet(Id);

        for (int i = 0; i < accounts.size(); i++) {
            String email = accounts.get(i).get(1);
            int eI = emailId.get(email);

            for (int j = 2; j < accounts.get(i).size(); j++) {
                String currEmail = accounts.get(i).get(j);
                int ceI = emailId.get(currEmail);
                ds.union(eI, ceI);
            }
        }

        HashMap<Integer, List<String>> groups = new HashMap<>();

        for (String email : emailId.keySet()) {
            int id = emailId.get(email);
            int root = ds.find(id);

            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for (List<String> emails : groups.values()) {
            Collections.sort(emails);
            emails.add(0, emailToName.get(emails.get(0)));
            ans.add(emails);
        }

        return ans;
    }

    // Method 1. (it uses DFS).
    // TC: O(N + K log K).
    // SC: O(N + U).
    public List<List<String>> accountsMerge1(List<List<String>> accounts) {
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
