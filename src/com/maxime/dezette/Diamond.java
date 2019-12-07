package com.maxime.dezette;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Diamond {

    List<List<String>> content;



    public Diamond(List<String> ...lines) {
        this.content = Arrays.asList(lines);
    }


    public void setContent(List<List<String>> content) {
        this.content = content;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diamond diamond = (Diamond) o;
        return content.equals(diamond.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
