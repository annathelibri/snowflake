package pw.aru.snowflake;

import pw.aru.snowflake.entities.SnowflakeGenerator;

import java.time.OffsetDateTime;

/**
 * Marks a snowflake entity. Snowflake entities are ones that have an id that uniquely identifies them.
 */
public interface ISnowflake {

    /**
     * The Snowflake Generator that made this Snowflake. Can be customized to reflect the value on {@link #getCreationTime}
     *
     * @return an Snowflake {@link SnowflakeGenerator}.
     */
    SnowflakeGenerator getGenerator();

    /**
     * The Snowflake id of this entity. This is unique to every entity and will never change.
     *
     * @return long containing the Id.
     */
    long getId();

    /**
     * The time this entity was created. Calculated through the Snowflake in {@link #getId}.
     *
     * @return OffsetDateTime - Time this entity was created at.
     */
    default OffsetDateTime getCreationTime() {
        return getGenerator().getCreationTime(getId());
    }
}