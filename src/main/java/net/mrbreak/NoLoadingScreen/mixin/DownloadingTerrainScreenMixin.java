package net.mrbreak.NoLoadingScreen.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DownloadingTerrainScreen;
import net.minecraft.client.gui.screen.Screen;

import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(DownloadingTerrainScreen.class)
public class DownloadingTerrainScreenMixin extends Screen {
	private DownloadingTerrainScreenMixin(Text title) {
		super(title);
	}
	@Inject(method = "tick", at = @At("RETURN"))
	private void init(CallbackInfo callback) {
		MinecraftClient.getInstance().setScreen(null);
	}
}

