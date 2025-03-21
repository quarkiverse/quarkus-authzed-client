package io.quarkiverse.authzed.client.deployment;

import static io.quarkus.deployment.annotations.ExecutionTime.RUNTIME_INIT;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkiverse.authzed.client.AuthzedClient;
import io.quarkiverse.authzed.runtime.AuthzedRecorder;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
import io.quarkus.deployment.Capabilities;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.*;
import io.quarkus.tls.deployment.spi.TlsRegistryBuildItem;
import io.quarkus.vertx.deployment.VertxBuildItem;

class AuthzedClientProcessor {

    static final String FEATURE = "authzed-client";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    @Record(RUNTIME_INIT)
    ServiceStartBuildItem registerSyntheticBeans(
            AuthzedBuildTimeConfig buildTimeConfig,
            AuthzedConfig runtimeConfig,
            SslNativeConfigBuildItem sslNativeConfig,
            VertxBuildItem vertx,
            Optional<TlsRegistryBuildItem> tlsRegistryBuildItem,
            ShutdownContextBuildItem shutdownContextBuildItem,
            AuthzedRecorder recorder,
            Capabilities capabilities,
            BuildProducer<SyntheticBeanBuildItem> syntheticBeans,
            BuildProducer<ExtensionSslNativeSupportBuildItem> sslNativeSupport) {

        var tlsRegistrySupplier = tlsRegistryBuildItem.map(TlsRegistryBuildItem::registry)
                .orElse(() -> null);

        sslNativeSupport.produce(new ExtensionSslNativeSupportBuildItem(FEATURE));

        syntheticBeans.produce(
                SyntheticBeanBuildItem.configure(AuthzedClient.class)
                        .scope(ApplicationScoped.class)
                        .setRuntimeInit()
                        .runtimeValue(recorder.createClient(runtimeConfig, tlsRegistrySupplier))
                        .done());

        return new ServiceStartBuildItem("authzed-client");
    }

}
