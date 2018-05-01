package jibril.snowflake;

public class ConfigBuilder {
    private long datacenterIdBits = 5;
    private long epoch;
    private long sequenceBits = 12;
    private long workerIdBits = 5;

    public ConfigBuilder() {
    }

    public ConfigBuilder(Snowflake metadata) {
        setDatacenterIdBits(metadata.datacenterIdBits());
        setSequenceBits(metadata.sequenceBits());
        setWorkerIdBits(metadata.workerIdBits());
        setEpoch(metadata.epoch());
    }

    public ConfigBuilder(SnowflakeConfig config) {
        datacenterIdBits = config.datacenterIdBits;
        sequenceBits = config.sequenceBits;
        workerIdBits = config.workerIdBits;
        epoch = config.epoch;
    }

    public SnowflakeConfig build() {
        return new SnowflakeConfig(epoch, datacenterIdBits, workerIdBits, sequenceBits);
    }

    public ConfigBuilder setDatacenterIdBits(long datacenterIdBits) {
        if (datacenterIdBits < 0) throw new IllegalArgumentException("datacenterIdBits must be positive");
        if ((datacenterIdBits + workerIdBits + sequenceBits) >= Long.SIZE)
            throw new IllegalArgumentException("(datacenterIdBits + workerIdBits + sequenceBits) need to be under " + Long.SIZE + " bits.");

        this.datacenterIdBits = datacenterIdBits;
        return this;
    }

    public ConfigBuilder setEpoch(long epoch) {
        if (epoch < 0) throw new IllegalArgumentException("epoch must be positive");
        if (epoch > System.currentTimeMillis()) throw new IllegalArgumentException("epoch is on the future");

        this.epoch = epoch;
        return this;
    }

    public ConfigBuilder setSequenceBits(long sequenceBits) {
        if (sequenceBits < 0) throw new IllegalArgumentException("sequenceBits must be positive");
        if ((datacenterIdBits + workerIdBits + sequenceBits) >= Long.SIZE)
            throw new IllegalArgumentException("(datacenterIdBits + workerIdBits + sequenceBits) need to be under " + Long.SIZE + " bits.");

        this.sequenceBits = sequenceBits;
        return this;
    }

    public ConfigBuilder setWorkerIdBits(long workerIdBits) {
        if (workerIdBits < 0) throw new IllegalArgumentException("workerIdBits must be positive");
        if ((datacenterIdBits + workerIdBits + sequenceBits) >= Long.SIZE)
            throw new IllegalArgumentException("(datacenterIdBits + workerIdBits + sequenceBits) need to be under " + Long.SIZE + " bits.");

        this.workerIdBits = workerIdBits;
        return this;
    }
}
