package com.rmtheis.yandtran;

import com.rmtheis.yandtran.detect.Detect;
import com.rmtheis.yandtran.language.Language;
import com.rmtheis.yandtran.translate.Translate;

public final class TranslateUtils {

    public static String detect(String apiKey, String text) {
        try {
            Translate.setKey(apiKey);
            Language translation = Detect.execute(text);
            return translation.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String translate(String apiKey, String text, Language in, Language out) {
        try {
            Translate.setKey(apiKey);
            String translation = Translate.execute(text, in, out);
            return translation;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
