package dev.d3mohok.gastcore.utils;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColor {
    private static final Pattern HEX_PATTERN = Pattern.compile("&#([a-fA-F0-9]{6})");
    public static String colorize(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        Matcher matcher = HEX_PATTERN.matcher(input);
        StringBuilder buffer = new StringBuilder();

        while (matcher.find()) {
            String hexColor = matcher.group(1);
            StringBuilder hexCode = new StringBuilder(ChatColor.COLOR_CHAR + "x");

            for (char c : hexColor.toCharArray()) {
                hexCode.append(ChatColor.COLOR_CHAR).append(c);
            }
            matcher.appendReplacement(buffer, hexCode.toString());
        }
        matcher.appendTail(buffer);
        String hexProcessed = buffer.toString();
        return ChatColor.translateAlternateColorCodes('&', hexProcessed);
    }
}