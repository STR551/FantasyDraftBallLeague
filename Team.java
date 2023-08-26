public class Team {
    int id;
    String name;

    Player[] playerList = new Player[5];

    int wins;
    int losses;
    int pointsFor;
    int pointsAgainst;

    Team(int idPass,String namePass){
        id = idPass;
        name = namePass;
    }
}
