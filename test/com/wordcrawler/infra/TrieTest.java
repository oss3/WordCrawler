package com.wordcrawler.infra;
import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ozzie.smith
 * Date: 5/9/13
 * Time: 11:23 AM
 */
public class TrieTest {

    @Test
    public void testCreateBasicTrie() {
        Trie t = new Trie();
        t.insertWord("bucket");
        assertFalse(t.isWord("buck"));
        assertTrue(t.contains("buck"));
        t.insertWord("buck");
        assertTrue(t.isWord("buck"));
        t.insertWord("truancy");
        t.insertWord("template");
        t.print();
    }

    @Test
    public void testLoadDictionary() {
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
        assertTrue(dict.isWord("hello"));
        dict.print();

    }

}
