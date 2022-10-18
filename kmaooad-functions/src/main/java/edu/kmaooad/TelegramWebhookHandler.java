package edu.kmaooad;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import java.util.Optional;

import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

/**
 * Azure Functions with HTTP Trigger.
 */
public class TelegramWebhookHandler extends FunctionInvoker<BotUpdate, BotUpdateResult> {

    /**
     * This function listens at endpoint "/api/TelegramWebhook". To invoke it using
     * "curl" command in bash:
     * curl -d "HTTP Body" {your host}/api/TelegramWebhook
     */
    @FunctionName("TelegramWebhook")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {
                    HttpMethod.POST }, authLevel = AuthorizationLevel.FUNCTION) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        BotUpdate upd = new BotUpdate();
        
        upd.setMessageId("message10");

        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(upd, context))
                .header("Content-Type", "application/json")
                .build();
    }
}
