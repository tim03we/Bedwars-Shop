package tim03we.bwshop.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import tim03we.bwshop.BWShop;
import tim03we.bwshop.Window;

public class PlayerFormResponded implements Listener {

    private BWShop plugin;

    public PlayerFormResponded(BWShop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerFormResponded(PlayerFormRespondedEvent event) {
        Player player = event.getPlayer();
        if (event.getWindow() instanceof FormWindowSimple) {
            if(event.getResponse() == null) {
                return;
            }
            FormWindowSimple gui = (FormWindowSimple) event.getWindow();
            String responseName = gui.getResponse().getClickedButton().getText();
            if(gui.getTitle().equals(BWShop.config.getString("messages.form.categories.title"))) {
                new Window(player).subcategory(responseName);
            } else if(BWShop.shop.exists(gui.getTitle())) {
                for (String s : BWShop.shop.getStringList(gui.getTitle())) {
                    String[] ex = s.split(":");
                    if(ex[0].equals(responseName)) {
                        if(ex[4].equals("b")) {
                            if(player.getInventory().contains(Item.get(Item.BRICK, 0, Integer.parseInt(ex[5])))) {
                                if(player.getInventory().canAddItem(Item.get(Integer.parseInt(ex[1]), Integer.parseInt(ex[2]), Integer.parseInt(ex[3])))) {
                                    try {
                                        Item item = Item.get(Integer.parseInt(ex[1]), Integer.parseInt(ex[2]), Integer.parseInt(ex[3]));
                                        String[] ex2 = ex[6].split(",");
                                        for (String s2 : ex2) {
                                            String[] ex3 = s2.split("#");
                                            item.addEnchantment(Enchantment.get(Integer.parseInt(ex3[0])).setLevel(Integer.parseInt(ex3[1])));
                                        }
                                        player.getInventory().addItem(item);
                                    } catch(ArrayIndexOutOfBoundsException e) {
                                        player.getInventory().addItem(Item.get(Integer.parseInt(ex[1]), Integer.parseInt(ex[2]), Integer.parseInt(ex[3])));
                                    }
                                    player.getInventory().removeItem(Item.get(Item.BRICK, 0, Integer.parseInt(ex[5])));
                                } else player.sendMessage(BWShop.config.getString("messages.inv-full"));
                            } else player.sendMessage(BWShop.config.getString("messages.not-enough-bronze"));
                        } else if(ex[4].equals("i")) {
                            if(player.getInventory().contains(Item.get(Item.IRON_INGOT, 0, Integer.parseInt(ex[5])))) {
                                if(player.getInventory().canAddItem(Item.get(Integer.parseInt(ex[1]), Integer.parseInt(ex[2]), Integer.parseInt(ex[3])))) {
                                    try {
                                        Item item = Item.get(Integer.parseInt(ex[1]), Integer.parseInt(ex[2]), Integer.parseInt(ex[3]));
                                        String[] ex2 = ex[6].split(",");
                                        for (String s2 : ex2) {
                                            String[] ex3 = s2.split("#");
                                            item.addEnchantment(Enchantment.get(Integer.parseInt(ex3[0])).setLevel(Integer.parseInt(ex3[1])));
                                        }
                                        player.getInventory().addItem(item);
                                    } catch(ArrayIndexOutOfBoundsException e) {
                                        player.getInventory().addItem(Item.get(Integer.parseInt(ex[1]), Integer.parseInt(ex[2]), Integer.parseInt(ex[3])));
                                    }
                                    player.getInventory().removeItem(Item.get(Item.IRON_INGOT, 0, Integer.parseInt(ex[5])));
                                } else player.sendMessage(BWShop.config.getString("messages.inv-full"));
                            } else player.sendMessage(BWShop.config.getString("messages.not-enough-iron"));
                        } else if(ex[4].equals("g")) {
                            if(player.getInventory().contains(Item.get(Item.GOLD_INGOT, 0, Integer.parseInt(ex[5])))) {
                                if(player.getInventory().canAddItem(Item.get(Integer.parseInt(ex[1]), Integer.parseInt(ex[2]), Integer.parseInt(ex[3])))) {
                                    try {
                                        Item item = Item.get(Integer.parseInt(ex[1]), Integer.parseInt(ex[2]), Integer.parseInt(ex[3]));
                                        String[] ex2 = ex[6].split(",");
                                        for (String s2 : ex2) {
                                            String[] ex3 = s2.split("#");
                                            item.addEnchantment(Enchantment.get(Integer.parseInt(ex3[0])).setLevel(Integer.parseInt(ex3[1])));
                                        }
                                        player.getInventory().addItem(item);
                                    } catch(ArrayIndexOutOfBoundsException e) {
                                        player.getInventory().addItem(Item.get(Integer.parseInt(ex[1]), Integer.parseInt(ex[2]), Integer.parseInt(ex[3])));
                                    }
                                    player.getInventory().removeItem(Item.get(Item.GOLD_INGOT, 0, Integer.parseInt(ex[5])));
                                } else player.sendMessage(BWShop.config.getString("messages.inv-full"));
                            } else player.sendMessage(BWShop.config.getString("messages.not-enough-gold"));
                        }
                    }
                }
                if(BWShop.config.getBoolean("openLastWindow")) {
                    new Window(player).subcategory(gui.getTitle());
                }
            }
        }
    }
}
