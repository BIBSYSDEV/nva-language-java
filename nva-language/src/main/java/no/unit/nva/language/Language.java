package no.unit.nva.language;

import no.unit.nva.language.tooling.JacocoGenerated;

import java.net.URI;
import java.util.List;
import java.util.Objects;

public class Language implements LanguageDescription {

    public static final String ISO_639_3 = "iso639-3";
    private static final String DOES_NOT_HAVE_ISO_639_5_CODE = null;
    private final String iso6391Code;
    private final List<String> iso6392Code;
    private final String iso6393Code;
    private final String eng;
    private final String nob;
    private final String nno;
    private final String sme;

    protected Language(String iso6391Code,
                    List<String> iso6392Code,
                    String iso6393Code, String eng,
                    String nob,
                    String nno,
                    String sme) {
        this.iso6391Code = iso6391Code;
        this.iso6392Code = iso6392Code;
        this.iso6393Code = iso6393Code;
        this.eng = eng;
        this.nob = nob;
        this.nno = nno;
        this.sme = sme;
    }

    @Override
    public String getIso6391Code() {
        return iso6391Code;
    }

    @Override
    public List<String> getIso6392Code() {
        return iso6392Code;
    }


    @Override
    public String getIso6393Code() {
        return iso6393Code;
    }

    @Override
    public String getIso6395Code() {
        return DOES_NOT_HAVE_ISO_639_5_CODE;
    }

    @Override
    public String getEng() {
        return eng;
    }

    @Override
    public String getNob() {
        return nob;
    }

    @Override
    public String getNno() {
        return nno;
    }

    @Override
    public String getSme() {
        return sme;
    }

    @Override
    public URI getLexvoUri() {
        return generateLexvoUri(iso6393Code, ISO_639_3);
    }

    @JacocoGenerated
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Language)) {
            return false;
        }
        Language language = (Language) o;
        return Objects.equals(getIso6392Code(), language.getIso6392Code())
            && Objects.equals(getIso6391Code(), language.getIso6391Code())
            && Objects.equals(getIso6393Code(), language.getIso6393Code())
            && Objects.equals(getEng(), language.getEng())
            && Objects.equals(getNob(), language.getNob())
            && Objects.equals(getNno(), language.getNno())
            && Objects.equals(getSme(), language.getSme());
    }

    @JacocoGenerated
    @Override
    public int hashCode() {
        return Objects.hash(getIso6392Code(), getIso6391Code(), getIso6393Code(),
            getEng(), getNob(), getNno(), getSme());
    }
}
