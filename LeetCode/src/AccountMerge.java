import jdk.nashorn.internal.parser.JSONParser;

import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 10/21/20.
 */
public class AccountMerge {

    public static class Node {
        Node parent;
        String name;
        List<String> accounts = new ArrayList<>();

        public Node(String name){
            this.name = name;
            this.parent = this;
        }
    }
    public Node findParent(Node node){
        while (node.parent != node.parent.parent) {
            node.parent.parent = node.parent.parent.parent;
            node.parent = node.parent.parent;
        }

        return node.parent;
    }

    public  List<List<String>> accountsMerge(List<List<String>> accounts) {
        // union find
        Map<String, Node> emailToNodeMap = new HashMap<>();
        List<Node> allNodeList = new ArrayList<>(accounts.size());
        for (List<String> account : accounts) {
            String name = account.get(0);
            Node node = new Node(name);
            allNodeList.add(node);

            for (int i=1; i<account.size(); i++) {
                String email = account.get(i);
                if (!emailToNodeMap.containsKey(email)) {
                    emailToNodeMap.put(email, node);
                    node.accounts.add(email);
                } else {
                    Node currParent = findParent(node);
                    Node existingParent = findParent(emailToNodeMap.get(email));
                    currParent.parent = existingParent;
                }
            }

        }

        // update parent account
        for (Node node : allNodeList) {
            if (node.parent != node) {
                Node parent = findParent(node);
                parent.accounts.addAll(node.accounts);
            }
        }

        // display
        List<List<String>> result = new ArrayList<>();
        for (Node node : allNodeList) {
            if (node.parent == node) {
                List<String> account = new ArrayList<>(node.accounts.size()+1);
                account.add(node.name);
                Collections.sort(node.accounts);
                account.addAll(node.accounts);
                result.add(account);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AccountMerge m = new AccountMerge();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));
        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));
        System.out.println(m.accountsMerge(accounts));

    }



}
