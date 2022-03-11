package io.github.deviousinc.skinfix.mixin.entity;

import io.github.deviousinc.skinfix.SkinFixMod;
import io.github.deviousinc.skinfix.ashcon.AshconPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixin {
    @Shadow
    public String name;

    @Shadow
    public String playerCloakUrl;

    @Inject(method = "initCloak()V", at = @At("TAIL"))
    public void initCloak(CallbackInfo ci) {
        AshconPlayer ashconPlayer = SkinFixMod.requestSkinFor(this.name);
        if (ashconPlayer != null) {
            if (ashconPlayer.textures.skin != null) {
                Entity entity = ((Entity) (Object) this);
                entity.skinUrl = ashconPlayer.textures.skin.url;

            }
            if (ashconPlayer.textures.cape != null) {
                this.playerCloakUrl = ashconPlayer.textures.cape.url;
            } else {
                this.playerCloakUrl = "http://s3.amazonaws.com/MinecraftCloaks/" + this.name + ".png";
            }
        } else {
            this.playerCloakUrl = "http://s3.amazonaws.com/MinecraftCloaks/" + this.name + ".png";
        }
        ((Entity) (Object) this).cloakUrl = this.playerCloakUrl;
    }
}
