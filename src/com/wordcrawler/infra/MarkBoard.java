package com.wordcrawler.infra;

/**
 * Created with IntelliJ IDEA.
 * User: ozzie.smith
 * Date: 5/21/13
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class MarkBoard extends Board {

    public MarkBoard(int size, boolean mark) {
        this.grid = new char[size][size];
        this.length = size;
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                this.grid[i][j] = mark ? '1' : '0';
            }
        }
    }

    public MarkBoard(MarkBoard marked) {
        this.length = marked.getLength();
        this.grid = new char[this.length][this.getLength()];
        for(int i = 0; i < this.length; i++)
            for(int j = 0; j < this.length; j++)
                this.grid[i][j] = marked.getValue(i,j);
    }

    public void mark(int x, int y) {
        if (x >= 0 && x < this.length && y >= 0 && y < this.length)
            this.grid[x][y] = '1';
    }

    public boolean isMarked(int x, int y) {
        return this.grid[x][y] == '1';
    }

}
