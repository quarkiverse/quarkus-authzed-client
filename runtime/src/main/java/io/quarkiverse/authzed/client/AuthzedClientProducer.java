package io.quarkiverse.authzed.client;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
import io.quarkus.arc.DefaultBean;

@ApplicationScoped
public class AuthzedClientProducer {

    private AuthzedClient client;

    @DefaultBean
    @Singleton
    @Produces
    public AuthzedClient kubernetesClient(AuthzedConfig config) {
        client = new AuthzedClient(config);
        return client;
    }

    @PreDestroy
    public void destroy() {
        if (client != null) {
            try {
                client.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
