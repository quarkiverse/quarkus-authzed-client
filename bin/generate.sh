#!/usr/bin/env bash
set -e

BASE_DIR=`git rev-parse --show-toplevel`
PROTO_DIR="${BASE_DIR}/grpc/generator/src/main/proto"
PROTO_DIR_IN_DOCKER="/workspace/grpc/generator/src/main/proto"
GENERATED_DIR="${BASE_DIR}/grpc/generator/target/generated-sources/grpc"
TARGET_DIR="${BASE_DIR}/grpc/client/src/main/java"

# https://buf.build/authzed/api/activity/commit/v1.30.0
PROTO_SHA=${1:-63d28145265446828dc8270d04472ea8}

pushd $BASE_DIR

echo "Updating proto files using $PROTO_SHA"
rm -rf $PROTO_DIR
mkdir -p $PROTO_DIR

docker run --volume "$(pwd):/workspace" --workdir /workspace bufbuild/buf export buf.build/envoyproxy/protoc-gen-validate -o $PROTO_DIR_IN_DOCKER
docker run --volume "$(pwd):/workspace" --workdir /workspace bufbuild/buf export buf.build/grpc-ecosystem/grpc-gateway -o $PROTO_DIR_IN_DOCKER
docker run --volume "$(pwd):/workspace" --workdir /workspace bufbuild/buf export buf.build/authzed/api:${PROTO_SHA} -o $PROTO_DIR_IN_DOCKER

# Need to put _ between watch and resources due to MacOS case sensitive, else maven will fail
sudo mv $PROTO_DIR/authzed/api/v1alpha1/watchresources_service.proto $PROTO_DIR/authzed/api/v1alpha1/watch_resources_service.proto

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
