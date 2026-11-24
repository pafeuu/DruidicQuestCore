package net.pafeuu.DruidicQuestMod.registries;



import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;

import java.util.function.Consumer;

public class FluidRegistry {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, DruidicQuestMod.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, DruidicQuestMod.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DruidicQuestMod.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DruidicQuestMod.MODID);

    public static final RegistryObject<Item> LIQUID_COAL_ESSENCE_BUCKET =
            ITEMS.register("liquid_coal_essence_bucket", () -> new BucketItem(FluidRegistry.LIQUID_COAL_ESSENCE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<LiquidBlock> COAL_ESSENCE =
            BLOCKS.register("liquid_coal_essence",
                    ()-> new LiquidBlock(FluidRegistry.LIQUID_COAL_ESSENCE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<FluidType> LIQUID_COAL_ESSENCE_TYPE = FLUID_TYPES.register(
            "liquid_coal_essence",
            () -> new FluidType(FluidType.Properties.create()
                    .density(1500)
                    .viscosity(2000)
                    .temperature(300)
                    .lightLevel(10)
                    .canConvertToSource(false)) {
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    consumer.accept(new IClientFluidTypeExtensions() {
                        private static final ResourceLocation STILL   = new ResourceLocation("minecraft", "block/water_still");
                        private static final ResourceLocation FLOWING = new ResourceLocation("minecraft", "block/water_flow");

                        @Override public ResourceLocation getStillTexture()   { return STILL; }
                        @Override public ResourceLocation getFlowingTexture() { return FLOWING; }
                        @Override public int getTintColor()                   { return 0x2A2A2A; }
                    });
                }
            });

    public static final RegistryObject<FlowingFluid> LIQUID_COAL_ESSENCE =
            FLUIDS.register("liquid_coal_essence",
                    () -> new ForgeFlowingFluid.Source(FluidRegistry.LIQUID_COAL_ESSENCE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_LIQUID_COAL_ESSENCE =
            FLUIDS.register("flowing_liquid_coal_essence",
                    () -> new ForgeFlowingFluid.Flowing(FluidRegistry.LIQUID_COAL_ESSENCE_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIQUID_COAL_ESSENCE_PROPERTIES = new ForgeFlowingFluid.Properties(
            LIQUID_COAL_ESSENCE_TYPE, LIQUID_COAL_ESSENCE, FLOWING_LIQUID_COAL_ESSENCE)
            .explosionResistance(100f)
            .block(COAL_ESSENCE).bucket(LIQUID_COAL_ESSENCE_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        FLUIDS.register(eventBus);
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }

    /*@Mod.EventBusSubscriber(modid = DruidicQuestMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientRegistryEvents {
        @SubscribeEvent
        public static void registerFluids(FMLCommonSetupEvent event) {
            Supplier<IForgeRegistry<FluidType>> fluidTypes = ForgeRegistries.FLUID_TYPES;
            for (FluidType fluidType : fluidTypes.get()) {
                addCobblestoneInteraction(MUNDANE_BREW_TYPE.get(), fluidType);
            }
        }

        @SubscribeEvent
        public static void registerFluidsClient(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(MUNDANE_BREW.get(), RenderType.translucent());
        }
    }*/

    public static void addCobblestoneInteraction(FluidType source, FluidType fluidType) {
        if (!fluidType.equals(source)) {
            FluidInteractionRegistry.addInteraction(fluidType, new FluidInteractionRegistry.InteractionInformation(
                    source,
                    fluidState -> Blocks.COBBLESTONE.defaultBlockState()
            ));
        }
    }



}