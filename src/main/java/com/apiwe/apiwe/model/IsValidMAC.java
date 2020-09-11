package com.apiwe.apiwe.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsValidMAC{
    public static boolean isValidMACAddress(String str)
    {
        // Regex to check valid MACaddress
        String regex
                = "^([0-9A-Fa-f]{2}[:-])"
                + "{5}([0-9A-Fa-f]{2})|"
                + "([0-9a-fA-F]{4}\\."
                + "[0-9a-fA-F]{4}\\."
                + "[0-9a-fA-F]{4})$";

        // Compile ReGex
        Pattern p = Pattern.compile(regex);

        // If string is empty return false
        if (str == null) {
            return false;
        }

        // Find match between given string and regular expression
        Matcher m = p.matcher(str);

        // Return true or false if the string is correct
        return m.matches();
    }
}
