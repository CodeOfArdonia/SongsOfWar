package com.iafenvoy.sow.config;

import java.time.LocalDate;

public class Anniversary {
    public static boolean shouldInvoke() {
        if (SowCommonConfig.INSTANCE.common.anniversary.getValue() instanceof InvokeType type) {
            if (type == InvokeType.TRUE) return true;
            if (type == InvokeType.FALSE) return false;
            return isDateInRange(LocalDate.now());
        }
        return false;
    }

    public static boolean isDateInRange(LocalDate currentDate) {
        LocalDate startDate = LocalDate.of(currentDate.getYear(), 11, 23);
        LocalDate endDate = LocalDate.of(currentDate.getYear(), 11, 29);
        return !currentDate.isBefore(startDate) && !currentDate.isAfter(endDate);
    }

    public enum InvokeType {
        TRUE, NORMAL, FALSE
    }
}
