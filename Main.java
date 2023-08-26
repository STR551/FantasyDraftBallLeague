public class Main {
    public static void main(String[] args) {
        League l = new League();
        l.draft();
        Game g = new Game(l.teamList[0],l.teamList[20]);
        g.playGame();

        
    }

}
