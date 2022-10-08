package LLD.snakeLadder.models.impl;

public class Player {
    private String name;
    private int currPos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrPos() {
        return currPos;
    }

    public void setCurrPos(int currPos) {
        this.currPos = currPos;
    }

    public Player(String name) {
        this.name = name;
        currPos = 0;
    }
}
