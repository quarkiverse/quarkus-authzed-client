// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/v1/openapi.proto
// Protobuf Java Version: 3.25.0
package com.authzed.api.v1;

public final class Openapi {

    private Openapi() {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
    }

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

    static {
        java.lang.String[] descriptorData = { "\n\034authzed/api/v1/openapi.proto\022\016authzed."
                + "api.v1\032.protoc-gen-openapiv2/options/ann" + "otations.protoB\200\003\n\022com.authzed.api.v1Z2g"
                + "ithub.com/authzed/authzed-go/proto/authz"
                + "ed/api/v1\222A\264\002\022\234\001\n\007Authzed\"D\n\rAuthzed, In"
                + "c.\022\036https://github.com/authzed/api\032\023supp" + "ort@authzed.com*F\n\022Apache 2.0 License\0220h"
                + "ttps://github.com/authzed/api/blob/main/" + "LICENSE2\0031.0*\003\001\002\0042\020application/json:\020app"
                + "lication/jsonZ#\n!\n\nApiKeyAuth\022\023\010\002\032\rAutho"
                + "rization \002rE\n\033More about the Authzed API" + ".\022&https://docs.authzed.com/reference/ap"
                + "ib\006proto3" };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData,
                new com.google.protobuf.Descriptors.FileDescriptor[] {
                        grpc.gateway.protoc_gen_openapiv2.options.Annotations.getDescriptor() });
        com.google.protobuf.ExtensionRegistry registry = com.google.protobuf.ExtensionRegistry.newInstance();
        registry.add(grpc.gateway.protoc_gen_openapiv2.options.Annotations.openapiv2Swagger);
        com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(descriptor, registry);
        grpc.gateway.protoc_gen_openapiv2.options.Annotations.getDescriptor();
    }
    // @@protoc_insertion_point(outer_class_scope)
}
