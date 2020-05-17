tools

plugins {
    `java-library`
}

dependencies {
    implementation(project(":lib:sisyphus-protobuf"))
    implementation(project(":lib:sisyphus-grpc"))
    implementation(project(":lib:sisyphus-common"))
    implementation(Dependencies.Kotlin.Coroutines.reactor)
    implementation(Dependencies.Kotlin.Coroutines.guava)
    implementation(Dependencies.Proto.base)
    implementation(Dependencies.Kotlin.reflect)
    implementation(Dependencies.protoc)
    api(Dependencies.Kotlin.poet)
}
