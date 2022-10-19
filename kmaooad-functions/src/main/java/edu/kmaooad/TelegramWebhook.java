package edu.kmaooad;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TelegramWebhook implements Function<BotUpdate, BotUpdateResult> {

    private ExampleDependency dep;

    @Autowired
    public TelegramWebhook(ExampleDependency dep){
        this.dep = dep;
    }
    public BotUpdateResult apply(BotUpdate upd) {
        return BotUpdateResult.Ok(upd.getMessageId(), dep.getSomeNumber());
    }
}