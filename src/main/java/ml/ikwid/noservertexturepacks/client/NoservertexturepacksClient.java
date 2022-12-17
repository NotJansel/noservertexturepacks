package ml.ikwid.noservertexturepacks.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Environment(EnvType.CLIENT)
public class NoservertexturepacksClient implements ClientModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("noservertexturepacks");
    @Override
    public void onInitializeClient() {
        LOGGER.info("no server texture packs time");
    }
}
