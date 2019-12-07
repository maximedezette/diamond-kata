package com.maxime.dezette;

import org.junit.Before;
import org.junit.Test;


import static com.maxime.dezette.Letter.*;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiamondFactoryTest {

    DiamondFactory diamondFactory;

    @Before
    public void setUp() {
        diamondFactory = new DiamondFactory();
    }

    @Test
    public void shouldReturnAWithParameter() {
        var diamondA = new Diamond(asList("A"));
        assertEquals(diamondA, diamondFactory.printDiamond(A));
    }

    @Test
    public void shouldReturnForB() {
        var diamondB = new Diamond(
                asList(" ", "A", " "),
                asList("B", " ", "B"),
                asList(" ", "A", " "));
        assertEquals(diamondB, diamondFactory.printDiamond(B));
    }

    @Test
    public void shouldReturnForC() {
        var diamondC = new Diamond(
                asList(" ", " ", "A", " ", " "),
                asList(" ", "B", " ", "B", " "),
                asList("C", " ", " ", " ", "C"),
                asList(" ", "B", " ", "B", " "),
                asList(" ", " ", "A", " ", " "));
        assertEquals(diamondC, diamondFactory.printDiamond(C));
    }

    @Test
    public void shouldReturn1Line() {
        assertEquals(1, diamondFactory.getNumberOfLines(A));
        assertEquals(3, diamondFactory.getNumberOfLines(B));
        assertEquals(5, diamondFactory.getNumberOfLines(C));
        assertEquals(7, diamondFactory.getNumberOfLines(D));
    }

    @Test
    public void shouldFillTheBeginingOfLine() {
        assertEquals(asList("A"), diamondFactory.getBeginning(A, 0));
        assertEquals(asList(" ", "A"), diamondFactory.getBeginning(A, 1));
        assertEquals(asList(" ", " ", "A"), diamondFactory.getBeginning(A, 2));
    }

    @Test
    public void shouldFillTheUpperSideOfDiamondC(){
        assertEquals(asList(" ","A"," "),diamondFactory.makeLine(B,1));
        assertEquals(asList(" ","B"," ","B"," "),diamondFactory.makeLine(C,1));
        assertEquals(asList("A"),diamondFactory.makeLine(A,0));
        assertEquals(asList(" "," ","A"," "," "),diamondFactory.makeLine(C,2));
        assertEquals(asList("B"," ","B"),diamondFactory.makeLine(B,0));
    }

}
