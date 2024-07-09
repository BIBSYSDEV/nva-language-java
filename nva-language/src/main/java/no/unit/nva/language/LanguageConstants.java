package no.unit.nva.language;

import no.unit.nva.language.tooling.JacocoGenerated;

import java.util.List;

public final class LanguageConstants {
    public static final Language AFRIKAANS = new Language("af", List.of("afr"), "afr", "Afrikaans",
            "Afrikaans", "Afrikaans", "Afrikánsagiella");
    public static final Language BOKMAAL = new Language("nb", List.of("nob"), "nob", "Bokmål", "Bokmål",
            "Bokmål", "Girjedárogiella");
    public static final Language BULGARIAN = new Language("bg", List.of("bul"), "bul", "Bulgarian",
            "Bulgarsk", "Bulgarsk", "Bulgáriagiella");
    public static final Language CATALAN = new Language("ca", List.of("cat"), "car", "Catalan",
            "Katalansk", "Katalansk", "Katalánagiella");
    public static final Language CHINESE = new Language("zh", List.of("zho", "chi"), "zho", "Chinese",
            "Kinesisk", "Kinesisk", "Kiinnágiella");
    public static final Language CZECH = new Language("cs", List.of("ces", "cze"), "ces",
            "Czech", "Tsjekkisk", "Tsjekkisk", "Čeahkagiella");
    public static final Language DANISH = new Language("da", List.of("dan"), "dan", "Danish",
            "Dansk", "Dansk", "Dánskkagiella");
    public static final Language DUTCH = new Language("nl", List.of("nld", "dut"), "nld", "Dutch",
            "Nederlandsk", "Nederlandsk", "Hollánddagiella");
    public static final Language ENGLISH = new Language("en", List.of("eng"), "eng", "English",
            "Engelsk", "Engelsk", "Eaŋgalsgiella");
    public static final Language FINNISH = new Language("fi", List.of("fin"), "fin", "Finnish",
            "Finsk", "Finsk", "Suomagiella");
    public static final Language FRENCH = new Language("fr", List.of("fra", "fre"), "fra", "French",
            "Fransk", "Fransk", "Fránskkagiella");
    public static final Language GERMAN = new Language("de", List.of("deu", "ger"), "deu",  "German",
            "Tysk", "Tysk", "Duiskkagiella");
    public static final Language GREEK = new Language("el", List.of("gre", "ell"), "ell", "Greek",
            "Gresk", "Gresk", "Greikkagiella");
    public static final Language HUNGARIAN = new Language("hu", List.of("hun"), "hun",
            "Hungarian", "Ungarsk", "Ungarsk", "Ungárgiella");
    public static final Language ICELANDIC = new Language("is", List.of("isl", "ice"), "isl", "Icelandic",
            "Islandsk", "Islandsk", "Islánddagiella");
    public static final Language ITALIAN = new Language("it", List.of("ita"), "ita", "Italian",
            "Italiensk", "Italiensk", "Itáliagiella");
    public static final Language MISCELLANEOUS = new Language(null, List.of("mis"), "mis", "Miscellaneous language",
            "Annet språk", "Anna språk", null);
    public static final Language MULTIPLE = new Language(null, List.of("mul"), "mul", "Multiple languages",
            "Flere språk", "Fleire språk", "gielat");
    public static final Language NORWEGIAN = new Language("no", List.of("nor"), "nor", "Norwegian",
            "Norsk", "Norsk", "Dárogiella");
    public static final Language NYNORSK = new Language("nn", List.of("nno"), "nno", "Nynorsk",
            "Nynorsk", "Nynorsk", "Ođđadárogiella");
    public static final Language POLISH = new Language("pl", List.of("pol"), "pol", "Polish",
            "Polsk", "Polsk", "Polskkagiella");
    public static final Language PORTUGUESE = new Language("pt", List.of("por"), "por", "Portuguese",
            "Portugisisk", "Portugisisk", "Portugálagiella");
    public static final Language RUSSIAN = new Language("ru", List.of("rus"), "rus", "Russian",
            "Russisk", "Russisk", "Ruoššagiella");
    public static final Language NORTHERN_SAMI = new Language("se", List.of(), "sme", "Northern Sami",
            "Nordsamisk", "Nordsamisk", "Davvisámegiella");
    public static final Language SOUTHERN_SAMI = new Language(null, List.of(), "sma", "Southern Sami", "Sørsamisk",
                                                              "Sørsamisk", "Lullisámegiella");
    public static final Language LULE_SAMI = new Language(null, List.of(), "smj", "Lule sami", "Lulesamisk",
                                                          "Lulesamisk", "Julevsámegiella");
    public static final Language PITE_SAMI = new Language(null, List.of(), "sje", "Pite sami",
                                                          "Pitesamisk", "Pitesamisk", "Bihtánsámegiella");
    public static final Language SKOLT_SAMI = new Language(null, List.of(), "sms", "Skolt sami",
                                                           "Skoltesamisk", "Skoltesamisk", "Nuortasámegiella");
    public static final Language ENARE_SAMI = new Language(null, List.of(), "smn", "Enare sami",
                                                           "Enaresamisk", "Enaresamisk", "Anársámegiella");
    public static final Language KILDIN_SAMI = new Language(null, List.of(), "sjd", "Kildin sami", "Kildinsamisk",
                                                            "Kildinsamisk", "Gielddasámegiella");
    public static final Language SPANISH = new Language("es", List.of("spa"), "spa", "Spanish",
            "Spansk", "Spansk", "Spánskkagiella");
    public static final Language SWEDISH = new Language("sv", List.of("swe"), "swe", "Swedish",
            "Svensk", "Svensk", "Ruoŧagiella");
    public static final Language UNDEFINED_LANGUAGE = new Language(null, List.of("und"), "und",
            "Unknown language", "Ukjent språk", "Ukjent språk", "Dovdameahttun giella");
    public static final LanguageGroup SAMI_LANGUAGES = new LanguageGroup("Sami languages", "Samisk språk",
                                                                         "Samisk språk", "Sámegielat", "smi");

    public static final List<LanguageDescription> ALL_LANGUAGES = List.of(
        UNDEFINED_LANGUAGE,
        ENGLISH,
        BOKMAAL,
        NYNORSK,
        NORWEGIAN,
        MISCELLANEOUS,
        DANISH,
        SWEDISH,
        SPANISH,
        GERMAN,
        NORTHERN_SAMI,
        SOUTHERN_SAMI,
        LULE_SAMI,
        PITE_SAMI,
        SKOLT_SAMI,
        ENARE_SAMI,
        KILDIN_SAMI,
        FRENCH,
        MULTIPLE,
        DUTCH,
        FINNISH,
        ICELANDIC,
        ITALIAN,
        PORTUGUESE,
        RUSSIAN,
        AFRIKAANS,
        BULGARIAN,
        GREEK,
        CATALAN,
        CHINESE,
        POLISH,
        CZECH,
        HUNGARIAN,
        SAMI_LANGUAGES
    );

    @JacocoGenerated
    private LanguageConstants() {

    }
}
