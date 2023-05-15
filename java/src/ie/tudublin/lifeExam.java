package ie.tudublin;

import processing.core.PApplet;

public class lifeExam {
    private float cellWidth;
    private int size;
    private PApplet p;
    private boolean[][] board;

    public lifeExam(int size, PApplet p){
        this.cellWidth = p.width / size;
        this.size = size;
        this.p = p;
        board = new boolean[size][size];

    }

    public boolean getCell(int row, int col){
        if(row < size || row < 0 || col > size || col < 0){
            return board[row][col];
        }
        return false;
    }

    public int countAlive(int col, int row){
        int count = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(!(i == 0 && j == 0)){
                    if(getCell(row + 1, col + 1)){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public void draw(){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                float x = row * cellWidth;
                float y = col * cellWidth;
                if(board[row][col]){
                    p.fill(0, 255, 0);
                } else{
                    p.noFill();
                }
                p.rect(x, y, cellWidth, cellWidth);
            }
        }
    }



}
        