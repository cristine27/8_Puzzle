/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EigthPuzzle;

import java.util.Arrays;

/**
 *
 * @author
 * Cristine Artanty ( 2017730050 )
 * Melody Victoria Angel ( 2017730060 ) 
 */

public class Puzzle {
    protected enum Direction{
        UP, DOWN, LEFT,RIGHT 
    }
    
    private final int [][] puzzle;
    protected int [][] goalTest;
    private String path;
    
    private int zeroX,zeroY;
    
    public Puzzle(int [][] puzzle,int [][] goalTest){
        this.puzzle = puzzle;
        this.goalTest = goalTest;
        path = "";
        
        findZeroTile();
    }
    
    public Puzzle(Puzzle newPuzzle){
        puzzle = new int[newPuzzle.puzzle.length][newPuzzle.puzzle[0].length];
        
//      copy specific row i of arrays puzzle
        for(int i=0; i<puzzle.length; i++){
            puzzle[i] = Arrays.copyOf(newPuzzle.puzzle[i], puzzle[i].length);
        }
        
        goalTest = newPuzzle.goalTest;
        
        zeroX = newPuzzle.zeroX;
        zeroY = newPuzzle.zeroY;
        
        path = newPuzzle.path;
    }
    
    public boolean isSolved(){
        for(int i=0; i<puzzle.length; i++){
            for(int j=0; j<puzzle[0].length; j++){
                if(puzzle[i][j]!=this.goalTest[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void findZeroTile(){
        for(int i=0; i<puzzle.length; i++){
            for(int j=0; j<puzzle[0].length; j++){
                if(puzzle[i][j]==0){
                    zeroX = j;
                    zeroY = i;
                }
            }
        }
    }
    
    public boolean canMove(Direction direction){
        switch(direction){
            case UP:
                if(zeroY!=0){
                    return true;
                }
                break;
            case DOWN:
                if(zeroY!=puzzle.length-1){
                    return true;
                }
                break;
            case LEFT:
                if(zeroX!=0){
                    return true;
                }
                break;
            case RIGHT:
                if(zeroX!=puzzle[0].length-1){
                    return true;
                }
                break;
        }
        return false;
    }
    
    public void move(Direction direction){
        switch(direction){
            case UP:
                swap(zeroY, zeroX,(zeroY-1),zeroX);
                path += "U";
                
                break;
            case DOWN:
                swap(zeroY, zeroX,(zeroY+1),zeroX);
                path += "D";
                
                break;
            case LEFT:
                swap(zeroY, zeroX,zeroY,(zeroX-1));
                path += "L";
                
                break;
            case RIGHT:
                swap(zeroY, zeroX,zeroY,(zeroX+1));
                path += "R";
                
                break;
        }
    }
    
    public void print(int [][] Puzzle){
        System.out.println("Puzzle : ");
        System.out.println("");
        for(int i=0; i<puzzle.length; i++){
            for(int j=0; j<puzzle[0].length; j++){
                System.out.println(puzzle);
            }
            System.out.println("");
        }
    }
    
    private void swap(int y1, int x1, int y2, int x2) {
        int previous = getTile(y1, x1);

        setTile(y1, x1, getTile(y2, x2));
        setTile(y2, x2, previous);
        
//        print(this.getPuzzle());
        
        zeroY = y2;
        zeroX = x2;
    }
    
    private void setTile(int y, int x, int tile) {
        puzzle[y][x] = tile;
    }

    private int getTile(int y, int x) {
        return puzzle[y][x];
    }
    
    public String getPath() {
        return path;
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int y = 0; y < puzzle.length; ++y) {
            for (int x = 0; x < puzzle[y].length; ++x) {
                output.append(puzzle[y][x]).append(" ");
            }

            output.append(System.lineSeparator());
        }

        return output.toString();
    }
}
