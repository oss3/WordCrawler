package com.wordcrawler.infra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ozzie.smith
 * Date: 5/10/13
 * Time: 9:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Crawler {
    public static List<String> solve(Board board) {
        List<String> words = new ArrayList<String>();
        MarkBoard marked = new MarkBoard(board.getLength(),false);
        for (int i = 0; i < board.getLength(); i++)
            for(int j = 0; j < board.getLength(); j++)
                crawl(board, marked, "", i, j,words);
        Collections.sort(words);
        return words;
    }

    public static void crawl(Board board, MarkBoard marked, String word, int x, int y, List<String> words) {
        final char val = board.getValue(x,y);
        final String q_opt = val == 'q' ? "u" : "";
        final String next_word = word + val + q_opt;

        if(board.getDict().isWord(next_word)){
            if (!words.contains(next_word) && next_word.length() > 2)
                words.add(next_word);
        }

        if(board.getDict().contains(next_word)) {
            marked.mark(x,y);

            //hit all squares surrounding current square
            for(int i = -1; i <= 1; i++)
                for(int j = -1; j <= 1; j++) {
                    if (x+i >= 0 && x+i < board.getLength()
                            && y+j >= 0 && y+j < board.getLength() && !marked.isMarked(x+i, y+j)){
                            crawl(board,new MarkBoard(marked),next_word,x+i,y+j,words);
                        }
                    }
        }
    }
}
