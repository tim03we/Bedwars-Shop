package tim03we.bwshop;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import tim03we.bwshop.events.EntityDamageByEntity;
import tim03we.bwshop.events.PlayerFormResponded;

public class BWShop extends PluginBase {

    public static Config config;
    public static Config shop;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerFormResponded(this), this);
        getServer().getPluginManager().registerEvents(new EntityDamageByEntity(), this);
        init();
    }

    private void init() {
        saveDefaultConfig();
        saveResource("shop.yml");
        config = getConfig();
        shop = new Config(getDataFolder() + "/shop.yml", Config.YAML);
    }
}
