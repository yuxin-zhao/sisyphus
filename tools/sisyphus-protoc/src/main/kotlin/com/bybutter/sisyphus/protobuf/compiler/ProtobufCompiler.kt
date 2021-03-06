package com.bybutter.sisyphus.protobuf.compiler

import com.bybutter.sisyphus.protobuf.compiler.core.state.FileGeneratingState
import com.bybutter.sisyphus.protobuf.compiler.core.state.advance
import com.google.protobuf.DescriptorProtos

class ProtobufCompiler(
    files: DescriptorProtos.FileDescriptorSet,
    packageShading: Map<String, String> = mapOf(),
    val generators: CodeGenerators = CodeGenerators()
) {
    val descriptorSet = FileDescriptorSet(files, packageShading).apply {
        resolve()
    }

    fun generate(file: String): ProtoCompileResult {
        val fileDescriptor = descriptorSet.files.firstOrNull { it.descriptor.name == file }
            ?: throw IllegalArgumentException("Proto file '$file' not imported.")
        val result = mutableListOf<GeneratedFile>()
        FileGeneratingState(this, fileDescriptor, result).advance()
        return ProtoCompileResult(fileDescriptor, result)
    }
}
