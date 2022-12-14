package edu.kmaooad;

public class BotUpdateResult {
    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    private String messageId;
    private long l;

    public long getL() {
        return l;
    }

    public String getMessageId() {
        return messageId;
    }

    private BotUpdateResult(Boolean success, String messageId) {
        this.success = success;
        this.messageId = messageId;
    }

    public BotUpdateResult(boolean success, String messageId, long l) {
        this(success, messageId);
        this.l = l;
    }

    public static BotUpdateResult Ok(String messageId, long l) {
        return new BotUpdateResult(true, messageId, l);
    }

    public static BotUpdateResult Nok(String messageId) {
        return new BotUpdateResult(false, messageId);
    }

}