package no.unit.nva.language;

import no.unit.nva.language.tooling.JacocoGenerated;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;
import static no.unit.nva.language.LanguageConstants.ALL_LANGUAGES;
import static no.unit.nva.language.LanguageConstants.BOKMAAL;
import static no.unit.nva.language.LanguageConstants.NORWEGIAN;
import static no.unit.nva.language.LanguageConstants.UNDEFINED_LANGUAGE;

public final class LanguageMapper {
    private static final List<Language> languages = ALL_LANGUAGES;
    public static final String EMPTY_STRING = "";

    @JacocoGenerated
    private LanguageMapper() {
    }

    public static Language getLanguageByIso6391Code(String code) {
        return mappedValue(languages.stream().filter(language -> convertString(code)
                .equalsIgnoreCase(language.getIso6391Code())));
    }

    public static Language getLanguageByIso6392Code(String code) {
        return mappedValue(languages.stream().filter(language -> language.getIso6392Code().stream()
                .anyMatch(lang -> convertString(code).equalsIgnoreCase(lang))));
    }

    public static Language getLanguageByIso6393Code(String code) {
        return mappedValue(languages.stream().filter(language -> convertString(code)
                .equalsIgnoreCase(language.getIso6393Code())));
    }

    public static Language getLanguageByEnglishName(String name) {
        return mappedValue(languages.stream().filter(language -> convertString(name)
                .equalsIgnoreCase(language.getEng())));
    }

    public static Language getLanguageByBokmaalName(String name) {
        return mappedValue(languages.stream().filter(language -> convertString(name)
                .equalsIgnoreCase(language.getNob())));
    }

    public static Language getLanguageByNynorskName(String name) {
        return mappedValue(languages.stream().filter(language -> convertString(name)
                .equalsIgnoreCase(language.getNno())));
    }

    public static Language getLanguageBySamiName(String name) {
        return mappedValue(languages.stream().filter(language -> convertString(name)
                .equalsIgnoreCase(language.getSme())));
    }

    private static Language mappedValue(Stream<Language> stream) {
        var language = stream.findAny().orElse(UNDEFINED_LANGUAGE);
        return NORWEGIAN.equals(language) ? BOKMAAL : language;
    }

    private static String convertString(String code) {
        return nonNull(code) ? code.trim() : EMPTY_STRING;
    }
}
