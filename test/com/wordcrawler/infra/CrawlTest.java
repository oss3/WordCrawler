package com.wordcrawler.infra;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ozzie.smith
 * Date: 5/22/13
 * Time: 9:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class CrawlTest {
    @Test
    public void testCrawl() {
        BufferedReader br = null;
        Trie dict = new Trie();
        try {
            br = new BufferedReader(new FileReader("dictionary.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                dict.insertWord(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Board board = new Board("spitqackoptoreik", dict);
        System.out.print(board.toString());
        List<String> words = Crawler.solve(board);
        for(int i = 0; i < words.size(); i++)
            System.out.println(words.get(i));
    }
}
