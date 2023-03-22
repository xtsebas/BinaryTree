package Model;

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
}
