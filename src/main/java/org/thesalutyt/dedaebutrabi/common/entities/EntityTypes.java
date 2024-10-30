package org.thesalutyt.dedaebutrabi.common.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.thesalutyt.dedaebutrabi.Rabskiytrud;
import org.thesalutyt.dedaebutrabi.common.entities.sit.SitEntity;

public class EntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
            Rabskiytrud.MODID);
    public static final RegistryObject<EntityType<SitEntity>> SIT_ENTITY_TYPE = ENTITY_TYPES
            .register("entity_sit", () ->
                    EntityType.Builder.<SitEntity>of(SitEntity::new, MobCategory.MISC)
            .setTrackingRange(256)
            .setUpdateInterval(20)
            .sized(0.0001F, 0.0001F)
            .build(Rabskiytrud.MODID + ":entity_sit")
            );
}
