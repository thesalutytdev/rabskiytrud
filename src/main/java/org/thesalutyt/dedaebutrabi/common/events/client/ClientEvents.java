package org.thesalutyt.dedaebutrabi.common.events.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import org.thesalutyt.dedaebutrabi.Rabskiytrud;

@Mod.EventBusSubscriber(
        modid = Rabskiytrud.MODID,
        value = Dist.CLIENT
)
public class ClientEvents {

    @Mod.EventBusSubscriber(
            modid = Rabskiytrud.MODID,
            bus = Mod.EventBusSubscriber.Bus.MOD,
            value = Dist.CLIENT
    )
    public static class ClientBusEvents {}
}
