package io.github.deviousinc.skinfix.mixin.entity;

import io.github.deviousinc.skinfix.SkinFixMod;
import io.github.deviousinc.skinfix.ashcon.AshconPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.Session;
import net.minecraft.entity.player.AbstractClientPlayer;
import net.minecraft.entity.player.Player;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractClientPlayer.class)

public class AbstractClientPlayerMixin {
    @Inject(method = "<init>(Lnet/minecraft/client/Minecraft;Lnet/minecraft/level/Level;Lnet/minecraft/client/util/Session;I)V", at = @At("TAIL"))
    public void init(Minecraft minecraft, Level level, Session session, int i, CallbackInfo ci) {
        AshconPlayer ashconPlayer = SkinFixMod.requestSkinFor(session.username);
        if (ashconPlayer != null) {
            ((Player) (Object) this).skinUrl = ashconPlayer.textures.skin.url;
        }
    }
}
