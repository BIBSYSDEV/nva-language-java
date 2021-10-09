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
import static no.unit.nva.language.LanguageConstants.MULTIPLE;
import static no.unit.nva.language.LanguageConstants.UNDEFINED_LANGUAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageCoreTest {

    public static final URI ENGLISH_URI = URI.create("http://lexvo.org/id/iso639-3/eng");
    private static final URI ROMANCE_URI = URI.create("http://lexvo.org/id/iso639-5/roa");

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
        assertEquals(ENGLISH_URI, ENGLISH.getLexvoUri());
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

    @Test
    void shouldReturnLanguageWhenInputIsUri() {
        var actual = LanguageMapper.getLanguageByUri(ENGLISH_URI);
        assertEquals(ENGLISH, actual);
    }

    @Test
    void shouldReturnUndefinedLanguageWhenInputIsUnknownUri() {
        var actual = LanguageMapper.getLanguageByUri(ROMANCE_URI);
        assertEquals(UNDEFINED_LANGUAGE, actual);
    }

    @ParameterizedTest(name = "Should return re-mapped language {0} when input is URI: {1}")
    @MethodSource("remappingUri")
    void shouldReturnReMappedLanguageWhenInputIsUri(Language expected, URI input) {
        assertEquals(expected, LanguageMapper.getLanguageByUri(input));
    }

    @ParameterizedTest(name = "Should return re-mapped language {0} when input is ISO 629-2: {1}")
    @MethodSource("remappingIso639_2")
    void shouldReturnReMappedLanguageWhenInputIsIso639_2(Language expected, String input) {
        assertEquals(expected, LanguageMapper.getLanguageByIso6392Code(input));
    }

    @ParameterizedTest(name = "Should return re-mapped language {0} when input is ISO 629-3: {1}")
    @MethodSource("remappingIso639_3")
    void shouldReturnReMappedLanguageWhenInputIsIso639_3(Language expected, String input) {
        assertEquals(expected, LanguageMapper.getLanguageByIso6393Code(input));
    }

    @ParameterizedTest(name = "Should return re-mapped language {0} when input is English name: {1}")
    @MethodSource("remappingEnglish")
    void shouldReturnReMappedLanguageWhenInputIsEnglish(Language expected, String input) {
        assertEquals(expected, LanguageMapper.getLanguageByEnglishName(input));
    }

    @ParameterizedTest(name = "Should return re-mapped language {0} when input is Bokmål name: {1}")
    @MethodSource("remappingBokmaal")
    void shouldReturnReMappedLanguageWhenInputIsBokmaal(Language expected, String input) {
        assertEquals(expected, LanguageMapper.getLanguageByBokmaalName(input));
    }

    @ParameterizedTest(name = "Should return re-mapped language {0} when input is Nynorsk name: {1}")
    @MethodSource("remappingNynorsk")
    void shouldReturnReMappedLanguageWhenInputIsNynorsk(Language expected, String input) {
        assertEquals(expected, LanguageMapper.getLanguageByNynorskName(input));
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

    public static Stream<Arguments> remappingUri() {
        return Stream.of(
                Arguments.of(BOKMAAL, URI.create("http://lexvo.org/id/iso639-3/nor")),
                Arguments.of(MULTIPLE, URI.create("http://lexvo.org/id/iso639-3/mis"))
        );
    }

    public static Stream<Arguments> remappingIso639_2() {
        return Stream.of(
                Arguments.of(BOKMAAL, "nor"),
                Arguments.of(MULTIPLE, "mis")
        );
    }

    public static Stream<Arguments> remappingIso639_3() {
        return remappingIso639_2();
    }

    public static Stream<Arguments> remappingEnglish() {
        return Stream.of(
                Arguments.of(BOKMAAL, "norwegian"),
                Arguments.of(MULTIPLE, "miscellaneous language")
        );
    }

    public static Stream<Arguments> remappingBokmaal() {
        return Stream.of(
                Arguments.of(BOKMAAL, "norsk"),
                Arguments.of(MULTIPLE, "annet språk")
        );
    }

    public static Stream<Arguments> remappingNynorsk() {
        return Stream.of(
                Arguments.of(BOKMAAL, "norsk"),
                Arguments.of(MULTIPLE, "anna språk")
        );
    }
}
