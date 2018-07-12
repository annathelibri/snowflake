package pw.aru.snow64.entities;

import pw.aru.snow64.entities.wrapper.Snow64GeneratorWrapper;
import pw.aru.snow64.entities.wrapper.Snow64WorkerWrapper;

public interface Snow64Datacenter {
    long getDatacenterId();

    Snow64GeneratorWrapper getGenerator();

    Snow64WorkerWrapper getWorker(long worker);
}
