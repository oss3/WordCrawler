package com.wordcrawler.infra;

/**
 * Created with IntelliJ IDEA.
 * User: ozzie.smith
 * Date: 5/20/13
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class Board {
    protected char[][] grid;
    protected int length;
    private Trie dict;

    public Board() {
        this.length = 0;
        this.grid = new char[0][0];
    }

    public Board(String letters, Trie dict_) {
        double sqrt = Math.sqrt(letters.length());
        if (sqrt % 1 != 0)
            return;
        this.length = (int)sqrt;
        this.grid = new char[this.length][this.length];
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
               this.grid[i][j] = letters.charAt(i * this.length + j);
            }
        }
        this.dict = dict_;
    }

    public Trie getDict() {
        return this.dict;
    }

    public char getValue(int i, int j){
        if (i <= length && j <= length)
            return this.grid[i][j];
        return '0';
    }

    public int getLength(){
        return this.length;
    }

    @Override
    public String toString() {
        String out = " ";
        for (int i = 0; i < this.length; i++){
            out += "___ ";
        }
        out += "\n";
        for(int i = 0; i < this.length; i++){
            out+="|";
            for(int j = 0; j < this.length; j++)
                out += " "+ this.grid[i][j] + " |";
            out+="\n";
        }
        out += "";
        for (int i = 0; i < this.length; i++){
            out += " ---";
        }
        return out + "\n";
    }


}
