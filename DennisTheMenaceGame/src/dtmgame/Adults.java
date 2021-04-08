/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtmgame;

public class Adults extends DTMGame{

    String name;
    String nickname;
    String level;
    int temper;

    public Adults(String theName, String theNickname, String theLevel, int theTemper) {
        name = theName;
        nickname = theNickname;
        level = theLevel;
        temper = theTemper;
    }

    public void greet() {
        System.out.println(nickname + " Hi Dennis. ");
    }

    public void stats() {
        System.out.println("the stats for this adult are: Their name is " + name + " their nickname is " + nickname + " their level is " + level + " and their temper is at " + temper);
    }

}
