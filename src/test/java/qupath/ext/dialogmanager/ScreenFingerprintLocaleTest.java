package qupath.ext.dialogmanager;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** The saved screen fingerprint is the same whatever the default locale is. */
class ScreenFingerprintLocaleTest {

    private static final String EXPECTED = "2560x1440@-1920,0/1.25x1.50;";

    private static String partIn(Locale locale) {
        Locale previous = Locale.getDefault();
        try {
            Locale.setDefault(locale);
            return DialogPositionManager.screenFingerprintPart(2560, 1440, -1920, 0, 1.25, 1.5);
        } finally {
            Locale.setDefault(previous);
        }
    }

    @Test
    void decimalCommaLocaleDoesNotChangeTheFingerprint() {
        assertEquals(EXPECTED, partIn(Locale.GERMANY));
    }

    @Test
    void turkishLocaleDoesNotChangeTheFingerprint() {
        assertEquals(EXPECTED, partIn(Locale.forLanguageTag("tr-TR")));
    }

    @Test
    void nativeDigitLocaleDoesNotChangeTheFingerprint() {
        assertEquals(EXPECTED, partIn(Locale.forLanguageTag("ar-EG")));
    }
}
