package io.quarkiverse.authzed.runtime;

import io.quarkiverse.authzed.client.AuthzedClient;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
import io.quarkus.runtime.RuntimeValue;
import io.quarkus.runtime.annotations.Recorder;

@Recorder
public class AuthzedRecorder {

    public RuntimeValue<AuthzedClient> createClient(AuthzedConfig config) {
        AuthzedClient client = new AuthzedClient(config);
        return new RuntimeValue<>(client);
    }

}
