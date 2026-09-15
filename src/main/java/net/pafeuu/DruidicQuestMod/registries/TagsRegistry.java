package net.pafeuu.DruidicQuestMod.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;


public class TagsRegistry {

    public static class Blocks {
        public static final TagKey<Block>  TERRA_PLATE_BASE_ALT = tag("terra_plate_base_alt");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(DruidicQuestMod.MODID,name));
        }
    }

}
