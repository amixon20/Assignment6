import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class ElectionSystem {


    public static void main(String[] args) {
        Election sera = new Election();

        LinkedList<String> candidates = new LinkedList<>();
        Random r = new Random();
        int n = r.nextInt(3) + 1;
        int p = r.nextInt(10) + 10;
        switch (n) {
            case 1:
                candidates.add("Marcus Fenix");
                candidates.add("Dominic Santiago");
                candidates.add("Damon Baird");
                candidates.add("Cole Train");
                candidates.add("Anya Stroud");

                sera.initializeCandidates(candidates);

                sera.setP(p);

                sera.castVote("Cole Train");
                sera.castVote("Cole Train");
                sera.castVote("Marcus Fenix");

                sera.castRandomVote();
                sera.castRandomVote();

                System.out.println("Top " + p + " Candidates:" + "\n");
                System.out.println(Arrays.toString(sera.getTopKCandidates(3)) + "\n");

                sera.rigElection("Dominic Santiago");

                System.out.println("Election Results:" + "\n");
                sera.auditElection();
                break;
            case 2:
                candidates.add("Hamish Arroyo");
                candidates.add("Christopher Kemp");
                candidates.add("Poppy Harris");
                candidates.add("Isobel Clarke");
                candidates.add("Clarence Jordan");
                candidates.add("Leia Pennington");
                candidates.add("Anita Wong");
                candidates.add("Lea Barker");
                candidates.add("Armaan Oneill");
                candidates.add("Sandra Fitzgerald");

                sera.initializeCandidates(candidates);

                sera.setP(p);

                sera.castVote("Armaan Oneill");
                sera.castVote("Sandra Fitzgerald");
                sera.castVote("Armaan Oneill");

                sera.castRandomVote();
                sera.castRandomVote();
                sera.castRandomVote();
                sera.castRandomVote();
                sera.castRandomVote();

                System.out.println("Top " + p + " Candidates:" + "\n");
                System.out.println(Arrays.toString(sera.getTopKCandidates(6)) + "\n");

                sera.rigElection("Hamish Arroyo");

                System.out.println("Election Results:" + "\n");
                sera.auditElection();
                break;
            case 3:
                candidates.add("Felicity Rhodes");
                candidates.add("Bertie Tate");
                candidates.add("Anthony Massey");
                candidates.add("Annika Vaughan");
                candidates.add("Tyrone Carney");
                candidates.add("Harry Potter");

                sera.initializeCandidates(candidates);

                sera.setP(p);

                sera.castVote("Tyrone Carney");
                sera.castVote("Bertie Tate");
                sera.castVote("Bertie Tate");

                sera.castRandomVote();
                sera.castRandomVote();
                sera.castRandomVote();
                sera.castRandomVote();
                sera.castRandomVote();

                System.out.println("Top " + p + " Candidates:" + "\n");
                System.out.println(Arrays.toString(sera.getTopKCandidates(6)) + "\n");

                sera.rigElection("Harry Potter");

                System.out.println("Election Results:" + "\n");
                sera.auditElection();
                break;
        }
    }
}
