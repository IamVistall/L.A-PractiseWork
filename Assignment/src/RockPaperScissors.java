public class RockPaperScissors {
    public static String Game(String player1, String player2) {
        player1 = player1.toLowerCase();
        player2 = player2.toLowerCase();

        if (player1.equals(player2)) {
            return "TIE";
        }
        if ((player1.equals("rock") && player2.equals("scissors")) || (player1.equals("paper") && player2.equals("rock")) || (player1.equals("scissors") && player2.equals("paper"))) {
            return "player1 wins";
        } else {
            return "player2 wins";
        }
    }

}