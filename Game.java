import java.util.Random;

public class Game {
    static Random r = new Random();

    Team t1;
    Team t2;
    int t1Score = 0;
    int t2Score = 0;
    int numPossesions = 0;

    public Game(Team t1Pass,Team t2Pass){
        t1 = t1Pass;
        t2 = t2Pass;
    }

    public void playGame(){
        int t1counter = 0;
        int t2counter = 0;
        int ball = 1;
        while (t1Score < 100 && t2Score < 100){
            if (ball == 1){
                Player off = t1.playerList[t1counter%5];
                Player def = t2.playerList[t2counter%5];
                int offSkill = off.skills[0];
                int defSkill = def.skills[1];
                double odds  = 1-1/(1+Math.exp((offSkill-defSkill)/15.0f));
                if (r.nextDouble() < odds){
                    t1Score += 1;
                    t2counter += 1;
                    
                }
                else{
                    t1counter += 1;
                    ball = 2;
                }
            }
            else{
                Player def = t1.playerList[t1counter%5];
                Player off = t2.playerList[t2counter%5];
                int offSkill = off.skills[0];
                int defSkill = def.skills[1];
                double odds  = 1-1/(1+Math.exp((offSkill-defSkill)/15.0));
                if (r.nextDouble() < odds){
                    t1Score += 1;
                    t2counter += 1;
                }
                else{
                    t1counter += 1;
                    ball = 1;
                }
            }
            }

        }
        
    }

