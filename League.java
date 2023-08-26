import java.util.Arrays;
import java.util.Comparator;

public class League {
    int numOfTeams = 32;
    int teamSize = 5;
    int freeAgentSize = 500;
    String bigTeamString = "NYC CHI LOA HOU PHO PHI JAX COL CHA IND SEA DEN WDC BOS NAS DET POR LSV OKC LOU BAL MIL ABQ KAN ATL OMH VGB MIN NOR WIC HON ANC";
    Team[] teamList = genTeamList();
    Player[] freeAgentList = genFreeAgentList();
    
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
            System.out.println(freeAgentList[pick]);
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



}

