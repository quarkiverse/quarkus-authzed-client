package io.quarkiverse.authzed.runtime.config;

import java.net.URL;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

@ConfigRoot(name = "authzed", phase = ConfigPhase.RUN_TIME)
public class AuthzedConfig {

    /**
     * Authzed URL.
     * Example: http://authzed:8080
     */
    @ConfigItem
    public URL url;

    /**
     * The token to use to connect.
     */
    @ConfigItem
    public String token;

}
