package dev.migmags.aifilter;

import org.junit.Test;
import static org.junit.Assert.*;

public class SlopRulesTest {
    @Test public void detectsExplicitAiTitle() {
        assertTrue(new SlopRules().shouldHide("AI Generated Wildlife Documentary", "c1", false));
    }

    @Test public void keepsOrdinaryTitle() {
        assertFalse(new SlopRules().shouldHide("How to repair a bicycle", "c1", false));
    }

    @Test public void blocksChannel() {
        SlopRules rules = new SlopRules();
        rules.blockChannel("UCExample");
        assertTrue(rules.shouldHide("Normal title", "UCExample", false));
    }

    @Test public void allowlistOverridesTitleAndBlocklist() {
        SlopRules rules = new SlopRules();
        rules.blockChannel("UCExample");
        rules.allowChannel("UCExample");
        assertFalse(rules.shouldHide("AI Generated", "UCExample", false));
    }

    @Test public void shortsAreOptional() {
        SlopRules rules = new SlopRules();
        assertFalse(rules.shouldHide("Normal", "c1", true));
        rules.setBlockShorts(true);
        assertTrue(rules.shouldHide("Normal", "c1", true));
    }

    @Test public void handlesMissingMetadata() {
        assertFalse(new SlopRules().shouldHide(null, null, false));
    }
}
