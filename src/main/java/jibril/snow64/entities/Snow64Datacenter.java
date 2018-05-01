package jibril.snow64.entities;

import jibril.snow64.entities.wrapper.Snow64GeneratorWrapper;
import jibril.snow64.entities.wrapper.Snow64WorkerWrapper;

public interface Snow64Datacenter {
    long getDatacenterId();

    Snow64GeneratorWrapper getGenerator();

    Snow64WorkerWrapper getWorker(long worker);
}
