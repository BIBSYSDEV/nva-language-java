package no.unit.nva.language;

import java.net.URI;
import java.util.List;

public interface LanguageDescription {
    String LEXVO_URI_TEMPLATE = "http://lexvo.org/id/%s/%s";
    String getEng();

    String getNob();

    String getNno();

    String getSme();

    URI getLexvoUri();
    String getIso6391Code();
    List<String> getIso6392Code();
    String getIso6393Code();
    String getIso6395Code();

    default URI generateLexvoUri(String code, String isoType) {
        return URI.create(String.format(LEXVO_URI_TEMPLATE, isoType, code));
    }
}
