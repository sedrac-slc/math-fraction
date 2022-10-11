package com.ei.math.fraction.registory;

import java.util.Locale;
import java.util.ResourceBundle;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FractionMessage {
    private Locale locale;
    @Getter(AccessLevel.NONE)
    private final String baseName = "messages";
    @Getter(AccessLevel.NONE)
    private  ResourceBundle message;
    
    {
        locale = Locale.getDefault();
        message = ResourceBundle.getBundle(baseName);
    }

    public FractionMessage(Locale locale) {
        this.locale = locale;
    }
    
    public FractionMessage(String lang) {
        this.locale = new Locale(lang);
    }     
    
    public FractionMessage(String lang,String country) {
        this.locale = new Locale(lang, country);
    }    
    
    public String getString(String key,Locale locale){
        message = ResourceBundle.getBundle(baseName, locale);
        return message.getString(key);
    }
    
     public String getString(String key){
        return getString(key, locale);
    }
   
 
}
