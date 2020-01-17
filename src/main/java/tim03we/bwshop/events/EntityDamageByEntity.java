package tim03we.bwshop.events;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.passive.EntityVillager;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import tim03we.bwshop.Window;

public class EntityDamageByEntity implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        if(damager instanceof Player) {
            if(event.getEntity() instanceof EntityVillager) {
                new Window((Player) damager).categories();
                event.setCancelled(true);
            }
        }
    }
}
