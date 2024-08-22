package io.quarkiverse.authzed.runtime;

import java.util.function.Supplier;

import io.quarkiverse.authzed.client.AuthzedClient;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
import io.quarkus.runtime.RuntimeValue;
import io.quarkus.runtime.annotations.Recorder;
import io.quarkus.tls.TlsConfigurationRegistry;

@Recorder
public class AuthzedRecorder {

    public RuntimeValue<AuthzedClient> createClient(AuthzedConfig config, Supplier<TlsConfigurationRegistry> tlsRegistry) {
        AuthzedClient client = new AuthzedClient(config, tlsRegistry.get());
        return new RuntimeValue<>(client);
    }

}
