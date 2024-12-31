package com.iafenvoy.sow.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;

public class BookUtils {
    public static String nbtToString(NbtList nbtList) {
        return nbtList.stream()
                .map(NbtElement::asString)
                .map(JsonParser::parseString)
                .map(JsonElement::getAsJsonObject)
                .map(x -> x.get("text"))
                .map(JsonElement::getAsString)
                .reduce(new StringBuilder(), StringBuilder::append, (a, b) -> a.append(b.toString()))
                .toString();
    }
}
