package lesson22;

import java.util.Calendar;

// 2022, 9, 10, TSG 1899 Hoffenheim, 4:01, 1. FSV Mainz 05, 20114, PreZero Arena
public class Match {
    private Calendar date;
    private String team1, result, team2, stadium;
    private int watchers;

    public Match(Calendar date, String team1, String result, String team2, String stadium, int watchers) {
        this.date = date;
        this.team1 = team1;
        this.result = result;
        this.team2 = team2;
        this.stadium = stadium;
        this.watchers = watchers;
    }

    public Calendar getDate() {
        return date;
    }

    public String getTeam1() {
        return team1;
    }

    public String getResult() {
        return result;
    }

    public String getTeam2() {
        return team2;
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
                ", result='" + result + '\'' +
                ", team2='" + team2 + '\'' +
                ", stadium='" + stadium + '\'' +
                ", watchers=" + watchers +
                '}';
    }
}
