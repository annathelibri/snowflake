package pw.aru.libs.snowflake;

import pw.aru.libs.snowflake.entities.SnowflakeGenerator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <p><b>Snowflakes</b> is a time-based ID generation, originally created by Twitter.</p>
 * <p>It's used by <em>Twitter</em>, <em>Discord</em> and other projects as a better reliable way of generating IDs instead of using Serial IDs.</p>
 * <p>A Snowflake is composed by a Custom-Epoch Timestamp, a Datacenter ID, a Worker ID and a Sequencial ID.</p>
 * <p>The reference values of a Snowflake are based of the Twitter Snowflake configs.</p>
 * <br><br>
 * This annotation marks a field, method, parameter or anything else as a Snowflake. Can also be used to build {@link SnowflakeGenerator}s using reflections.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Snowflake {
    /**
     * How much of the Snowflake is occupied by the Datacenter ID, in bits.
     *
     * @return a long meaning the size of the Datacenter ID.
     */
    long datacenterIdBits() default 5;

    /**
     * Returns the base Epoch of the Snowflake.
     *
     * @return the starting epoch
     */
    long epoch();

    /**
     * How much of the Snowflake is occupied by the Sequencial ID, in bits.
     *
     * @return a long meaning the size of the Sequence ID.
     */
    long sequenceBits() default 12;

    /**
     * How much of the Snowflake is occupied by the Worker ID, in bits.
     *
     * @return a long meaning the size of the Worker ID.
     */
    long workerIdBits() default 5;
}
