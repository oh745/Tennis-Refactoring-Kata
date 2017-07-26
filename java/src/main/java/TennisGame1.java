
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public boolean isDeuce(int m_score1 , int m_score2){
        if(m_score1 == m_score2){
            return true;
        }
        else return false;
    }

    public String getScoreWhenDeuce(int score){
        switch (score)
        {
            case 0:
                return  "Love-All";
            case 1:
                return  "Fifteen-All";
            case 2:
                return  "Thirty-All";
            default:
                return  "Deuce";

        }
    }

    public String getNormalScore(int score){
        switch(score)
        {
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default: return "Love";
        }

    }

    public boolean isAdvantageOrWinner(){
        if(m_score1>=4 || m_score2>=4){
            return true;
        }
        return false;
    }

    public String getScoreWhenAdvantageOrWinner(){
        int minusResult = m_score1 - m_score2;
        if (minusResult==1) return "Advantage " + player1Name;
        else if (minusResult ==-1) return "Advantage " + player2Name;
        else if (minusResult>=2) return "Win for " + player1Name;
        else return "Win for " + player2Name;
    }

    public String getScore() {
        if (isDeuce(m_score1,m_score2))
        {
           return getScoreWhenDeuce(m_score1);
        }
        else if (isAdvantageOrWinner())
        {
           return getScoreWhenAdvantageOrWinner();
        }
        else
        {
            return getNormalScore(m_score1) + "-" + getNormalScore(m_score2);
        }
    }
}
