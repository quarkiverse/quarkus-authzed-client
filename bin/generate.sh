#!/bin/bash

BASE_DIR=`git rev-parse --show-toplevel`
PROTO_DIR="${BASE_DIR}/grpc/generator/src/main/proto"
GENERATED_DIR="${BASE_DIR}/grpc/generator/target/generated-sources/grpc"
TARGET_DIR="${BASE_DIR}/grpc/client/src/main/java"

PROTO_SHA=${1:-6bf58783fdc3ed33da39a728e2538c1cb58da34e}

pushd $BASE_DIR

echo "Updating proto files using $PROTO_SHA"
docker run --volume "$(pwd):/workspace" --workdir /workspace bufbuild/buf export buf.build/envoyproxy/protoc-gen-validate -o $PROTO_DIR
docker run --volume "$(pwd):/workspace" --workdir /workspace bufbuild/buf export buf.build/grpc-ecosystem/grpc-gateway -o $PROTO_DIR
docker run --volume "$(pwd):/workspace" --workdir /workspace bufbuild/buf export buf.build/authzed/api:${PROTO_SHA} -o $PROTO_DIR

echo "Generating gRPC client"
mvn clean package -Pgenerate -pl :quarkus-authzed-grpc-generator
echo "Removing existing gRPC client files"
rm -r $TARGET_DIR/com
rm -r $TARGET_DIR/grpc
rm -r $TARGET_DIR/io/envoyproxy
# We don't delete everything cause we need to retain io/quarkiverse for BearerToken
echo "Copying gRPC client"
cp -r $GENERATED_DIR/* $TARGET_DIR
echo "Format code"
mvn clean package -pl :quarkus-authzed-grpc-client
popd
