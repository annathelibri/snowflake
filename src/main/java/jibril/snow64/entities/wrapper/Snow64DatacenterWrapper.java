package jibril.snow64.entities.wrapper;

import jibril.snow64.entities.Snow64Datacenter;
import jibril.snowflake.entities.SnowflakeDatacenter;

public class Snow64DatacenterWrapper implements Snow64Datacenter {
    private final SnowflakeDatacenter delegate;
    private final Snow64GeneratorWrapper generator;

    public Snow64DatacenterWrapper(Snow64GeneratorWrapper generator, SnowflakeDatacenter delegate) {
        this.generator = generator;
        this.delegate = delegate;
    }

    @Override
    public long getDatacenterId() {
        return delegate.getDatacenterId();
    }

    @Override
    public Snow64GeneratorWrapper getGenerator() {
        return generator;
    }

    @Override
    public Snow64WorkerWrapper getWorker(long worker) {
        return new Snow64WorkerWrapper(generator, this, delegate.getWorker(worker));
    }

    public SnowflakeDatacenter getDelegate() {
        return delegate;
    }
}
