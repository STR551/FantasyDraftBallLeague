import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class League {
    Random r = new Random();
    int numOfTeams = 32;
    int teamSize = 5;
    int freeAgentSize = 500;
    //int winsInSeries = 4;
    String bigTeamString = "NYC CHI LOA HOU PHO PHI JAX COL CHA IND SEA DEN WDC BOS NAS DET POR LSV OKC LOU BAL MIL ABQ KAN ATL OMH VGB MIN NOR WIC HON ANC";
    Team[] teamList = genTeamList();
    Player[] freeAgentList = genFreeAgentList();
    String[] gameList = getGameList();
    Player[] leaguePlayerList = new Player[numOfTeams*teamSize];
    
public Team[] genTeamList() {
        Team[] teamList = new Team[numOfTeams];
        String[] splitList = bigTeamString.split(" ");
        for (int i = 0; i < numOfTeams; i++){
            Team t = new Team(i,splitList[i]);
            teamList[i] = t;
        }
        return teamList;
    }
    
public Player[] genFreeAgentList(){
    Player[] retList = new Player[freeAgentSize];
    for (int i = 0; i < freeAgentSize; i++){
        retList[i] = new Player();
    }
    return retList;
}

public void draft(){
    sortMethod();
    for (int r = 0; r < teamSize; r++){
        for (int t = 0; t < numOfTeams; t++){
            int pick = r*numOfTeams+t;
            teamList[t].playerList[r] = freeAgentList[pick];
            leaguePlayerList[pick] = freeAgentList[pick];
            //System.out.println(freeAgentList[pick]);
        }

    }

}

public void sortMethod(){
    Arrays.sort(freeAgentList, new Comparator<Player>() {
        @Override
        public int compare(Player player1, Player player2) {
            return Integer.compare(player2.skills[0]+player2.skills[1], player1.skills[0]+player1.skills[1]);
        }
    
        });
    }

public void sortMethodTeam(){
    Arrays.sort(teamList, new Comparator<Team>() {
        @Override
        public int compare(Team t1, Team t2) {
            return Integer.compare(t2.wins, t1.wins);
        }
    
        });
    }

public void sortMethodTeamRank(Team[] advancingTeams){
    Arrays.sort(advancingTeams, new Comparator<Team>() {
        @Override
        public int compare(Team t1, Team t2) {
            return Integer.compare(t1.rank, t2.rank);
        }
    
        });
    }

public String[] getGameList(){
    int count = 0;
    String[] retString = new String[numOfTeams * (numOfTeams-1)/2 ];
    for (int t1 = 0; t1 < numOfTeams; t1++){
        for (int t2 = t1+1; t2 < numOfTeams; t2++){
            retString[count] = t1 + " " + t2;
            count++;
        }
    }
    return retString;
}


public void playRegSeason(){
    shuffleArray(gameList);
    for (int i = 0; i < gameList.length; i++){
        //System.out.println(gameList[i]);
        String[] splitList = gameList[i].split(" ");
        shuffleArray(splitList);
        Game g = new Game(teamList[Integer.parseInt(splitList[0])],teamList[Integer.parseInt(splitList[1])]);
        g.playGame();
    }
    sortMethodTeam();
    for (int i = 0;  i < numOfTeams; i++){
        teamList[i].rank = i+1;
        System.out.println(teamList[i]);

    }
    for (int i = 0; i < numOfTeams*teamSize; i++){
        System.out.println(leaguePlayerList[i].toString());
    }


    
}

public void playPlayoffs(){

    playRound(Arrays.copyOfRange(teamList, 0, teamList.length),3);
    /*sortMethodTeam();
    for (int i = 0;  i < numOfTeams; i++){
        teamList[i].rank = i+1;
        System.out.println(teamList[i]);

    }
    */
}

public void playRound(Team[] tl, int seriesLen){
    if (tl.length == 1){
        System.out.println(tl[0].name+" wins it all!!");
        return;
    }
    Team[] advancingTeams = new Team[tl.length/2];
    System.out.println();
    for (int i = 0; i < tl.length/2; i++){
        Team[] teamsPlaying = new Team[] {tl[i],tl[tl.length-1-i]};
        Team t1 = teamsPlaying[0];
        Team t2 = teamsPlaying[1];
        int t1wins = 0;
        int t2wins = 0;
        while (t1wins < seriesLen && t2wins < seriesLen){
            if ((t1wins+t2wins)%2==0){
                Game g = new Game(t1,t2);
                Team winner = g.playGame();
                if (winner == t1){
                    t1wins++;
                }
                else{
                    t2wins++;
                }
            }
            else{
                Game g = new Game(t2,t1);
                Team winner = g.playGame();
                if (winner == t1){
                    t1wins++;
                }
                else{
                    t2wins++;
                }
            }

        }
        System.out.println(t1.name+" "+t1.rank+" "+t2.name+" "+t2.rank+" "+t1wins+" "+t2wins);
        if (t1wins == seriesLen){
            advancingTeams[i] = t1;
        }
        else{
            advancingTeams[i] = t2;
        }

    }
        sortMethodTeamRank(advancingTeams);
        playRound(advancingTeams,seriesLen);

}


public void shuffleArray(String[] array) {
    Random rand = new Random();
    for (int i = array.length - 1; i > 0; i--) {
        int j = rand.nextInt(i + 1);
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

}

