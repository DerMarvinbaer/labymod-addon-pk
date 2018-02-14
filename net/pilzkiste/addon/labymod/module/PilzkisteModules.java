package net.pilzkiste.addon.labymod.module;

import com.google.gson.JsonObject;
import net.labymod.api.events.TabListEvent;
import net.labymod.ingamegui.moduletypes.ColoredTextModule;
import net.labymod.servermanager.ChatDisplayAction;
import net.labymod.servermanager.Server;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.pilzkiste.addon.labymod.Main;
import org.lwjgl.Sys;

import java.util.Collections;
import java.util.List;

public class PilzkisteModules extends Server {

    public static String nickname = "Error";
    private String points = "-9999999";
    private String killstreak = "-5";
    private String level = "-5";

    public PilzkisteModules() {
        super("pilzkiste", "pilzkiste.net", "franzcraft.net", "pilzkiste.de", "pilzkiste.eu");
    }

    @Override
    public void onJoin(final ServerData serverData) {

    }

    @Override
    public ChatDisplayAction handleChatMessage(final String s, final String s1) throws Exception {
        return null;
    }


    @Override
    public void handlePluginMessage(final String channelName, final PacketBuffer packetBuffer) throws Exception {
        if(channelName.equals("nickName")) {
            nickname = new String(packetBuffer.array());
        }

        if(channelName.equals("kBattle_points")) {
            points = new String(packetBuffer.array());
        }

        if(channelName.equals("kFFA_killstreak")) {
            killstreak = new String(packetBuffer.array());
        }

        if(channelName.equals("reBuild_level")) {
            level = new String(packetBuffer.array());
        }
    }

    @Override
    public void handleTabInfoMessage(final TabListEvent.Type type, final String s, final String s1) throws Exception {

    }

    @Override
    protected void initConfig(JsonObject config) {
    }

    @Override
    public void fillSubSettings(final List<SettingsElement> list) {

    }

    @Override
    public void addModuleLines( List<DisplayLine> lines ) {

        if(Main.nickname) {
            if(!nickname.equals("Error")) {
                DisplayLine dl = new DisplayLine( "Nick", Collections.singletonList(ColoredTextModule.Text.getText(nickname)));
                lines.add(dl);
            }
        }

        if(Main.knockbattle) {
            if(!points.equals("-9999999")) {
                DisplayLine dl = new DisplayLine( "Punkte", Collections.singletonList(ColoredTextModule.Text.getText(String.valueOf(points))));
                lines.add(dl);              
            }
        }

        if(Main.knockffa) {
            if(!killstreak.equals("-5")) {
                DisplayLine dl = new DisplayLine( "Killstreak", Collections.singletonList(ColoredTextModule.Text.getText(String.valueOf(killstreak))));
                lines.add(dl);
            }
        }

        if(Main.rebuild) {
            if(!level.equals("-5")) {
                DisplayLine dl = new DisplayLine( "Level", Collections.singletonList(ColoredTextModule.Text.getText(String.valueOf(level))));
                lines.add(dl);
            }
        }

        super.addModuleLines(lines);
    }

}
