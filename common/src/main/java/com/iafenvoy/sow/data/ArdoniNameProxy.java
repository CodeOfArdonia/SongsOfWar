package com.iafenvoy.sow.data;

import org.jetbrains.annotations.NotNull;

public interface ArdoniNameProxy {
    @NotNull
    String getNameBySeed(long seed) throws UnsupportedOperationException;

    enum Empty implements ArdoniNameProxy {
        INSTANCE;

        @Override
        public @NotNull String getNameBySeed(long seed) throws UnsupportedOperationException {
            return "";
        }
    }
}
