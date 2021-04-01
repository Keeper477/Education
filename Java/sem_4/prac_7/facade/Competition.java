package prac_7.facade;

public class Competition {
    private final Referee referee;
    private final Sportsman sportsman;
    private final Viewer viewer;

    public Competition() {
        this.referee = new Referee();
        this.sportsman = new Sportsman();
        this.viewer = new Viewer();
    }

    public void startCompetition() {
        referee.GetTheWhistle();
        sportsman.GetReady();
        viewer.TakeFood();
    }
}
