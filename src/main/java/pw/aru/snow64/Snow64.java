package pw.aru.snow64;

import pw.aru.snow64.entities.Snow64Generator;
import pw.aru.snow64.entities.wrapper.Snow64GeneratorWrapper;
import pw.aru.snowflake.entities.SnowflakeGenerator;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 * <b>Snow64</b> is a variant of a Snowflake, made by encoding the long with {@link Base64}, which makes it more compact.
 */
public class Snow64 {
    private static final Decoder decoder = Base64.getUrlDecoder();
    private static final Encoder encoder = Base64.getUrlEncoder().withoutPadding();

    /**
     * Wraps a {@link SnowflakeGenerator} as a {@link Snow64Generator}.
     *
     * @param generator the Snowflake generator.
     * @return the Snowflake generator wrapped as a Snow64 generator.
     */
    public static Snow64Generator convert(SnowflakeGenerator generator) {
        return new Snow64GeneratorWrapper(generator);
    }

    /**
     * Converts a Snowflake to a Snow64.
     *
     * @param snowflake a Snowflake id.
     * @return the equivalent Snow64 id.
     */
    public static String fromSnowflake(long snowflake) {
        return encoder.encodeToString(toByteArray(snowflake)).replace("=", "");
    }

    /**
     * Converts a Snow64 back to a Snowflake.
     *
     * @param snow64 the Snow64 id.
     * @return the equivalent Snowflake id.
     */
    public static long toSnowflake(String snow64) {
        return fromByteArray(decoder.decode(snow64));
    }

    // Copied and flattened from class com.google.common.primitives.Longs (Guava)
    private static long fromByteArray(byte[] bytes) {
        if (bytes.length < Long.BYTES) throw new IllegalArgumentException(
            "array too small: " + bytes.length + " < " + Long.BYTES
        );

        return (bytes[0] & 0xFFL) << 56 | (bytes[1] & 0xFFL) << 48 | (bytes[2] & 0xFFL) << 40
            | (bytes[3] & 0xFFL) << 32 | (bytes[4] & 0xFFL) << 24 | (bytes[5] & 0xFFL) << 16
            | (bytes[6] & 0xFFL) << 8 | (bytes[7] & 0xFFL);
    }

    // Copied and flattened from class com.google.common.primitives.Longs (Guava)
    private static byte[] toByteArray(long value) {
        byte[] result = new byte[8];
        for (int i = 7; i >= 0; i--) {
            result[i] = (byte) (value & 0xffL);
            value >>= 8;
        }
        return result;
    }
}