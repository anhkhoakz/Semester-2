public class Club {
    private String name;
    private int wins;
    private int draws;
    private int losses;

    public Club() {
        this.name = "";
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
    }

    public Club(String name, int wins, int draws, int losses) {
        this.name = name;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    public String getName() {
        return this.name;
    }

    public int getWins() {
        return this.wins;
    }

    public int getDraws() {
        return this.draws;
    }

    public int getLosses() {
        return this.losses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int numMatchesPlayed() {
        return this.wins + this.draws + this.losses;
    }

    public boolean isFinish() {
        if (numMatchesPlayed() == 10) {
            return true;
        }
        return false;
    }

    public int getPoints() {
        return this.wins * 3 + this.draws;
    }

    public String toString() {
        return "Club " + this.name + ": "
                + this.wins + "/" + this.draws + "/" + this.losses;
    }
}