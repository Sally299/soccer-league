import java.util.Random;

public class Game {
    private int ID;
    private int temp;
    private Team awayTeam;
    private Team homeTeam;
    private int numberOfAwayTeam;
    private int numberOfHomeTeam;
    private int pointsOfAwayTeam;
    private int pointsOfHomeTeam;


    Game(Team awayTeam, Team homeTeam, int temp, int ID) {
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.temp = temp;
        this.ID = ID;
    }


    public int getNumberOfAwayTeam() {
        return numberOfAwayTeam;
    }

    public void setNumberOfAwayTeam(int numberOfAwayTeam) {
        this.numberOfAwayTeam = numberOfAwayTeam;
    }

    public int getNumberOfHomeTeam() {
        return numberOfHomeTeam;
    }

    public void setNumberOfHomeTeam(int numberOfHomeTeam) {
        this.numberOfHomeTeam = numberOfHomeTeam;
    }

    public int getPointsOfAwayTeam() {
        return pointsOfAwayTeam;
    }

    public int getPointsOfHomeTeam() {
        return pointsOfHomeTeam;
    }

    public int getTemp() {
        return temp;
    }

    public int getID() {
        return ID;
    }

    public void play() {
        setNumbersOfTeams();
        setPoints();
        setStatistics();
    }

    public void setNumbersOfTeams() {
        setNumberOfAwayTeam(awayTeam.getNumberOfTeam());
        setNumberOfHomeTeam(homeTeam.getNumberOfTeam());
    }

    public void setPoints() {
        pointsOfAwayTeam = getPoints();
        pointsOfHomeTeam = getPoints();
    }

    public int getPoints() {
        Random random = new Random();

        if (temp > 35) {
            return random.nextInt(10 - 5 + 1);
        } else {
            return random.nextInt(5);
        }
    }

    public void setStatistics() {
        if (pointsOfAwayTeam > pointsOfHomeTeam) {
            awayTeam.setNumberOfWins(awayTeam.getNumberOfWins() + 1);
            homeTeam.setNumberOfLosses(homeTeam.getNumberOfLosses() + 1);
        } else if (pointsOfAwayTeam < pointsOfHomeTeam){
            homeTeam.setNumberOfWins(homeTeam.getNumberOfWins() + 1);
            awayTeam.setNumberOfLosses(awayTeam.getNumberOfLosses() + 1);
        } else {
            awayTeam.setNumberOfTies(awayTeam.getNumberOfTies() + 1);
            homeTeam.setNumberOfTies(homeTeam.getNumberOfTies() + 1);
        }

        Random random = new Random();
        int number = random.nextInt(2);

        homeTeam.setPointsScored(getPointsOfHomeTeam());
        awayTeam.setPointsScored(getPointsOfAwayTeam());
        homeTeam.setPointsAllowed(getPointsOfHomeTeam() + number);
        awayTeam.setPointsAllowed(getPointsOfAwayTeam() + number);
    }

}
