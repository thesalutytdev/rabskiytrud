package org.thesalutyt.dedaebutrabi.common.events.server;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import org.thesalutyt.dedaebutrabi.Rabskiytrud;

@Mod.EventBusSubscriber(
        modid = Rabskiytrud.MODID,
        value = Dist.DEDICATED_SERVER
)
public class ServerEvents {

    @Mod.EventBusSubscriber(
            modid = Rabskiytrud.MODID,
            bus = Mod.EventBusSubscriber.Bus.MOD,
            value = Dist.DEDICATED_SERVER
    )
    public static class ServerBusEvents {}
}
