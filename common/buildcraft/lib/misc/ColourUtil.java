package buildcraft.lib.misc;

import java.util.Arrays;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;

public class ColourUtil {
    private static final String[] NAMES = { //
        "Black", "Red", "Green", "Brown",//
        "Blue", "Purple", "Cyan", "LightGray", //
        "Gray", "Pink", "Lime", "Yellow", //
        "LightBlue", "Magenta", "Orange", "White"//
    };
    private static final int[] DARK_HEX = { //
        0x2D2D2D, 0xA33835, 0x394C1E, 0x5C3A24,//
        0x3441A2, 0x843FBF, 0x36809E, 0x888888,//
        0x444444, 0xE585A0, 0x3FAA36, 0xCFC231,//
        0x7F9AD1, 0xFF64FF, 0xFF6A00, 0xFFFFFF //
    };
    private static final int[] LIGHT_HEX = { //
        0x181414, 0xBE2B27, 0x007F0E, 0x89502D,//
        0x253193, 0x7e34bf, 0x299799, 0xa0a7a7,//
        0x7A7A7A, 0xD97199, 0x39D52E, 0xFFD91C,//
        0x66AAFF, 0xD943C6, 0xEA7835, 0xe4e4e4 //
    };
    private static final String[] DYES = new String[16];
    private static final TextFormatting[] FORMAT = { //
        TextFormatting.BLACK, TextFormatting.RED, TextFormatting.DARK_GREEN, TextFormatting.GOLD,//
        TextFormatting.BLUE, TextFormatting.DARK_PURPLE, TextFormatting.DARK_AQUA, TextFormatting.GRAY,//
        TextFormatting.DARK_GRAY, TextFormatting.LIGHT_PURPLE, TextFormatting.GREEN, TextFormatting.YELLOW,//
        TextFormatting.AQUA, TextFormatting.DARK_PURPLE, TextFormatting.GOLD, TextFormatting.WHITE,//
    };

    static {
        for (int i = 0; i < 16; i++) {
            DYES[i] = "dye" + NAMES[i];
        }
    }

    public static String getDyeName(EnumDyeColor colour) {
        return DYES[colour.getDyeDamage()];
    }

    public static String getName(EnumDyeColor colour) {
        return NAMES[colour.getDyeDamage()];
    }

    public static int getDarkHex(EnumDyeColor colour) {
        return DARK_HEX[colour.getDyeDamage()];
    }

    public static int getLightHex(EnumDyeColor colour) {
        return LIGHT_HEX[colour.getDyeDamage()];
    }

    public static String[] getNameArray() {
        return Arrays.copyOf(NAMES, NAMES.length);
    }

    public static String getLocalized(EnumDyeColor colour) {
        return I18n.translateToLocal("item.fireworksCharge." + colour.getUnlocalizedName());
    }

    public static String getTextFullTooltip(EnumDyeColor colour) {
        return getTextFormatTooltip(colour) + getLocalized(colour) + TextFormatting.RESET;
    }

    public static String getTextFull(EnumDyeColor colour) {
        return getTextFormat(colour) + getLocalized(colour) + TextFormatting.RESET;
    }

    public static TextFormatting getTextFormatTooltip(EnumDyeColor colour) {
        if (colour == EnumDyeColor.BLACK) colour = EnumDyeColor.GRAY;
        return getTextFormat(colour);
    }

    public static TextFormatting getTextFormat(EnumDyeColor colour) {
        return FORMAT[colour.getDyeDamage()];
    }

    public static int swapArgbToAbgr(int argb) {
        int a = (argb >> 24) & 0xFF;
        int r = (argb >> 16) & 0xFF;
        int g = (argb >> 8) & 0xFF;
        int b = (argb >> 0) & 0xFF;
        return (a << 24) | (b << 16) | (g << 8) | r;
    }
}
