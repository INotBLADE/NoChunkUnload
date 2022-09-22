package com.lambda

import com.lambda.client.plugin.api.Plugin
import com.lambda.modules.NoChunkUnloadModule

internal object NoChunkUnloadPlugin : Plugin() {

    override fun onLoad() {
        modules.add(NoChunkUnloadModule)
    }

    override fun onUnload() {
    }
}