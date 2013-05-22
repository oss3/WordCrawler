package com.wordcrawler.infra;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: ozzie.smith
 * Date: 4/24/13
 * Time: 5:10 PM
 */
public class Trie {

    final private char value;
    private boolean isTerm;
    private ArrayList<Trie> children;

    public Trie() {
        this.value = 1;
        this.children = new ArrayList<Trie>();
    }

    public Trie(char c) {
        this.value = c;
        this.children = new ArrayList<Trie>();
    }

    public char getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object object)
    {
        boolean isSame = false;

        if (object != null && object instanceof Trie)
            isSame = this.value == ((Trie) object).getValue();

        return isSame;
    }

    public boolean contains(String s) {
        //all Tries contain the empty string
        if (s.equals(""))
            return true;

        Trie t =  new Trie(s.charAt(0));

        if(!this.children.contains(t))
            return false;

        return this.children.get(this.children.indexOf(t)).contains(s.substring(1));
    }

    public boolean isWord(String s) {

        //all Tries contain the empty string
        if (s.equals(""))
            if (this.isTerm)
                return true;
            else
                return false;

        Trie t =  new Trie(s.charAt(0));

        if(!this.children.contains(t))
            return false;

        return this.children.get(this.children.indexOf(t)).isWord(s.substring(1));
    }

    public boolean insertWord(String s) {
        if (s.equals(""))
            return false;

        Trie t = new Trie(s.charAt(0));

        if(!this.children.contains(t)) {
            this.children.add(t);
            if (s.length() == 1 && t.addTerminal())
                return true;
            return t.insertWord(s.substring(1));
        }

        if (s.length() == 1)
            return this.children.get(this.children.indexOf(t)).addTerminal();

        return this.children.get(this.children.indexOf(t)).insertWord(s.substring(1));
    }

    public boolean addTerminal() {
        if (this.isTerm == true)
            return false;
        this.isTerm = true;
        return true;
    }

    public ArrayList<Trie> getChildren() {
        ArrayList<Trie> children = new ArrayList<Trie>();
        for(int i = 0; i < this.children.size(); i++)
            children.add(this.children.get(i));
        return children;
    }

    public void print() {
        Queue<Trie> queue = new LinkedList<Trie>();
        String out = "";
        queue.add(this);
        queue.add(new Trie('\0'));
        Trie t;
        ArrayList<Trie> t_children;
        while(!queue.isEmpty()){
            t = queue.poll();
            t_children = t.getChildren();
            for(int i = 0; i < t_children.size(); i++)
                queue.add(t_children.get(i));
            if(t.getValue() == '\0'){
                System.out.println();
                if (!queue.isEmpty())
                    queue.add(new Trie('\0'));
            }
            else
                System.out.print(t.getValue());
        }
    }

}
