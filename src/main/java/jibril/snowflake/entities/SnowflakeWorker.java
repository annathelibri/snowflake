package jibril.snowflake.entities;

public interface SnowflakeWorker {
    long generate();

    SnowflakeDatacenter getDatacenter();

    SnowflakeGenerator getGenerator();

    long getWorkerId();
}
