package LLD.snakeLadder.models.impl;

import LLD.snakeLadder.models.IMovable;

public class Ladder implements IMovable {
    private int beg;
    private int end;

    public Ladder(int beg, int end) {
        this.beg = beg;
        this.end = end;
    }

    @Override
    public int moveFrom() {
        return beg;
    }

    @Override
    public int moveTo() {
        return end;
    }
}
