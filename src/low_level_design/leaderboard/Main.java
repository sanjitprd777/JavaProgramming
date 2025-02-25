package low_level_design.leaderboard;

public class Main {

    public static void main(String[] args) {
        LeaderBoard leaderBoard = new LeaderBoard();
        leaderBoard.add("Sanjit", "India");
        leaderBoard.add("Sanjit", "India");
        leaderBoard.add("Sanjit", "India");

        leaderBoard.get(3);

        leaderBoard.add("Surendra", "China");
        leaderBoard.get(4);
        leaderBoard.add("Sahil", "America");
        leaderBoard.get(5);
        leaderBoard.add("Sahil", "America");
        leaderBoard.get(5);

        leaderBoard.add("Sahil", "America");
        leaderBoard.add("Sahil", "America");
        leaderBoard.add("Sahil", "America");

        leaderBoard.get(9);
        leaderBoard.get(10);

        leaderBoard.add("a", "b");
        leaderBoard.get(10);

        leaderBoard.add("a", "b");
        leaderBoard.get(10);

        leaderBoard.add("a", "b");
        leaderBoard.get(10);

        leaderBoard.add("a", "b");
        leaderBoard.get(10);

        leaderBoard.add("a", "b");
        leaderBoard.get(10);

        leaderBoard.add("a", "b");
        leaderBoard.get(10);

        leaderBoard.add("a", "b");
        leaderBoard.get(10);

        leaderBoard.add("a", "b");
        leaderBoard.get(10);

        leaderBoard.add("a", "b");
        leaderBoard.get(10);

        leaderBoard.add("a", "b");
        leaderBoard.get(10);


        leaderBoard.get(12);
        leaderBoard.get(15);
        leaderBoard.get(18);
        leaderBoard.get(20);
    }
}
