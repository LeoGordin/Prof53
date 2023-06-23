package lesson22;

import java.util.Calendar;

public class Match {
    private Calendar date;
    private String team1, result, team2, stadium;
    private int watchers;

    public Match(Calendar date, String team1, String result, String team2, String stadium, int watchers) {
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.result = result;
        this.stadium = stadium;
        this.watchers = watchers;
    }

    public Calendar getDate() {
        return date;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getResult() {
        return result;
    }

    public String getStadium() {
        return stadium;
    }

    public int getWatchers() {
        return watchers;
    }

    @Override
    public String toString() {
        return "Match{" +
                "date=" + date +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", result='" + result + '\'' +
                ", stadium='" + stadium + '\'' +
                ", watchers=" + watchers +
                '}';
    }
}
