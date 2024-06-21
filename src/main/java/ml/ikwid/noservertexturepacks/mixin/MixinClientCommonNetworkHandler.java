package ml.ikwid.noservertexturepacks.mixin;

import net.minecraft.client.network.ClientCommonNetworkHandler;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket;
import net.minecraft.network.packet.s2c.common.ResourcePackSendS2CPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClientCommonNetworkHandler.class)
public abstract class MixinClientCommonNetworkHandler {
    @Shadow @Final
    protected ClientConnection connection;

    /**
     * @author 6Times
     * @reason always say you accepted, even when you didn't
     */
    @Overwrite
    public void onResourcePackSend(ResourcePackSendS2CPacket packet) {
        this.connection.send(new ResourcePackStatusC2SPacket(packet.id(), ResourcePackStatusC2SPacket.Status.ACCEPTED)); // fun little thing called lying
        this.connection.send(new ResourcePackStatusC2SPacket(packet.id(), ResourcePackStatusC2SPacket.Status.SUCCESSFULLY_LOADED));
    }

}
