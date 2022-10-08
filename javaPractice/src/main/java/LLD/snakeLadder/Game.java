package LLD.snakeLadder;

// not complex and extendable one - small done with time constraint
//https://workat.tech/machine-coding/practice/snake-and-ladder-problem-zgtac9lxwntg/

import LLD.snakeLadder.models.impl.Board;
import LLD.snakeLadder.models.impl.Ladder;
import LLD.snakeLadder.models.impl.Player;
import LLD.snakeLadder.models.impl.Snake;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public int snakeCount, ladderCount, playerCount, movBeg, movEnd;
    public String name;
    public Board board;
    public List<Player> players;
    public boolean isGameOver;

    public void Game() {
        players = new ArrayList<>();
        isGameOver = false;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Game game = new Game();

        game.snakeCount = in.nextInt();
        for(int i=0; i<game.snakeCount; i++) {
            int beg = in.nextInt();
            int end = in.nextInt();
            Snake snake = new Snake(beg, end);
            game.board.addMovables(snake);
        }

        game.ladderCount = in.nextInt();
        for(int i=0; i<game.ladderCount; i++) {
            int beg = in.nextInt();
            int end = in.nextInt();
            Ladder ladder = new Ladder(beg, end);
            game.board.addMovables(ladder);
        }

        game.playerCount = in.nextInt();
        for(int i=0; i<game.playerCount; i++) {
            String name = in.next();
            game.players.add(new Player(name));
        }

        Random random = new Random();
        while(!game.isGameOver) {
            for(int i=0; i<game.playerCount && !game.isGameOver; i++) {
                int nextMove = random.nextInt(6) + 1;

            }
        }

    }
}
