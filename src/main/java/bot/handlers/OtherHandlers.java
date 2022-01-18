package bot.handlers;

import bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class OtherHandlers extends BaseAbstractHandler implements IBaseHandler {
    @Override
    public void process(Update update) {
        Bot bot = Bot.getInstance();
        SendMessage send = new SendMessage();
        if (update.getMyChatMember().getNewChatMember().getStatus().equals("member") && update.getMyChatMember().getNewChatMember().getUser().getUserName().equals("management_cbot")) {
            send.setChatId(String.valueOf(update.getMyChatMember().getFrom().getId()));
            System.out.println(update);
            send.setText("Assalomu alaykum, siz botni " + update.getMyChatMember().getChat().getTitle() + " guruhiga qo'shdinggiz");
            bot.executeMessage(send);
        }
    }

    private static final OtherHandlers instance = new OtherHandlers();

    public static OtherHandlers getInstance() {
        return instance;
    }
}
