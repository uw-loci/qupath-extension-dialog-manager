package qupath.ext.dialogmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** A version at the end of a title does not change the key a position is saved under. */
class VersionSuffixTest {

    @Test
    void stripsATrailingVersion() {
        assertEquals("QPCAT - Run Clustering",
                DialogPositionManager.stripVersionSuffix("QPCAT - Run Clustering  v. 0.23.3"));
        assertEquals("Tool", DialogPositionManager.stripVersionSuffix("Tool v1.2.0"));
        assertEquals("Tool", DialogPositionManager.stripVersionSuffix("Tool v1.2.0-SNAPSHOT"));
    }

    @Test
    void leavesOtherTitlesAlone() {
        assertEquals("Live Viewer (10x)", DialogPositionManager.stripVersionSuffix("Live Viewer (10x)"));
        assertEquals("Export v2", DialogPositionManager.stripVersionSuffix("Export v2"));
        assertEquals("Save version 3.1 notes",
                DialogPositionManager.stripVersionSuffix("Save version 3.1 notes"));
    }
}
