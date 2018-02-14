package net.pilzkiste.addon.labymod;

import net.labymod.api.LabyModAddon;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;
import net.pilzkiste.addon.labymod.module.PilzkisteModules;

import java.util.List;

public class Main extends LabyModAddon {

    /*
        This Addon is for the Minecraft-Server Pilzkiste.net
        All rights reserved
     */

    public static boolean knockbattle;
    public static boolean knockffa;
    public static boolean rebuild;
    public static boolean nickname;

    @Override
    public void onEnable() {
        System.out.print("Enabled Pilzkiste Addon");
        this.getApi().registerServerSupport(this, new PilzkisteModules());
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void loadConfig() {
        knockbattle = getConfig().has( "enabledKnockBattle" ) ? getConfig().get( "enabledKnockBattle" ).getAsBoolean() : true;
        knockffa = getConfig().has( "enabledKnockFFA" ) ? getConfig().get( "enabledKnockFFA" ).getAsBoolean() : true;
        rebuild = getConfig().has( "enabledRebuild" ) ? getConfig().get( "enabledRebuild" ).getAsBoolean() : true;
        nickname = getConfig().has( "enabledNickname" ) ? getConfig().get( "enabledNickname" ).getAsBoolean() : true;
    }


    @Override
    protected void fillSettings(final List<SettingsElement> list) {
        list.add( new BooleanElement("Enabled KnockBattle Feature", this, new ControlElement.IconData(Material.DIAMOND_HELMET), "enabledKnockBattle", this.knockbattle) );
        list.add( new BooleanElement("Enabled KnockFFA Feature", this, new ControlElement.IconData(Material.STICK), "enabledKnockFFA", this.knockffa) );
        list.add( new BooleanElement("Enabled Rebuild Feature", this, new ControlElement.IconData(Material.GRASS), "enabledRebuild", this.rebuild) );
        list.add( new BooleanElement( "Enabled Nickname", this, new ControlElement.IconData(Material.NAME_TAG), "enabledNickname", this.nickname));
    }

}
