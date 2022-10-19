package edu.kmaooad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for Function class.
 */
public class FunctionTest {
    /**
     * Unit test for HttpTriggerJava method.
     */
    @Test
    public void test() {
        BotUpdate update = new BotUpdate();
        update.setMessageId("foo");
        BotUpdateResult result = new TelegramWebhook(new ExampleDependencyMock()).apply(update);
        assertEquals(result.getMessageId(), "foo");
    }
}
