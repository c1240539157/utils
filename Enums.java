package com.side.enumerated;

import java.util.Random;

/**
 * 随机选取enum实例
 *
 * @author chenside
 * @since 10/4/15 11:01 AM
 */
public class Enums {
    private static Random rand = new Random(47);

    public static <T extends Enum> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }

}
