public class Main {

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();

        while (scheduler.seasonIsContinued()) {
            scheduler.inputTemp();
            if (scheduler.checkTemp(scheduler.getTemp())) {
                scheduler.planGames();
            }
        }

        scheduler.displayStatistics();
    }

}
