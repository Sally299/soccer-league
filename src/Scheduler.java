import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Scheduler {
    private int temp;
    private int weeksWithBadWeather = 0;
    private Team[] teams = new Team[]{new Team(1), new Team(2), new Team(3), new Team(4)};
    private List<Game> games = new ArrayList<>();
    private int numberOfGame = 1;

    public int getTemp() {
        return temp;
    }

    public void inputTemp() {
        System.out.println("Enter temperature: ");

        try{
            Scanner scanner = new Scanner(System.in);
            this.temp = scanner.nextInt();
        } catch(Exception e) {
            System.out.println("Wrong input");
        }
    }


    public boolean checkTemp(int temp) {

        if (temp < 0) {
            this.weeksWithBadWeather++;
            return false;
        } else {
            this.weeksWithBadWeather = 0;
        }

        return true;
    }

    //check season state
    public boolean seasonIsContinued() {
        return seasonIsContinued(weeksWithBadWeather);
    }

    //check season state
    public boolean seasonIsContinued(int weeksWithBadWeather) {
        return weeksWithBadWeather < 3;
    }

    public void planGames() {

        int[] indices = getRandomNumbers();

        Game game1 = new Game(teams[indices[0]], teams[indices[1]], temp, numberOfGame++);
        Game game2 = new Game(teams[indices[2]], teams[indices[3]], temp, numberOfGame++);

        game1.play();
        game2.play();

        games.add(game1);
        games.add(game2);


    }

    public int[] getRandomNumbers() {
        Random random = new Random();
        int[] indices = new int[4];
        indices[0] = 0;
        int index = 0;
        int number;
        boolean hasElement = false;

        while(index < 4) {
            number = random.nextInt(4);

            for (int i = 0; i < index; i++) {
                if(checkNumber(indices, number, i)) {
                    hasElement = true;
                    break;
                }
            }

            if (!hasElement) {
                indices[index] = number;
                index++;
            }

            hasElement = false;
        }

        return indices;
    }

    //check has number in array
    public boolean checkNumber(int[] indices, int number, int i) {
        return indices[i] == number;
    }

    //display statistics of game
    public void displayStatistics() {
        displayEndOfSeason();
        displayStatisticsOfTeams();
        displayStatisticsOfGames();
        displayStatisticsOfTemperature();
    }

    //display end of season
    public void displayEndOfSeason() {

        System.out.println("run:");
        for(int i = 0; i < 3; i++) {
            System.out.println("Too cold to play.");
        }
        System.out.println("Season is over.\n\n");

    }

    //display statistics of every team
    public void displayStatisticsOfTeams() {

        for(int i = 0; i < teams.length; i++) {
            System.out.println("Team " + teams[i].getNumberOfTeam());
            System.out.println("Wins: " + teams[i].getNumberOfWins() + ", Losses: " + teams[i].getNumberOfLosses() + ", Ties:" + teams[i].getNumberOfTies());
            System.out.println("Points Scored: " + teams[i].getPointsScored() + ", Points Allowed: " + teams[i].getPointsAllowed());
            System.out.println();
        }

    }

    //display statistics of every game
    public void displayStatisticsOfGames() {

        for (int i = 0; i < games.size(); i++) {
            System.out.println("Game #" + games.get(i).getID());
            System.out.println("Temperature: " + games.get(i).getTemp());
            System.out.println("Away Team: " + games.get(i).getNumberOfAwayTeam() + ", " + games.get(i).getPointsOfAwayTeam());
            System.out.println("Home Team: " + games.get(i).getNumberOfHomeTeam() + ", " + games.get(i).getPointsOfHomeTeam());
            System.out.println();
        }

    }

    //display max and average temperature of season
    public void displayStatisticsOfTemperature() {
        System.out.println("Hottest Temp: " + getMaxTemp());
        System.out.println("Average Temp:" + getAverageTemp());
    }


    public int getMaxTemp() {

        int maxTemp = games.get(0).getTemp();

        for(int i = 0; i < games.size(); i++) {
            if (maxTemp < games.get(i).getTemp()) {
                maxTemp = games.get(i).getTemp();
            }
        }

        return maxTemp;
    }

    public double getAverageTemp() {
        double averageTemp = 0;

        for(int i = 0; i < games.size(); i++) {
            averageTemp += games.get(i).getTemp();
        }

        averageTemp /= games.size();

        return averageTemp;
    }

}
