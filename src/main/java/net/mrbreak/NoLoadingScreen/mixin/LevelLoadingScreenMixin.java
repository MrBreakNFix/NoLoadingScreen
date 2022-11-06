package net.mrbreak.NoLoadingScreen.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.LevelLoadingScreen;
import net.minecraft.client.gui.screen.Screen;

import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(LevelLoadingScreen.class)
public class LevelLoadingScreenMixin extends Screen {
    private LevelLoadingScreenMixin(Text title) {
        super(title);
    }
    @Inject(method = "render", at = @At("RETURN"))
    private void init(CallbackInfo callback) {
        MinecraftClient.getInstance().setScreen(null);
    }
}

