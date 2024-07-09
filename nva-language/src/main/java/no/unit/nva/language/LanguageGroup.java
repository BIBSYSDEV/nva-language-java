package no.unit.nva.language;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import no.unit.nva.language.tooling.JacocoGenerated;

public class LanguageGroup implements LanguageDescription {

    public static final String ISO_639_5 = "iso639-5";
    private static final String DOES_NOT_HAVE_ISO_639_1 = null;
    private static final List<String> DOES_NOT_HAVE_ISO_639_2 = Collections.emptyList();
    private static final String DOES_NOT_HAVE_ISO_639_3 = null;
    private final String eng;
    private final String nob;
    private final String nno;
    private final String sme;
    private final String iso6395Code;

    public LanguageGroup(String eng, String nob, String nno, String sme, String iso6395Code) {
        this.eng = eng;
        this.nob = nob;
        this.nno = nno;
        this.sme = sme;
        this.iso6395Code = iso6395Code;
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
        return generateLexvoUri(iso6395Code, ISO_639_5);
    }

    @Override
    public String getIso6391Code() {
        return DOES_NOT_HAVE_ISO_639_1;
    }

    @Override
    public List<String> getIso6392Code() {
        return DOES_NOT_HAVE_ISO_639_2;
    }

    @Override
    public String getIso6393Code() {
        return DOES_NOT_HAVE_ISO_639_3;
    }

    @Override
    public String getIso6395Code() {
        return iso6395Code;
    }

    @JacocoGenerated
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LanguageGroup that)) {
            return false;
        }
        return Objects.equals(eng, that.eng)
               && Objects.equals(nob, that.nob)
               && Objects.equals(nno, that.nno)
               && Objects.equals(sme, that.sme)
               && Objects.equals(iso6395Code, that.iso6395Code);
    }

    @JacocoGenerated
    @Override
    public int hashCode() {
        return Objects.hash(eng, nob, nno, sme, iso6395Code);
    }
}
