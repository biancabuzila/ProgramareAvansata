package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    static Locale locale = Locale.getDefault();
    static ResourceBundle messages;

    public static void main(String[] args) {
        messages = ResourceBundle.getBundle("Messages", locale);

        Scanner commands = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println(messages.getString("prompt"));
            command = commands.nextLine();
            if (command.equals("DisplayLocales")) {
                new DisplayLocales(messages);
            } else if (command.startsWith("SetLocale")) {
                String[] arg = command.split(" ");
                SetLocale setLocale = new SetLocale(locale, messages);
                setLocale.setLocale(arg[1], arg[2]);
                locale = setLocale.getLocale();
                messages = setLocale.getMessages();
            } else if (command.startsWith("Info")) {
                String[] arg = command.split(" ");
                new Info(locale, new Locale(arg[1], arg[2]), messages);
            } else {
                System.out.println(messages.getString("invalid"));
            }
        }
    }
}
