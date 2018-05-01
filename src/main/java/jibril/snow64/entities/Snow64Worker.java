package jibril.snow64.entities;

import jibril.snow64.entities.wrapper.Snow64DatacenterWrapper;
import jibril.snow64.entities.wrapper.Snow64GeneratorWrapper;

public interface Snow64Worker {
    String generate();

    Snow64DatacenterWrapper getDatacenter();

    Snow64GeneratorWrapper getGenerator();

    long getWorkerId();
}
