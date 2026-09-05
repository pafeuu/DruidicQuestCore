package net.pafeuu.DruidicQuestMod.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;

public class ModTags {

    public static class Items {
        public static final TagKey<Item> RUNE_ITEM = tag("rune_item");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DruidicQuestMod.MODID, name));
        }
    }

    public static class Blocks {
//        public static final TagKey<Block> PLACEHOLDER = tag("placeholder");


        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DruidicQuestMod.MODID, name));
        }
    }

    public static class Entities {
//        public static final TagKey<EntityType<?>> PLACEHOLDER = tag("placeholder");

        private static TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(DruidicQuestMod.MODID, name));
        }
    }
}
