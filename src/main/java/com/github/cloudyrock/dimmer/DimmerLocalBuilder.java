package com.github.cloudyrock.dimmer;

import org.aspectj.lang.Aspects;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class DimmerLocalBuilder extends DimmerConfigurableBuilder {

    protected DimmerLocalBuilder(Collection<String> environments,
                                 Map<String, Set<FeatureMetadata>> configMetadata) {
        super(environments, configMetadata);
    }

    public synchronized DimmerProcessor build() {
        if (!isInitialised()) {
            instance = new DimmerProcessor(defaultExceptionType);
            Aspects.aspectOf(DimmerAspect.class).setDimmerProcessor(instance);
        }
        return instance;
    }

    @Override
    protected DimmerConfigurableBuilder createNewInstance(
            Collection<String> environments,
            Map<String, Set<FeatureMetadata>> configMetadata) {
        return new DimmerLocalBuilder(environments, configMetadata);
    }
}