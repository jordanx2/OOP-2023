package project;

import processing.core.PApplet;

public class LifeBoard  {
    boolean[][] board;
    boolean[][] next;
    
    private int size;
    float r;
    private int h, w;
    PApplet p;

    float cellWidth;

    public LifeBoard(int size, PApplet p, float r, int w, int h)
    {
        this.size = size;
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.p = p;
        cellWidth = p.width / (float) size;
        this.r = r;
        this.w = w;
        this.h = h;
    }

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
        int count = 0 ;
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
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                int count = countCells(row, col);
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

    public void randomise()
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                float dice = p.random(0, 1);
                board[row][col] = (dice <= 0.5f);
            }
        }
    }

    public void render()
    {
        float x;
        float y;
        float distance;
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                x = col * cellWidth;
                y = row * cellWidth;
                distance = PApplet.sqrt(PApplet.pow(x - w, 2) + PApplet.pow(y - h, 2));
                if(distance < 125){
                    if (board[row][col])
                    {
                        p.fill(0, 255, 0);
                    }
                    else
                    {
                        p.noFill();
                    }
                    p.circle(x, y, cellWidth);
                }
            }
        }
    }

    public void spawnGliderGun(){
        int x = size / 2 - 55;
        int y = size / 2 - 6;
        board[x+1][y+5] = true;
        board[x+2][y+5] = true;
        board[x+1][y+6] = true;
        board[x+2][y+6] = true;
    
        board[x+11][y+5] = true;
        board[x+11][y+6] = true;
        board[x+11][y+7] = true;
        board[x+12][y+4] = true;
        board[x+12][y+8] = true;
        board[x+13][y+3] = true;
        board[x+14][y+3] = true;
        board[x+13][y+9] = true;
        board[x+14][y+9] = true;
        board[x+15][y+6] = true;
        board[x+16][y+4] = true;
        board[x+16][y+8] = true;
        board[x+17][y+5] = true;
        board[x+17][y+6] = true;
        board[x+17][y+7] = true;
        board[x+18][y+6] = true;
    
        board[x+21][y+3] = true;
        board[x+21][y+4] = true;
        board[x+21][y+5] = true;
        board[x+22][y+3] = true;
        board[x+22][y+4] = true;
        board[x+22][y+5] = true;
        board[x+23][y+2] = true;
        board[x+23][y+6] = true;
        board[x+25][y+1] = true;
        board[x+25][y+2] = true;
        board[x+25][y+6] = true;
        board[x+25][y+7] = true;
    
        board[x+35][y+3] = true;
        board[x+35][y+4] = true;
        board[x+36][y+3] = true;
        board[x+36][y+4] = true;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    } 
    
}
