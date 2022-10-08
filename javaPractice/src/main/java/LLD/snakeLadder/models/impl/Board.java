package LLD.snakeLadder.models.impl;

import LLD.snakeLadder.models.IMovable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {
    final int N = 100;
     List<IMovable> movables;
     List<Set<Integer>> moveToVal;

    public void Board() {
        movables = new ArrayList<>();
        moveToVal = new ArrayList<>();
        for(int i=0 ; i<N ;i++) {
            moveToVal.add(new HashSet<>());
        }
    }

    public void addMovables(IMovable movable) {
        movables.add(movable);
    }

    public void setUpBoard() {
         for(int i=0; i<movables.size(); i++) {
             moveToVal.get(movables.get(i).moveFrom()).add(movables.get(i).moveTo());
         }
         for(int i=0; i<100; i++) {
             if(moveToVal.get(i).isEmpty()) {
                 moveToVal.get(i).addAll(getSetFor(i));
             }
         }
    }

    private Set<Integer> getSetFor(int i) {
        Set<Integer> numSet = new HashSet<>();
        for(int j=1; j<=6; j++) {
            numSet.add(i+j);
        }
        return numSet;
    }

    private boolean isUnderBound(int target) {
        return target<=N && target>=0;
    }

    public boolean isValidMove(int curr, int target) {
        return isUnderBound(target) && moveToVal.get(curr).contains(target);
    }



}
