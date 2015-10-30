package Battleship;

import gameFramework.infoMsg.GameState;

/**
 * Created by camachon18 on 10/30/2015.
 */
public class BattleshipGameState extends GameState {



    private int player1Hits;
    private int player2Hits;
    private int playerID;
    private boolean isHit = false;
    private int[] shipsLife = new int[5];
    private int[] shipID = {1,2,3,4,5};
    private boolean[][] userGrid;

    public BattleshipGameState(){

        player1Hits = 0;
        player2Hits = 0;
        playerID = 0;

        shipsLife[0] = 5;//carrier ship
        shipsLife[1] = 4;//battleship
        shipsLife[2] = 3;//destroyer ship
        shipsLife[3] = 3;//submarine ship
        shipsLife[4] = 2;//patrol boat

        userGrid = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                userGrid[i][j] = false;
            }
        }
    }

    public BattleshipGameState(BattleshipGameState object){

        this.player1Hits = object.player1Hits;
        this.player2Hits = object.player2Hits;
        this.playerID = object.playerID;
        this.shipsLife[0] = object.shipsLife[0];
        this.shipsLife[1] = object.shipsLife[1];
        this.shipsLife[2] = object.shipsLife[2];
        this.shipsLife[3] = object.shipsLife[3];
        this.shipsLife[4] = object.shipsLife[4];

        userGrid = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                userGrid[i][j] = object.userGrid[i][j];
            }
        }

    }

    public int getPtBoatLife() {
        return shipsLife[4];
    }

    public void setPtBoatLife(int ptBoatLife) {
        this.shipsLife[4] = ptBoatLife;
    }

    public int getSubmarineLife() {
        return shipsLife[3];
    }

    public void setSubmarineLife(int submarineLife) {
        this.shipsLife[3] = submarineLife;
    }

    public int getDestroyerLife() {
        return shipsLife[2];
    }

    public void setDestroyerLife(int destroyerLife) {
        this.shipsLife[2] = destroyerLife;
    }

    public int getBattleshipLife() {
        return shipsLife[1];
    }

    public void setBattleshipLife(int battleshipLife) {
        this.shipsLife[1] = battleshipLife;
    }

    public int getCarrierLife() {
        return shipsLife[0];
    }

    public void setCarrierLife(int carrierLife) {
        this.shipsLife[0] = carrierLife;
    }

    public boolean getIsHit() {
        return isHit;
    }
    public void setIsHit(boolean isHit) {
        this.isHit = isHit;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getPlayer2Hits() {
        return player2Hits;
    }

    public void setPlayer2Hits(int player2Hits) {
        this.player2Hits = player2Hits;
    }

    public int getPlayer1Hits() {
        return player1Hits;
    }

    public void setPlayer1Hits(int player1Hits) {
        this.player1Hits = player1Hits;
    }

    public void shipHit(int row, int col, int ID) {
        if (this.playerID == 0) {
            player1Hits = player1Hits + 1;
            this.playerID = 1;
            userGrid[row][col] = true;
            for (int i = 0; i < shipID.length; i++) {
                if (ID == shipID[i]) {
                    shipsLife[i] = shipsLife[i] - 1;
                }
            }

        }
        else {
            player2Hits = player2Hits + 1;
            this.playerID = 0;
            userGrid[row][col] = true;
            for (int i = 0; i < shipID.length; i++) {
                if (ID == shipID[i]) {
                    shipsLife[i] = shipsLife[i] - 1;
                    //TODO: Make a separate array for computer's ships/paint square red

                }
            }
        }
    }
    public void shipMissed() {
        //TODO: paint square white if miss
    }
}
