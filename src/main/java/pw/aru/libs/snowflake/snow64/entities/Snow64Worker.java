package pw.aru.libs.snowflake.snow64.entities;

import pw.aru.libs.snowflake.snow64.entities.wrapper.Snow64DatacenterWrapper;
import pw.aru.libs.snowflake.snow64.entities.wrapper.Snow64GeneratorWrapper;

public interface Snow64Worker {
    String generate();

    Snow64DatacenterWrapper getDatacenter();

    Snow64GeneratorWrapper getGenerator();

    long getWorkerId();
}
