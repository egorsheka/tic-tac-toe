package entity;

public class Player {

    private String name;
    private int victories;

    public Player(String name) {
        this.name = name;
        victories = 0;
    }

    public String getName() {
        return name;
    }

    public int getVictories() {
        return victories;
    }

    public void win(){
        victories++;
    }

}
