package ie.tudublin;

import org.w3c.dom.Text;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board;
    boolean[][] next;

    private int size;
    PApplet p;
    float cellWidth;

    public boolean getCell(int row, int col){
        if(row >= 0 && row < size && col >= 0 && col < size){
            return board[row][col];
        }

        return false;
    }

    public int countCells(int row, int col){
        int count = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(getCell(i + row, j + col)){
                    count++;
                }
                // if(!(i == 0) && !(j == 0)){
                //     if(getCell(i + row, j + col)){
                //         count++;
                //     }
                // }
            }
        }
        
        return count;
    }

    public void applyRules(){
        int count = 0;
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                count = countCells(row, col);
                // < 2 > 3 dies
                // 2-3 survives
                // dead with 3 neighbiurs comes to life

                // alive
                if(board[row][col]){
                    // kill the live cell by over population
                    if(count > 3){
                        board[row][col] = false;
                    }
                    if(count == 2 || count == 3){
                        next[row][col] = true;
                    } else{
                        next[row][col] = false; 
                    }
                } else{
                    if(count == 3){
                        next[row][col] = true;
                    }else{
                        next[row][col] = false;
                    }
                }
            }
        }
        boolean[][]temp = board;
        board = next;
        next = temp;

    }

    public LifeBoard(int size, PApplet p){
        this.size = size;
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.p = p;
        cellWidth = p.width / (float) size;
    }

    public void randomise(){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                float dice = p.random(0, 1);
                board[row][col] = (dice <= 0.5f);
            }   
        }
        next = board;
    }

    public void render(){
        // p.stroke(255);
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                float x = col * cellWidth;
                float y = row * cellWidth;

                if(board[row][col]){
                    p.fill(0, 255, 0);
                } else{
                    p.noFill();
                }

                p.rect(x, y, cellWidth, cellWidth);

                
                // p.fill(255);
                // p.text(countCells(row, col), x - (cellWidth / 2), y + (cellWidth / 2));
                // p.noFill();
            }

        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
