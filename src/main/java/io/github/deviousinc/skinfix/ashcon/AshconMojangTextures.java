package io.github.deviousinc.skinfix.ashcon;

public class AshconMojangTextures {
    public boolean custom;
    public boolean slim;
    public AshconTexture skin;
    public AshconTexture cape;
    public AschonRawTexture raw;

    public AshconMojangTextures() {

    }

    public AshconMojangTextures(boolean custom, boolean slim, AshconTexture skin, AschonRawTexture raw, AshconTexture cape) {
        this.custom = custom;
        this.slim = slim;
        this.skin = skin;
        this.raw = raw;
        this.cape = cape;
    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

    public boolean isSlim() {
        return slim;
    }

    public void setSlim(boolean slim) {
        this.slim = slim;
    }

    public AshconTexture getSkin() {
        return skin;
    }

    public void setSkin(AshconTexture skin) {
        this.skin = skin;
    }

    public AschonRawTexture getRaw() {
        return raw;
    }

    public void setRaw(AschonRawTexture raw) {
        this.raw = raw;
    }
}
