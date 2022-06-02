package com;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    Locale locale;
    ResourceBundle messages;

    public SetLocale(Locale locale, ResourceBundle messages) {
        this.locale = locale;
        this.messages = messages;
    }

    public void setLocale(String lang, String country) {
        locale = new Locale(lang, country);
        messages = ResourceBundle.getBundle("Messages", locale);
        String pattern = messages.getString("locale.set");
        Object[] arguments = {locale.getDisplayLanguage(locale) + " " + locale.getDisplayCountry(locale)};
        String message = new MessageFormat(pattern).format(arguments);
        System.out.println(message);
    }

    public Locale getLocale() {
        return locale;
    }

    public ResourceBundle getMessages() {
        return messages;
    }
}
