package io.github.deviousinc.skinfix.ashcon;

public class AshconPlayer {
    public String uuid;
    public String username;
    public AshconUsernameHistory[] username_history;
    public AshconMojangTextures textures;
    public String created_at;

    public AshconPlayer() {

    }

    public AshconPlayer(String uuid, String username, AshconUsernameHistory[] username_history, AshconMojangTextures textures, String created_at) {
        this.uuid = uuid;
        this.username = username;
        this.username_history = username_history;
        this.textures = textures;
        this.created_at = created_at;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AshconUsernameHistory[] getUsername_history() {
        return username_history;
    }

    public void setUsername_history(AshconUsernameHistory[] username_history) {
        this.username_history = username_history;
    }

    public AshconMojangTextures getTextures() {
        return textures;
    }

    public void setTextures(AshconMojangTextures textures) {
        this.textures = textures;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
