import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MyAmazingBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            if(update.getMessage().getText().contains("Mario")){
                SendMessage mario = new SendMessage()
                        .setChatId(update.getMessage().getChatId())
                        .setText("Mario es bien puto");
                try {
                    sendMessage(mario); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());


            try {
                sendMessage(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "Botbot";
    }

    @Override
    public String getBotToken() {
        return "";
    }
}