package com.rmtheis.yandtran.language;

import java.util.HashMap;

public class LanguageNameConverter {

    public LanguageNameConverter() {
        this.names.put(Language.ALBANIAN, "Albanian");
        this.names.put(Language.ARMENIAN, "Armenian");
        this.names.put(Language.AZERBAIJANI, "Azerbaijani");
        this.names.put(Language.BELARUSIAN, "Belarusian");
        this.names.put(Language.BULGARIAN, "Bulgarian");
        this.names.put(Language.CATALAN, "Catalan");
        this.names.put(Language.CROATIAN, "Croatian");
        this.names.put(Language.CZECH, "Czech");
        this.names.put(Language.DANISH, "Danish");
        this.names.put(Language.DUTCH, "Dutch");
        this.names.put(Language.ENGLISH, "English");
        this.names.put(Language.ESTONIAN, "Estonian");
        this.names.put(Language.FINNISH, "Finnish");
        this.names.put(Language.FRENCH, "French");
        this.names.put(Language.GEORGIAN, "Georgian");
        this.names.put(Language.GERMAN, "German");
        this.names.put(Language.GREEK, "Greek");
        this.names.put(Language.HUNGARIAN, "Hungarian");
        this.names.put(Language.ITALIAN, "Italian");
        this.names.put(Language.LATVIAN, "Latvian");
        this.names.put(Language.LITHUANIAN, "Lithuanian");
        this.names.put(Language.MACEDONIAN, "Macedonian");
        this.names.put(Language.NORWEGIAN, "Norwegian");
        this.names.put(Language.POLISH, "Polish");
        this.names.put(Language.PORTUGUESE, "Portuguese");
        this.names.put(Language.ROMANIAN, "Romanian");
        this.names.put(Language.RUSSIAN, "Russian");
        this.names.put(Language.SERBIAN, "Serbian");
        this.names.put(Language.SLOVAK, "Slovak");
        this.names.put(Language.SLOVENIAN, "Slovenian");
        this.names.put(Language.SPANISH, "Spanish");
        this.names.put(Language.SWEDISH, "Swedish");
        this.names.put(Language.TURKISH, "Turkish");
        this.names.put(Language.UKRAINIAN, "Ukrainian");

        this.codes.put("Albanian", Language.ALBANIAN);
        this.codes.put("Armenian", Language.ARMENIAN);
        this.codes.put("Azerbaijani", Language.AZERBAIJANI);
        this.codes.put("Belarusian", Language.BELARUSIAN);
        this.codes.put("Bulgarian", Language.BULGARIAN);
        this.codes.put("Catalan", Language.CATALAN);
        this.codes.put("Croatian", Language.CROATIAN);
        this.codes.put("Czech", Language.CZECH);
        this.codes.put("Danish", Language.DANISH);
        this.codes.put("Dutch", Language.DUTCH);
        this.codes.put("English", Language.ENGLISH);
        this.codes.put("Estonian", Language.ESTONIAN);
        this.codes.put("Finnish", Language.FINNISH);
        this.codes.put("French", Language.FRENCH);
        this.codes.put("Georgian", Language.GEORGIAN);
        this.codes.put("German", Language.GERMAN);
        this.codes.put("Greek", Language.GREEK);
        this.codes.put("Hungarian", Language.HUNGARIAN);
        this.codes.put("Italian", Language.ITALIAN);
        this.codes.put("Latvian", Language.LATVIAN);
        this.codes.put("Lithuanian", Language.LITHUANIAN);
        this.codes.put("Macedonian", Language.MACEDONIAN);
        this.codes.put("Norwegian", Language.NORWEGIAN);
        this.codes.put("Polish", Language.POLISH);
        this.codes.put("Portuguese", Language.PORTUGUESE);
        this.codes.put("Romanian", Language.ROMANIAN);
        this.codes.put("Russian", Language.RUSSIAN);
        this.codes.put("Serbian", Language.SERBIAN);
        this.codes.put("Slovak", Language.SLOVAK);
        this.codes.put("Slovenian", Language.SLOVENIAN);
        this.codes.put("Spanish", Language.SPANISH);
        this.codes.put("Swedish", Language.SWEDISH);
        this.codes.put("Turkish", Language.TURKISH);
        this.codes.put("Ukrainian", Language.UKRAINIAN);
    }

    private HashMap<Language, String> names = new HashMap<Language, String>();

    public String getByCode(Language code) {
        if (!names.containsKey(code)) throw new RuntimeException("ERR_CODE_NOT_FOUND The language code could not be found.");
        return names.get(code);
    }

    public String getByCode(String code) {
        if (!names.containsKey(code)) throw new RuntimeException("ERR_CODE_NOT_FOUND The language code could not be found.");
        return names.get(Language.fromString(code));
    }


    private HashMap<String, Language> codes = new HashMap<String, Language>();

    public Language getLangByName(String name) {
        if (!codes.containsKey(name)) throw new RuntimeException("ERR_CODE_NOT_FOUND The language name could not be found.");
        return codes.get(name);
    }

    public String getCodeByName(String name) {
        if (!codes.containsKey(name)) throw new RuntimeException("ERR_CODE_NOT_FOUND The language name could not be found.");
        return codes.get(name).toString();
    }

}
