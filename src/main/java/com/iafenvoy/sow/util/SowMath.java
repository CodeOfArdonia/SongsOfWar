package com.iafenvoy.sow.util;

import net.minecraft.world.phys.Vec3;

public class SowMath {
    public static Vec3 getRotationVector(float pitch, float yaw) {
        double f = Math.toRadians(pitch);
        double g = -Math.toRadians(yaw);
        double h = Math.cos(g);
        double i = Math.sin(g);
        double j = Math.cos(f);
        double k = Math.sin(f);
        return new Vec3(i * j, -k, h * j);
    }

    public static Vec3 getRotationVectorUnit(float pitch, float yaw) {
        return toUnit(getRotationVector(pitch, yaw));
    }

    public static Vec3 toUnit(double x, double y, double z) {
        return toUnit(new Vec3(x, y, z));
    }

    public static Vec3 toUnit(Vec3 origin) {
        return origin.length() == 0 ? origin : origin.scale(1 / origin.length());
    }

    public static Vec3 reverse(Vec3 origin, double distance) {
        double newLength = distance - origin.length();
        return toUnit(origin).scale(newLength > 0 ? newLength : 0);
    }
}
