package edu.kmaooad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class TelegramWebhook implements Function<Mono<BotUpdate>, Mono<BotUpdateResult>> {

    private ExampleDependency dep;

    @Autowired
    public TelegramWebhook(ExampleDependency dep){
        this.dep = dep;
    }
    public Mono<BotUpdateResult> apply(Mono<BotUpdate> mono) {
        return mono.map(upd -> BotUpdateResult.Ok(upd.getMessageId(), dep.getSomeNumber()));
    }
}