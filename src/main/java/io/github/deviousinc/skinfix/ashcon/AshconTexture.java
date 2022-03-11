package io.github.deviousinc.skinfix.ashcon;

public class AshconTexture {
    public String url;
    public String data;

    public AshconTexture() {

    }

    public AshconTexture(String url, String data) {
        this.url = url;
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
