package no.unit.nva.language;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.URI;
import java.util.stream.Stream;

import static no.unit.nva.language.LanguageConstants.BOKMAAL;
import static no.unit.nva.language.LanguageConstants.ENGLISH;
import static no.unit.nva.language.LanguageConstants.GERMAN;
import static no.unit.nva.language.LanguageConstants.UNDEFINED_LANGUAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageCoreTest {

    @Test
    void shouldHaveIso639_3Code() {
        assertEquals("eng", ENGLISH.getIso6393Code());
    }

    @Test
    void shouldReturnLanguageWhenInputIsIso639_1Code() {
        var actual = LanguageMapper.getLanguageByIso6391Code("en");
        assertEquals(ENGLISH, actual);
    }

    @Test
    void shouldReturnLanguageWhenInputIsIso639_2Code() {
        var actual = LanguageMapper.getLanguageByIso6392Code("ger");
        assertEquals(GERMAN, actual);
    }

    @Test
    void shouldReturnLanguageWhenInputIsIso639_3Code() {
        var actual = LanguageMapper.getLanguageByIso6392Code("eng");
        assertEquals(ENGLISH, actual);
    }

    @Test
    void shouldReturnLanguageWhenInputIsEnglishName() {
        var actual = LanguageMapper.getLanguageByEnglishName("english");
        assertEquals(ENGLISH, actual);
    }

    @Test
    void shouldReturnLanguageWhenInputIsBokmaalName() {
        var actual = LanguageMapper.getLanguageByBokmaalName("Engelsk");
        assertEquals(ENGLISH, actual);
    }

    @Test
    void shouldReturnLanguageWhenInputIsNynorskName() {
        var actual = LanguageMapper.getLanguageByNynorskName("Engelsk");
        assertEquals(ENGLISH, actual);
    }

    @Test
    void shouldReturnLanguageWhenInputIsSamiName() {
        var actual = LanguageMapper.getLanguageBySamiName("Eaŋgalsgiella");
        assertEquals(ENGLISH, actual);
    }

    @Test
    void shouldReturnUndefinedLanguageWhenInputIsUnknown() {
        var actual = LanguageMapper.getLanguageByBokmaalName("Klingonsk");
        assertEquals(UNDEFINED_LANGUAGE, actual);
    }

    @Test
    void shouldReturnLanguageUriWhenInputIsValidLanguage() {
        assertEquals(URI.create("http://lexvo.org/id/iso639-3/eng"), ENGLISH.getLexvoUri());
    }

    @Test
    void shouldReturnBokmaalWhenInputIsNorwegian() {
        var actual = LanguageMapper.getLanguageByBokmaalName("Norsk");
        assertEquals(BOKMAAL, actual);
    }

    @ParameterizedTest(name = "Should return Undefined language when input is \"{0}\"")
    @MethodSource("nullAndEmpty")
    void shouldReturnUndefinedLanguageWhenInputIsEmpty(String value) {
        var actual = LanguageMapper.getLanguageByBokmaalName(value);
        assertEquals(UNDEFINED_LANGUAGE, actual);
    }

    @ParameterizedTest(name = "Should return language when input is \"{0}\"")
    @MethodSource("stringsWithWhiteSpace")
    void shouldReturnUndefinedLanguageWhenInputContainsWhiteSpace(String value) {
        var actual = LanguageMapper.getLanguageByIso6393Code(value);
        assertEquals(ENGLISH, actual);
    }

    private static Stream<Arguments> nullAndEmpty() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("\t"),
                Arguments.of("\r\n")
        );
    }

    private static Stream<Arguments> stringsWithWhiteSpace() {
        return Stream.of(
                Arguments.of("  eng"),
                Arguments.of("eng  "),
                Arguments.of("  eng  "),
                Arguments.of("eng\t"),
                Arguments.of("eng\r\n")
        );
    }
}
