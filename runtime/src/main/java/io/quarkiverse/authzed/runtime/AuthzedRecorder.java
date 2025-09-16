package io.quarkiverse.authzed.runtime;

import java.util.function.Supplier;

import jakarta.inject.Inject;

import io.quarkiverse.authzed.client.AuthzedClient;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
import io.quarkus.runtime.RuntimeValue;
import io.quarkus.runtime.annotations.Recorder;
import io.quarkus.tls.TlsConfigurationRegistry;

@Recorder
public class AuthzedRecorder {

    private final RuntimeValue<AuthzedConfig> configValue;

    @Inject
    public AuthzedRecorder(RuntimeValue<AuthzedConfig> configValue) {
        this.configValue = configValue;
    }

    AuthzedConfig getConfig() {
        return configValue.getValue();
    }

    public RuntimeValue<AuthzedClient> createClient(Supplier<TlsConfigurationRegistry> tlsRegistry) {
        AuthzedClient client = new AuthzedClient(getConfig(), tlsRegistry.get());
        return new RuntimeValue<>(client);
    }

}
