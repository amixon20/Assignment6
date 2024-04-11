import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Election {
    static class Node {
        String name;
        int votes;
        Node(String name, int votes) {
            this.name = name;
            this.votes = votes;
        }
    }
    List<Node> heap = new ArrayList<Node>();
    int m;
    int p;

    public void setP(int p) {
        this.p = p;
    }

    public int getTotalVotesCast() {
        int total = 0;
        for(Node node : heap) {
            total += node.votes;
        }
        return total;
    }

    public void initializeCandidates(LinkedList<String> candidates) {
        for(String string : candidates) {
            heap.add(new Node(string, 0));
        }
        int index = heap.size() - 1;
        m = heap.size();
        /*while(index !=0) {
            int parentIndex = (index - 1) / 2;
            if(heap.get(parentIndex).votes < heap.get(index).votes) {
                Node temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(index));
                heap.set(index, temp);
            }
            index--;*/
        //}
    }
    public void castVote(String candidate) {
        if (getTotalVotesCast() < p) {
            Node no = null;
            for (Node node : heap) {
                if (node.name.equals(candidate)) {
                    no = node;
                    node.votes++;
                }
            }
            int i = heap.indexOf(no);
            while (i > 0) {

                int parentIndex = (i - 1) / 2;

                if (heap.get(i).votes <= heap.get(parentIndex).votes) {
                    return;
                } else {
                    Node temp = heap.get(parentIndex);
                    heap.set(parentIndex, heap.get(i));
                    heap.set(i, temp);
                    i = parentIndex;
                }
            }
        }
        else {
            System.out.println("All votes already cast.");
        }
    }
    public void castRandomVote() {
        if (getTotalVotesCast() < p) {
            Random r = new Random();
            int index = r.nextInt(heap.size() - 1);
            Node node = heap.get(index);
            node.votes++;

            int i = heap.indexOf(node);
            while (i > 0) {

                int parentIndex = (i - 1) / 2;

                if (heap.get(i).votes <= heap.get(parentIndex).votes) {
                    return;
                } else {
                    Node temp = heap.get(parentIndex);
                    heap.set(parentIndex, heap.get(i));
                    heap.set(i, temp);
                    i = parentIndex;
                }
            }
        }
        else {
            System.out.println("All votes already cast.");
        }
    }
    public void rigElection(String candidate) {
        int maxVotes = heap.getFirst().votes;
        Node maxNode = heap.getFirst();
        Node riggedNode = null;
        for (Node node : heap) {
            if (node.votes >= maxVotes) {
                maxVotes = node.votes;
                maxNode = node;
            }
            if (node.name.contains(candidate)) {
                riggedNode = node;
            }
        }
        if (maxNode == riggedNode) {
            return;
        } else {
            while (riggedNode.votes < maxNode.votes && getTotalVotesCast() <= p) {
                maxNode.votes--;
                riggedNode.votes++;
            }
        }
        int i = heap.indexOf(riggedNode);
        while (i > 0) {

            int parentIndex = (i - 1) / 2;

            if (heap.get(i).votes < heap.get(parentIndex).votes) {
                return;
            } else {
                Node temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(i));
                heap.set(i, temp);
                i = parentIndex;
            }
        }
    }
    public String[] getTopKCandidates(int k) {
        String[] topKCandidates = new String[k];
        for(int i = 0; i < k; i++) {
            topKCandidates[i] = heap.get(i).name;
        }
        return topKCandidates;
    }
    public void auditElection() {
        for(int i = 0; i < heap.size(); i++) {
            System.out.println("\n" + "Name: " + heap.get(i).name + " Votes: " + heap.get(i).votes);
        }
    }
}
