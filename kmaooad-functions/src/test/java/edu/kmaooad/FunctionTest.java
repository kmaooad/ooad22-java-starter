package edu.kmaooad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;

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
        Mono<BotUpdateResult> result = new TelegramWebhook(new ExampleDependencyMock()).apply(Mono.just(update));
        assertEquals(result.block().getMessageId(), "foo");
    }
}
