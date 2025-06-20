import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Please write your code here.

        int minScore = 101;
        String agentName = "";
        Agent[] agents = new Agent[5];
        for (int i = 0; i < 5; i++) {
            String codeName = sc.next();
            int score = sc.nextInt();

            agents[i] = new Agent(codeName, score);
            minScore = Math.min(minScore, agents[i].score);
            if (minScore == agents[i].score) {
                agentName = agents[i].codeName;
            }
        }
        System.out.print(agentName + " " + minScore);
    }

    
}

class Agent {
    String codeName;
    int score;

    Agent(String codeName, int score) {
        this.codeName = codeName;
        this.score = score;
    }
}