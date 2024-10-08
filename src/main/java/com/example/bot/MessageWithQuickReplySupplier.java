package com.example.bot;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.linecorp.bot.messaging.model.CameraAction;
import com.linecorp.bot.messaging.model.CameraRollAction;
import com.linecorp.bot.messaging.model.LocationAction;
import com.linecorp.bot.messaging.model.Message;
import com.linecorp.bot.messaging.model.MessageAction;
import com.linecorp.bot.messaging.model.PostbackAction;
import com.linecorp.bot.messaging.model.QuickReply;
import com.linecorp.bot.messaging.model.QuickReplyItem;
import com.linecorp.bot.messaging.model.TextMessage;

public class MessageWithQuickReplySupplier implements Supplier<Message> {
    @Override
    public Message get() {
        final List<QuickReplyItem> items = Arrays.asList(
                new QuickReplyItem(new MessageAction("MessageAction", "MessageAction")),
                new QuickReplyItem(new CameraAction("CameraAction")),
                new QuickReplyItem(new CameraRollAction("CemeraRollAction")),
                new QuickReplyItem(new LocationAction("Location")),
                new QuickReplyItem(new PostbackAction("PostbackAction",
                        "{PostbackAction: true}" /* data */,
                        "PostbackAction clicked" /* text */,
                        null,
                        null,
                        null
                ))
        );

        final QuickReply quickReply = new QuickReply(items);

        return new TextMessage(quickReply, null, "Message with QuickReply", null, null);
    }
}
