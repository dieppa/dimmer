package com.github.cloudyrock.dimmer;

import java.util.*;

public final class DimmerConfigResponse {

    private final String environment;
    private final Set<String> featuresIntercepted;


    public DimmerConfigResponse(String environment, Set<String> featureInterceptedList) {
        this.environment = environment;
        this.featuresIntercepted = featureInterceptedList != null ? featureInterceptedList : Collections.emptySet();
    }

    public Set<String> getFeaturesIntercepted() {
        return featuresIntercepted;
    }

}
