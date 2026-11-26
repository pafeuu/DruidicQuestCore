package net.pafeuu.DruidicQuestMod.mixin;

import net.minecraftforge.fml.loading.LoadingModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class DruidicQuestModMixinPlugin implements IMixinConfigPlugin {
    private boolean isSophisticatedItemActionsLoaded = false;
    private boolean isQuarkLoaded = false;
    private boolean isEnigmaticLegacyLoaded = false;
    private boolean isArsNouveauLoaded = false;
    private boolean isEnchantmentLimiterLoaded = false;

    @Override
    public void onLoad(String s) {
        this.isSophisticatedItemActionsLoaded = LoadingModList.get().getModFileById("sophisticateditemactions") != null;
        this.isQuarkLoaded = LoadingModList.get().getModFileById("quark") != null;
        this.isEnigmaticLegacyLoaded = LoadingModList.get().getModFileById("enigmaticlegacy") != null;
        this.isArsNouveauLoaded = LoadingModList.get().getModFileById("ars_nouveau") != null;
        this.isEnchantmentLimiterLoaded = LoadingModList.get().getModFileById("enchantlimiter") != null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.contains("GateDepositOrExtractMixin"))
            return isSophisticatedItemActionsLoaded;
        if (mixinClassName.contains("ItemBaseCurioMixin"))
            return isEnigmaticLegacyLoaded;
        if (mixinClassName.contains("AttributeTooltipsMixin"))
            return isQuarkLoaded;
        if (mixinClassName.contains("EnchantingApparatusTileMixin"))
            return isEnchantmentLimiterLoaded && isArsNouveauLoaded;
        return true;
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {
    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {
    }
}