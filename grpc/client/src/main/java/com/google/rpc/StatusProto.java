// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/rpc/status.proto
// Protobuf Java Version: 3.25.0
package com.google.rpc;

public final class StatusProto {

    private StatusProto() {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
    }

    static final com.google.protobuf.Descriptors.Descriptor internal_static_google_rpc_Status_descriptor;

    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_google_rpc_Status_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

    static {
        java.lang.String[] descriptorData = { "\n\027google/rpc/status.proto\022\ngoogle.rpc\032\031g"
                + "oogle/protobuf/any.proto\"N\n\006Status\022\014\n\004co"
                + "de\030\001 \001(\005\022\017\n\007message\030\002 \001(\t\022%\n\007details\030\003 \003"
                + "(\0132\024.google.protobuf.AnyBa\n\016com.google.r" + "pcB\013StatusProtoP\001Z7google.golang.org/gen"
                + "proto/googleapis/rpc/status;status\370\001\001\242\002\003" + "RPCb\006proto3" };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData,
                new com.google.protobuf.Descriptors.FileDescriptor[] { com.google.protobuf.AnyProto.getDescriptor() });
        internal_static_google_rpc_Status_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_google_rpc_Status_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_google_rpc_Status_descriptor, new java.lang.String[] { "Code", "Message", "Details" });
        com.google.protobuf.AnyProto.getDescriptor();
    }
    // @@protoc_insertion_point(outer_class_scope)
}
