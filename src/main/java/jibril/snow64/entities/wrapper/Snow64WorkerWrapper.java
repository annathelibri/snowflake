package jibril.snow64.entities.wrapper;

import jibril.snow64.Snow64;
import jibril.snow64.entities.Snow64Worker;
import jibril.snowflake.entities.SnowflakeWorker;

public class Snow64WorkerWrapper implements Snow64Worker {
    private final Snow64DatacenterWrapper datacenter;
    private final SnowflakeWorker delegate;
    private final Snow64GeneratorWrapper generator;

    public Snow64WorkerWrapper(Snow64GeneratorWrapper generator, Snow64DatacenterWrapper datacenter, SnowflakeWorker delegate) {
        this.generator = generator;
        this.datacenter = datacenter;
        this.delegate = delegate;
    }

    @Override
    public long getWorkerId() {
        return delegate.getWorkerId();
    }

    @Override
    public Snow64GeneratorWrapper getGenerator() {
        return generator;
    }

    @Override
    public Snow64DatacenterWrapper getDatacenter() {
        return datacenter;
    }

    @Override
    public String generate() {
        return Snow64.fromSnowflake(delegate.generate());
    }

    public SnowflakeWorker getDelegate() {
        return delegate;
    }
}
