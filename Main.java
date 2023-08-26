public class Main {
    public static void main(String[] args) {
        League l = new League();
        l.draft();
        //Game g = new Game(l.teamList[0],l.teamList[1]);
        //g.playGame();
        l.playRegSeason();
        l.playPlayoffs();
        
        
        
        
        /*for (int i = 0; i < 2; i++){
            for (int p = 0; p < 5; p++){
                System.out.print(l.teamList[i].playerList[p].name+" ");
                System.out.print(l.teamList[i].playerList[p].pointsScored+" ");
                System.out.print(l.teamList[i].playerList[p].offPlays+" ");
                System.out.print(l.teamList[i].playerList[p].defStops+" ");
                System.out.print(l.teamList[i].playerList[p].defPlays+" ");
                System.out.print(l.teamList[i].playerList[p].skills[0]+" ");
                System.out.print(l.teamList[i].playerList[p].skills[1]+"\n");
                                

            }
            
        }*/
        
    }

}
