package com;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    public Info(Locale current, Locale locale, ResourceBundle messages) {
        String pattern = messages.getString("info");

        Object[] arguments = {locale.getDisplayLanguage(locale) + " " + locale.getDisplayCountry(locale)};
        String message = new MessageFormat(pattern).format(arguments);
        System.out.print(message);

        System.out.println("\n    Country: " + locale.getDisplayCountry(current) + " (" + locale.getDisplayCountry(locale) + ")");
        System.out.println("    Language: " + locale.getDisplayLanguage(current) + " (" + locale.getDisplayLanguage(locale) + ")");
        System.out.println("    Currency: " + Currency.getInstance(locale) + " (" + Currency.getInstance(locale).getDisplayName(locale) + ")");

        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        String[] weekdays = dfs.getWeekdays();
        System.out.print("    Week Days: ");
        for (String weekday : weekdays)
            System.out.print(weekday + " ");

        System.out.print("\n    Months: ");
        String[] months = dfs.getMonths();
        for (String month : months)
            System.out.print(month + " ");

        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.LONG)
                .withLocale(current);
        DateTimeFormatter formatter2 = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.LONG)
                .withLocale(locale);
        System.out.println("\n    Today: " + today.format(formatter1) + " (" + today.format(formatter2) + ")");
    }
}
