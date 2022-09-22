package com.lambda.modules

import com.lambda.NoChunkUnloadPlugin
import com.lambda.client.event.events.PacketEvent
import com.lambda.client.event.listener.listener
import com.lambda.client.module.Category
import com.lambda.client.plugin.api.PluginModule
import net.minecraft.network.play.server.SPacketUnloadChunk


internal object NoChunkUnloadModule : PluginModule(
    name = "NoChunkUnload",
    category = Category.PLAYER,
    description = "Cancels SPacketUnloadChunk",
    pluginMain = NoChunkUnloadPlugin
) {

    init {
        listener<PacketEvent.Receive> {
            when (it.packet) {
                is SPacketUnloadChunk -> if (isEnabled) it.cancel()
            }
        }
    }
        
}