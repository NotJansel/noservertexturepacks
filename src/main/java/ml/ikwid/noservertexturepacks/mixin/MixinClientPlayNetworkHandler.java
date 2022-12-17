package ml.ikwid.noservertexturepacks.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.c2s.play.ResourcePackStatusC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class MixinClientPlayNetworkHandler {
    @Shadow @Final private ClientConnection connection;

    /**
     * @author 6Times
     * @reason always say you accepted, even when you didn't
     */
    @Overwrite
    private void sendResourcePackStatus(ResourcePackStatusC2SPacket.Status packStatus) {
        this.connection.send(new ResourcePackStatusC2SPacket(ResourcePackStatusC2SPacket.Status.ACCEPTED)); // fun little thing called lying
    }
}
