public class Team {
    int id;
    String name;

    Player[] playerList = new Player[5];

    int wins;
    int losses;
    int pointsFor;
    int pointsAgainst;
    int offPoss;
    int defPoss;

    int rank;

    Team(int idPass,String namePass){
        id = idPass;
        name = namePass;
    }

    public String toString() {
        return rank + " " + name + " " + (int) wins+" "+String.format("%.2f",(float) pointsFor / (float) offPoss * 100) + " " + String.format("%.2f",(float) pointsAgainst / (float) defPoss * 100);
      }
}
