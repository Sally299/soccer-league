public class Team {
    private int numberOfTeam;
    private int numberOfWins;
    private int numberOfLosses;
    private int numberOfTies;
    private int pointsScored = 0;
    private int pointsAllowed = 0;

    Team(int numberOfTeam) {
        this.numberOfTeam = numberOfTeam;
    }

    public int getNumberOfTeam() {
        return numberOfTeam;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public void setNumberOfLosses(int numberOfLosses) {
        this.numberOfLosses = numberOfLosses;
    }

    public int getNumberOfTies() {
        return numberOfTies;
    }

    public void setNumberOfTies(int numberOfTies) {
        this.numberOfTies = numberOfTies;
    }

    public int getPointsScored() {
        return pointsScored;
    }

    public void setPointsScored(int pointsScored) {
        this.pointsScored += pointsScored;
    }

    public int getPointsAllowed() {
        return pointsAllowed;
    }

    public void setPointsAllowed(int pointsAllowed) {
        this.pointsAllowed = pointsAllowed;
    }
}
