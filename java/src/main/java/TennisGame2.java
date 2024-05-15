
public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";

        score = equal(score);
        score = deuce(score);
        score = winsAPoint(score);
        score = advantage(score);
        score = winner(score);

        return score;
    }

    private String equal(String score) {
        if (P1point == P2point && P1point < 4) {
            score = getPointName(P1point) + "-All";
        }
        return score;
    }

    private String deuce(String score) {
        if (P1point == P2point && P1point >= 3) {
            score = "Deuce";
        }
        return score;
    }

    private String winsAPoint(String score) {
        if (P1point != P2point && P1point < 4 && P2point < 4) {
            String P1res = getPointName(P1point);
            String P2res = getPointName(P2point);

            score = P1res + "-" + P2res;
        }

        return score;
    }

    private String advantage(String score) {
        if (P1point > P2point && P2point >= 3) {
            score = "Advantage " + player1Name;
        }
        if (P2point > P1point && P1point >= 3) {
            score = "Advantage " + player2Name;
        }
        return score;
    }

    private String winner(String score) {
        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for " + player1Name;
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for " + player2Name;
        }
        return score;
    }

    private String getPointName(int point) {
        String[] names = {"Love", "Fifteen", "Thirty", "Forty"};

        return names[point];
    }

    public void wonPoint(String player) {
        if (player.equals("player1")) {
            P1point++;
        } else {
            P2point++;
        }
    }
}