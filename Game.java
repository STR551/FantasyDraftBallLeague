import java.util.Random;

public class Game {
    static Random r = new Random();
    static int gameGoesTo = 100;
    Team t1;
    Team t2;
    int t1Score = 0;
    int t2Score = 0;
    int t1OffPoss = 0;
    int t2OffPoss = 0;
    int t1counter = 0;
    int t2counter = 0;
    int ball = 1;

    public Game(Team t1Pass,Team t2Pass){
        t1 = t1Pass;
        t2 = t2Pass;
    }

    public Team playGame(){
        
        while (t1Score < gameGoesTo && t2Score < gameGoesTo){
            if (ball == 1){
                Player off = t1.playerList[t1counter%5];
                Player def = t2.playerList[t2counter%5];
                t1OffPoss++;
                runPlay(off, def, 1);
            }
            else{
                Player def = t1.playerList[t1counter%5];
                Player off = t2.playerList[t2counter%5];
                t2OffPoss++;
                runPlay(off, def, 2);
            }

            }
            //System.out.println("team "+t1.name+" "+t1Score+" vs "+"team "+t2.name+" "+t2Score);
            t1.pointsFor = t1.pointsFor + t1Score;
            t2.pointsFor = t2.pointsFor + t2Score;
            t1.pointsAgainst = t1.pointsAgainst + t2Score;
            t2.pointsAgainst = t2.pointsAgainst + t1Score;
            t1.offPoss = t1.offPoss + t1OffPoss;
            t2.offPoss = t2.offPoss + t2OffPoss;
            t1.defPoss = t1.defPoss + t2OffPoss;
            t2.defPoss = t2.defPoss + t1OffPoss;
            if (t1Score > t2Score){
                t1.wins++;
                t2.losses++;
                return t1;
            } 
            else{
                t2.wins++;
                t1.losses++;
                return t2;
            }






        }
     
        
    public void runPlay(Player off, Player def, int s){
                int offSkill = off.skills[0];
                int defSkill = def.skills[1];

                off.offPlays++;
                def.defPlays++;

                double odds  = 1-1/(1+Math.exp((offSkill-defSkill)/50.0f));
                double rand = r.nextDouble();
                if (rand < odds){
                    if (s == 1){
                        t1Score += 1;
                        t2counter += 1;

                    }
                    else{
                        t2Score+=1;
                        t1counter += 1;

                    }
                    off.offPossesions.add("scores " + def.id);
                    def.defPossesions.add("allows " + off.id);
                    off.pointsScored++;
                }
                else{
                    if (s == 1){
                        t1counter += 1;
                        ball = 2;
                    }
                    else{
                        t2counter += 1;
                        ball = 1;
                    }
                    off.offPossesions.add("misses " + def.id);
                    def.defPossesions.add("stops " + off.id);
                    def.defStops++;
                }


    }
    

    }

