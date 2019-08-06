package edu.epam.training.task4.parser;

import edu.epam.training.task4.bean.Candy;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractCandyParser {

    protected Set<Candy> candies;

    public AbstractCandyParser() {
        this.candies = new HashSet<> ();
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    abstract public void buildSetCandies(InputStream stream);
}
