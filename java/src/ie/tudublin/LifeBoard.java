package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board;
    boolean[][] next;
    
    private int size;
    PApplet p;

    float cellWidth;

    public boolean getCell(int row, int col)
    {
        if (row >= 0 && row < size && col >= 0 && col < size)
        {
            return board[row][col];
        }
        else
        {
            return false;
        }
    }

    public int countCells(int row, int col)
    {
        int count = 0;
        for(int i = -1 ; i <= 1 ; i ++)
        {
            for (int j = -1 ; j <= 1 ; j ++)
            {
                if (! (i == 0 && j == 0))
                {
                    if (getCell(row + i, col + j))
                    {
                        count ++;
                    }
                }
            }
        } 
        return count;
    }

    public void applyRules()
    {
        int count;
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                count = countCells(row, col);
                if (board[row][col])
                {
                    if (count == 2 || count == 3)
                    {
                        next[row][col] = true;
                    }
                    else
                    {
                        next[row][col] = false;
                    }
                    
                }
                else
                {
                    if (count == 3)
                    {
                        next[row][col] = true;
                    }
                    else
                    {
                        next[row][col] = false;
                    }
                }

                // < 2 > 3 dies
                // 2-3 survices
                // dead with 3 neighboiurs comes to life
            }
        }
        boolean[][] temp = board;
        board = next;
        next = temp;
    }

    public LifeBoard(int size, PApplet p)
    {
        this.size = size;
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.p = p;
        cellWidth = p.width / (float) size;
    }

    public void randomise()
    {
        float dice;
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                dice = p.random(0, 1);
                board[row][col] = (dice <= 0.5f);
            }
        }
    }

    public void clearBoard()
    {
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = false;
            }
        }
    }

    public void registerPattern(float mX, float mY)
    {
        float x;
        float y;
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                x = col * cellWidth;
                y = row * cellWidth;
                if(Math.abs(mX - x) < cellWidth && Math.abs(mY - y) < cellWidth){
                    if(!board[row][col]){
                        board[row][col] = true;
                        return;
                    }
                }
            }
        }
    }

    public void render()
    {
        float x;
        float y;
        for(int row = 0 ; row < size ; row ++)
        {
            p.stroke(255);
            for (int col = 0 ; col < size ; col ++)
            {
                x = col * cellWidth;
                y = row * cellWidth;

                if (board[row][col])
                {
                    p.fill(0, 255, 0);
                }
                else
                {
                    p.noFill();
                }
                p.rect(x, y, cellWidth, cellWidth);
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
