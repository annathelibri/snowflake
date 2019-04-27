package pw.aru.libs.snowflake.entities;

import pw.aru.libs.snowflake.SnowflakeConfig;

import java.time.OffsetDateTime;

public interface SnowflakeGenerator {
    SnowflakeConfig getConfig();

    SnowflakeDatacenter getDatacenter(long datacenter);

    default long generate(long datacenterId, long workerId) {
        return getWorker(datacenterId, workerId).generate();
    }

    default OffsetDateTime getCreationTime(long snowflake) {
        return getConfig().getCreationTime(snowflake);
    }

    default long getCreationTimeMillis(long snowflake) {
        return getConfig().getCreationTimeMillis(snowflake);
    }

    default SnowflakeWorker getWorker(long datacenterId, long workerId) {
        return getDatacenter(datacenterId).getWorker(workerId);
    }
}
