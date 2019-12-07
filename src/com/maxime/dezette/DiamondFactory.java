package com.maxime.dezette;

import java.util.ArrayList;
import java.util.List;


public class DiamondFactory {

    private static final String SPACE = " ";

    public Diamond printDiamond(Letter diamondLetter) {

        List<List<String>> diamondContent = new ArrayList<List<String>>();

        int size = (getNumberOfLines(diamondLetter));

        Diamond diamond = new Diamond();

        for(int i = 0; i < size; i++){
            diamondContent.add(makeLine(diamondLetter,Math.abs(diamondLetter.ordinal() - i)));
        }

        diamond.setContent(diamondContent);
        return diamond;

    }

    public int getNumberOfLines(Letter letter) {
        return letter.ordinal() * 2 + 1;
    }

    public List<String> getBeginning(Letter letter, int numberOfBeginingSpaces) {

        List<String> line = new ArrayList<>();

        for (int i = 0; i < numberOfBeginingSpaces; i++) {
            line.add(SPACE);
        }
        line.add(letter.name());

        return line;
    }


    public List<String> makeLine(Letter diamondLetter, int distanceFromCenter) {


        int size = (getNumberOfLines(diamondLetter));

        Letter letterToPrint = Letter.values()[diamondLetter.ordinal() - distanceFromCenter];

        List<String> beginning = this.getBeginning(letterToPrint,distanceFromCenter);
        List<String> concatLine = new ArrayList<String>(size);


        for(int i = 0; i < size; i++){
            concatLine.add(SPACE);
        }


        for(int i = 0; i < beginning.size(); i++){
               concatLine.set(i,beginning.get(i));
        }

        int i =0;
        for(int j = size -1; i < beginning.size(); j--){
                concatLine.set(j, beginning.get(i));
                i++;
        }

        return concatLine;
    }

}
