package io.quarkiverse.authzed.client.deployment;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

@ConfigRoot(name = "authzed", phase = ConfigPhase.BUILD_TIME)
public class AuthzedBuildTimeConfig {

    /**
     * Dev services configuration.
     */
    @ConfigItem
    public DevServicesAuthzedConfig devservices;
}
