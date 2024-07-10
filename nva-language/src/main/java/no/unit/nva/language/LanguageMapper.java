package no.unit.nva.language;

import no.unit.nva.language.tooling.JacocoGenerated;

import java.net.URI;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;
import static no.unit.nva.language.LanguageConstants.ALL_LANGUAGES;
import static no.unit.nva.language.LanguageConstants.BOKMAAL;
import static no.unit.nva.language.LanguageConstants.MISCELLANEOUS;
import static no.unit.nva.language.LanguageConstants.MULTIPLE;
import static no.unit.nva.language.LanguageConstants.NORWEGIAN;
import static no.unit.nva.language.LanguageConstants.UNDEFINED_LANGUAGE;

public final class LanguageMapper {
    private static final List<LanguageDescription> languages = ALL_LANGUAGES;
    public static final String EMPTY_STRING = "";

    @JacocoGenerated
    private LanguageMapper() {
    }

    public static Language getLanguageByIso6391Code(String code) {
        return (Language) mappedValue(languages.stream().filter(language -> convertString(code)
                .equalsIgnoreCase(language.getIso6391Code())));
    }

    public static Language getLanguageByIso6392Code(String code) {
        return (Language) mappedValue(languages.stream().filter(language -> language.getIso6392Code().stream()
                .anyMatch(lang -> convertString(code).equalsIgnoreCase(lang))));
    }

    public static Language getLanguageByIso6393Code(String code) {
        return (Language) mappedValue(languages.stream().filter(language -> convertString(code)
                .equalsIgnoreCase(language.getIso6393Code())));
    }

    public static LanguageDescription getLanguageByEnglishName(String name) {
        return mappedValue(languages.stream().filter(language -> convertString(name)
                .equalsIgnoreCase(language.getEng())));
    }

    public static LanguageDescription getLanguageByBokmaalName(String name) {
        return mappedValue(languages.stream().filter(language -> convertString(name)
                .equalsIgnoreCase(language.getNob())));
    }

    public static LanguageDescription getLanguageByNynorskName(String name) {
        return mappedValue(languages.stream().filter(language -> convertString(name)
                .equalsIgnoreCase(language.getNno())));
    }

    public static LanguageDescription getLanguageBySamiName(String name) {
        return mappedValue(languages.stream().filter(language -> convertString(name)
                .equalsIgnoreCase(language.getSme())));
    }

    public static LanguageDescription getLanguageByUri(URI uri) {
        return mappedValue(ALL_LANGUAGES.stream()
                .filter(language -> uri.equals(language.getLexvoUri())));
    }

    public static LanguageGroup getLanguageByIso6395Code(String iso6395Code) {
        return (LanguageGroup) mappedValue(languages.stream()
                 .filter(language -> iso6395Code.equals(language.getIso6395Code())));
    }

    public static LanguageDescription getLanguageByPotentialIsoCode(String potentialIsoCode) {
        return mappedValue(languages.stream().filter(language -> matchesCode(potentialIsoCode, language)));
    }

    private static boolean matchesCode(String potentialIsoCode, LanguageDescription language) {
        return potentialIsoCode.equalsIgnoreCase(language.getIso6391Code())
               || iso6392CodesContains(potentialIsoCode, language.getIso6392Code())
               || potentialIsoCode.equalsIgnoreCase(language.getIso6393Code())
               || potentialIsoCode.equalsIgnoreCase(language.getIso6395Code());
    }

    private static boolean iso6392CodesContains(String potentialIsoCode, List<String> iso6392Code) {
        return iso6392Code.stream().anyMatch(potentialIsoCode::equalsIgnoreCase);
    }

    private static LanguageDescription mappedValue(Stream<LanguageDescription> stream) {
        return stream.findAny()
                .map(LanguageMapper::replaceNorwegian)
                .map(LanguageMapper::replaceMiscellaneous)
                .orElse(UNDEFINED_LANGUAGE);
    }

    private static LanguageDescription replaceMiscellaneous(LanguageDescription language) {
        if (MISCELLANEOUS.equals(language)) {
            return MULTIPLE;
        }
        return language;
    }

    private static LanguageDescription replaceNorwegian(LanguageDescription language) {
        if (NORWEGIAN.equals(language)) {
            return BOKMAAL;
        }
        return language;
    }

    private static String convertString(String code) {
        return nonNull(code) ? code.trim() : EMPTY_STRING;
    }
}
