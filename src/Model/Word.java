package Model;

import java.util.Objects;

public class Word {
    String spanish, english, france;

    /**
     * constructor
     * @param en
     * @param es
     * @param fr
     */
    public Word(String en, String es, String fr) {
        this.english= en;
        this.france= fr;
        this.spanish = es;
    }

    /**
     *
     * @return
     */
    public String getSpanish() {
        return spanish;
    }

    /**
     *
     * @param spanish
     */

    public void setSpanish(String spanish) {
        this.spanish = spanish;
    }

    /**
     *
     * @return
     */

    public String getEnglish() {
        return english;
    }

    /**
     *
     * @param english
     */

    public void setEnglish(String english) {
        this.english = english;
    }

    /**
     *
     * @return
     */

    public String getFrance() {
        return france;
    }

    /**
     *
     * @param france
     */
    public void setFrance(String france) {
        this.france = france;
    }

    /**
     *
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(spanish, word.spanish) && Objects.equals(english, word.english) && Objects.equals(france, word.france);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(spanish, english, france);
    }
}
