package pw.aru.libs.snowflake.snow64.entities.wrapper;

import pw.aru.libs.snowflake.SnowflakeConfig;
import pw.aru.libs.snowflake.entities.SnowflakeGenerator;
import pw.aru.libs.snowflake.entities.SnowflakeWorker;
import pw.aru.libs.snowflake.snow64.Snow64;
import pw.aru.libs.snowflake.snow64.entities.Snow64Datacenter;
import pw.aru.libs.snowflake.snow64.entities.Snow64Generator;
import pw.aru.libs.snowflake.snow64.entities.Snow64Worker;

import java.time.OffsetDateTime;

public class Snow64GeneratorWrapper implements Snow64Generator {
    private final SnowflakeGenerator delegate;

    public Snow64GeneratorWrapper(SnowflakeGenerator delegate) {
        this.delegate = delegate;
    }

    @Override
    public SnowflakeConfig getConfig() {
        return delegate.getConfig();
    }

    @Override
    public Snow64Datacenter getDatacenter(long datacenter) {
        return new Snow64DatacenterWrapper(this, delegate.getDatacenter(datacenter));
    }

    @Override
    public OffsetDateTime getCreationTime(long snowflake) {
        return delegate.getCreationTime(snowflake);
    }

    @Override
    public long getCreationTimeMillis(long snowflake) {
        return delegate.getCreationTimeMillis(snowflake);
    }

    @Override
    public Snow64Worker getWorker(long datacenterId, long workerId) {
        SnowflakeWorker worker = delegate.getWorker(datacenterId, workerId);
        return new Snow64WorkerWrapper(this, new Snow64DatacenterWrapper(this, worker.getDatacenter()), worker);
    }

    @Override
    public String generate(long datacenterId, long workerId) {
        return Snow64.fromSnowflake(delegate.generate(datacenterId, workerId));
    }

    public SnowflakeGenerator getDelegate() {
        return delegate;
    }

}
