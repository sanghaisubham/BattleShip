import kotlin.Pair;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BattleShipDriver {

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int gridSize = Integer.parseInt(sc.nextLine());
        int shipSize = Integer.parseInt(sc.nextLine());

        String battleShip1= sc.nextLine();
        BattleShipUtility battleShipUtility = new BattleShipUtility();
        List<GridCell> battleShips1 = battleShipUtility.parseInputPositions(battleShip1);
        PlayerBattleShips player1Ships= new PlayerBattleShips(shipSize,battleShips1);
        //player1Ships.getBattleGround();

        String battleShip2= sc.nextLine();
        List<GridCell> battleShips2 = battleShipUtility.parseInputPositions(battleShip2);
        PlayerBattleShips player2Ships= new PlayerBattleShips(shipSize,battleShips2);
        //player2Ships.getBattleGround();

        int missileSize = Integer.parseInt(sc.nextLine());

        String player1Missile= sc.nextLine();
        List<GridCell> missiles1 = battleShipUtility.parseInputPositions(player1Missile);
        PlayerMissiles player1Missiles= new PlayerMissiles(missileSize,missiles1);

        String player2Missile= sc.nextLine();
        List<GridCell> missiles2 = battleShipUtility.parseInputPositions(player2Missile);
        PlayerMissiles player2Missiles= new PlayerMissiles(missileSize,missiles2);

        PlayerBattleGround player1BattleGround = new PlayerBattleGround(gridSize);
        PlayerBattleGround player2BattleGround = new PlayerBattleGround(gridSize);

        player1BattleGround.addActiveBattleShips(battleShips1);
        System.out.println("");
        player2BattleGround.addActiveBattleShips(battleShips2);


        Pair<Set<GridCell>,Set<GridCell>> player1 = battleShipUtility.getBattleResult(player1Ships,player2Missiles);


        player1BattleGround.addDeadBattleShips(player1.getFirst());
        player1BattleGround.addMissedMissiles(player1.getSecond());
        System.out.println("Player 1 BattleGround");
        player1BattleGround.getBattleGround();

        Pair<Set<GridCell>,Set<GridCell>> player2 = battleShipUtility.getBattleResult(player2Ships,player1Missiles);
        player2BattleGround.addDeadBattleShips(player2.getFirst());
        player2BattleGround.addMissedMissiles(player2.getSecond());
        System.out.println("Player 2 BattleGround");
        player2BattleGround.getBattleGround();

        int player1Score=player2BattleGround.getDeadShipCount();
        int player2Score=player1BattleGround.getDeadShipCount();

        System.out.println("Player1 Score: "+player1Score);
        System.out.println("Player2 Score: "+player2Score);

        if(player1Score>player2Score){
            System.out.println("Player 1 wins");
        }
        else if(player1Score<player2Score){
            System.out.println("Player 2 wins");
        }else{
            System.out.println("It is a draw");
        }
    }
}
