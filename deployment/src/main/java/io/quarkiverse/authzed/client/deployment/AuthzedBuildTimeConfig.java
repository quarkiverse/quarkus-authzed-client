package io.quarkiverse.authzed.client.deployment;

import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;

@ConfigRoot(phase = ConfigPhase.BUILD_TIME)
@ConfigMapping(prefix = AuthzedConfig.PREFIX)
public interface AuthzedBuildTimeConfig {

    /**
     * Dev services configuration.
     */
    DevServicesAuthzedConfig devservices();

}
