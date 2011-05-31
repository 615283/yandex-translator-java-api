/*
 * Copyright 2011 Jonathan Griggs <jonathan.griggs at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.memetix.mst.translate;

import com.memetix.mst.language.Language;
import java.net.URL;
import java.util.Properties;
import junit.framework.TestCase;

/**
 *
 * @author Jonathan Griggs <jonathan.griggs at gmail.com>
 */
public class TranslateTest extends TestCase {
    
    public Properties p;
    
    public TranslateTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        p = new Properties();
        URL url = ClassLoader.getSystemResource("META-INF/config.properties");
        p.load(url.openStream());
        String apiKey = p.getProperty("microsoft.translator.api.key");
        Translate.setKey(apiKey);
    }
    
    @Override
    protected void tearDown() throws Exception {
        Translate.setKey(null);
        Translate.setHttpReferrer(null);
        super.tearDown();
    }

    public void testSetApiKey() {
        assert(true);
    }
    
    
    public void testTranslate_SetReferrer() throws Exception {
        Translate.setHttpReferrer("http://localhost:8080");
        assertEquals("Salut",Translate.execute("Hello", Language.ENGLISH, Language.FRENCH));
    }
    
    public void testTranslate_NoSpace() throws Exception {
        assertEquals("Salut",Translate.execute("Hello", Language.ENGLISH, Language.FRENCH));
    }
    
    public void testTranslate_EncodeSpace() throws Exception {
        assertEquals("Bonjour, mon nom est",Translate.execute("Hello, my name is", Language.ENGLISH, Language.FRENCH));
    }
    
    public void testTranslate_AutoDetectOrigin() throws Exception {
        assertEquals("Bonjour, mon nom est",Translate.execute("Hello, my name is", Language.AUTO_DETECT, Language.FRENCH));
    }
    
    public void testTranslate_AutoDetectOrigin_French() throws Exception {
        assertEquals("Salut tout le monde", Translate.execute("Hallo welt", Language.AUTO_DETECT, Language.FRENCH));
    }
    
    public void testTranslate_ItalianToGerman_AndBack() throws Exception {
        assertEquals("Salve, mondo", Translate.execute("Hallo welt", Language.GERMAN, Language.ITALIAN));
        assertEquals("Hallo welt".toLowerCase(), Translate.execute("Salve, mondo", Language.ITALIAN, Language.GERMAN).toLowerCase());
    }
    
    public void testTranslate_EnglishToArabic_Unicode() throws Exception {
        assertEquals("هذا هو بلدي الترجمة للعربية",Translate.execute("This is my translation intended for Arabic", Language.ENGLISH, Language.ARABIC));
    }
    
    public void testTranslate_EnglishToTurkish_Unicode() throws Exception {
        assertEquals("Merhaba Dünya", Translate.execute("Hello world", Language.ENGLISH, Language.TURKISH));
        assertEquals("Hello world", Translate.execute("Merhaba Dünya", Language.TURKISH, Language.ENGLISH));
    }
    
    public void testTranslate_RussianToSpanish_Unicode() throws Exception {
        assertEquals("Hola mundo", Translate.execute("Привет мир", Language.RUSSIAN, Language.SPANISH));
    }
    
    public void testTranslate_EnglishToJapanese_Unicode() throws Exception {
        assertEquals("ハローワールド", Translate.execute("Hello world", Language.ENGLISH, Language.JAPANESE));
        assertEquals("Hello world", Translate.execute("ハローワールド", Language.AUTO_DETECT, Language.ENGLISH));
    }
    
    public void testTranslate_EnglishToKorean_Unicode() throws Exception {
        assertEquals("전 세계 여러분 안녕하세요", Translate.execute("Hello world", Language.ENGLISH, Language.KOREAN));
        assertEquals("Hello world", Translate.execute("전 세계 여러분 안녕하세요", Language.AUTO_DETECT, Language.ENGLISH));
    }
    
    public void testTranslate_EnglishToKorean_DefaultToAutoDetect() throws Exception {
        assertEquals("전 세계 여러분 안녕하세요", Translate.execute("Hello world", Language.ENGLISH, Language.KOREAN));
        assertEquals("Hello world", Translate.execute("전 세계 여러분 안녕하세요", Language.AUTO_DETECT, Language.ENGLISH));
        assertEquals("Hello world", Translate.execute("전 세계 여러분 안녕하세요", Language.ENGLISH));
    }
    
    public void testTranslate_EnglisthToHebrew_Unicode() throws Exception {
        assertEquals("מזהה", Translate.execute("ID", Language.ENGLISH, Language.HEBREW));
    }
    
     public void testDetect_NoKey() throws Exception {
        Translate.setKey(null);
        
        boolean exception = false;
        try {
            Translate.execute("ハローワールド", Language.AUTO_DETECT, Language.ENGLISH);
        }catch(RuntimeException re) {
            exception = true;
            assertEquals("INVALID_API_KEY - Please set the API Key with your Bing Developer's Key",re.getMessage());
        }
        assertEquals(true, exception);
    }
    
    public void testLarge() throws Exception {
		Translate.execute("Figures from the Office for National Statistics (ONS) show that between December and April, "
				+ "the five-month period typically regarded as peak bonus season, those working in the financial "
				+ "intermediation sector received bonuses worth ¬¨¬£7.6bn. The figure is more than 40pc lower than last"
				+ "year's total of ¬¨¬£13.2bn, but the fact that it came during a period where the banking system owed its"
				+ "survival to the rescue support of taxpayers\' money will spark further outrage. Related Articles USS"
				+ "pays bonuses despite fund fall Ex-HBOS chief Hornby gives up ¬¨¬£1m redundancyBankers blind to bonus "
				+ "'furore' Barclays and Lloyds to dish out millions in bonuses. City bonuses defy credit crunch and "
				+ "hit new record of ¬¨¬£13bn. We are still mad with the banks but we are no closer to getting even. News"
				+ "of the huge sums being offered by Barclays to five traders at JP Morgan will also stoke the row. "
				+ "Barclays is close to poaching Todd Edgar, 37, a star commodity trader at JP Morgan, and his four "
				+ "team members to head up the foreign exchange trading desk. Mr Edgar is responsible for a $2bn book "
				+ "at JP Morgan and single-handedly made the US investment bank a $100m profit last year. At Barclays,"
				+ "the team will have an emerging markets focus, with two members based in Asia and Mr Edgar and the "
				+ "others operating out of London. They will also continue to trade commodities, but to a lesser degree"
				+ "than before. Barclays has offered the team a combined $25m in salaries and bonuses paid in cash "
				+ "guarantees and deferred stock. In addition, they will take a share of future profits that could lift"
				+ "the package to $50m. Market-leading rates on profit shares are currently 12pc, according to bankers,"
				+ "but Mr Edgar and his team are said to have been offered even more generous terms. Sources suggest Mr"
				+ "Edgar himself could receive up to half the total. It is understood the pay package does not "
				+ "contravene any of the Financial Service Authority's guidelines. At JP Morgan, Mr Edgar was largely a"
				+ "proprietary trader, gambling with the bank's own money. At Barclays, although he will take "
				+ "proprietary positions, his main role will be client business. Mr Edgar's appointment would follow "
				+ "public outrage last week over a ¬¨¬£7m \"market leading\" deal agreed by Royal Bank of Scotland, 70pc "
				+ "owned by the taxpayer, for a Merrill Lynch banker, Antonio Polverino. Although Barclays has not "
				+ "taken any cash directly from the state, critics say it is the beneficiary of ¬¨¬£1.2 trillion of "
				+ "taxpayer support for the financial system as a whole. Senior Treasury officials believe that the "
				+ "bank would have collapsed were it not for their assistance. In an interview this weekend, the Shadow"
				+ "Chancellor, George Osborne said it was \"totally unacceptable\" that the major banks are paying "
				+ "large bonuses on the back of taxpayer guarantees. Mr Osborne said: \"There are hundreds of billions "
				+ "of pounds of guarantees in existence: guarantees provided by the taxpayer to all banks. The reason "
				+ "those guarantees are in place is not so the bankers can pay themselves large bonuses. \"The scale of"
				+ "this year's bonus payments, as revealed by the ONS statistics, would be enough to finance an almost "
				+ "2p reduction in the basic rate of income tax. The payments came after the unprecedented bail-out of "
				+ "British banks, which cost the taxpayer some ¬¨¬£35bn in capital infusions. Lord Oakeshott, Liberal "
				+ "Democrat Treasury spokesman, said: \"These figures suggest that the bankers are taking most of the "
				+ "profits and the taxpayer is taking most of the risk. \"The official confirmation of the scale of "
				+ "City bonuses in the past year underlines the fact that even against the backdrop of the worst "
				+ "financial crisis in British history, bankers awarded themselves bonuses which were still "
				+ "significantly larger, even in nominal terms, than those handed out five years ago in 2004, when the "
				+ "City was entering the credit boom. Barclays and JP Morgan declined to comment.",
				Language.ENGLISH, Language.FRENCH);
	}
}
