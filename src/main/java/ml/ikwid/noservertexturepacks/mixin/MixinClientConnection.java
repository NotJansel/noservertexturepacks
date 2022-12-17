package ml.ikwid.noservertexturepacks.mixin;

import net.minecraft.network.ClientConnection;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public abstract class MixinClientConnection {
    @Inject(method = "disconnect", at = @At("HEAD"), cancellable = true)
    private void cancelIfTextureDeclineType(Text disconnectReason, CallbackInfo ci) {
        if(disconnectReason.toString().contains("requiredTexturePrompt")) {
            ci.cancel(); // too lazy to mixin properly, so just cancel the disconnect if it matches the translation key
        }
    }
}
