package com.wordcrawler.infra;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ozzie.smith
 * Date: 5/20/13
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class BoardTest {

    @Test
    public void testCreateSimpleMarkBoard() {
        MarkBoard markBoard = new MarkBoard(3, true);
        System.out.print(markBoard.toString());
    }

    @Test
    public void testCreateSimpleBoard() {
        Board board = new Board("canhambat", new Trie());
        System.out.print(board.toString());
    }



}
