package io.github.deviousinc.skinfix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import io.github.deviousinc.skinfix.ashcon.AshconPlayer;
import io.github.deviousinc.skinfix.ashcon.AshconTexture;
import io.github.minecraftcursedlegacy.api.config.Configs;
import io.github.minecraftcursedlegacy.api.registry.Id;
import net.fabricmc.api.ModInitializer;
import tk.valoeghese.zoesteriaconfig.api.container.WritableConfig;
import tk.valoeghese.zoesteriaconfig.api.template.ConfigTemplate;

import javax.annotation.Nullable;

public class SkinFixMod implements ModInitializer {
	static Map<String, AshconPlayer> skinMap = new HashMap<>();

	@Override
	public void onInitialize() {

	}

	@Nullable
	public static AshconPlayer requestSkinFor(String username) {
		if (!skinMap.containsKey(username)) {
			try {
				URL url = new URL("https://api.ashcon.app/mojang/v2/user/" + username);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestProperty("accept", "application/json");
				InputStream responseStream = connection.getInputStream();
				Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8);
				AshconPlayer player = new Gson().fromJson(reader, AshconPlayer.class);
				skinMap.put(username, player);
				return player;
			} catch (Exception e) {
				return null;
			}
		} else {
			return skinMap.get(username);
		}
	}

}
