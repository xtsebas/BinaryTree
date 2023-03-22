package Model;

import java.util.Objects;

public class Word {
    String spanish, english, france;

    public Word(String en, String es, String fr) {
        this.english= en;
        this.france= fr;
        this.spanish = es;
    }

    public String getSpanish() {
        return spanish;
    }

    public void setSpanish(String spanish) {
        this.spanish = spanish;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getFrance() {
        return france;
    }

    public void setFrance(String france) {
        this.france = france;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(spanish, word.spanish) && Objects.equals(english, word.english) && Objects.equals(france, word.france);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spanish, english, france);
    }
}
