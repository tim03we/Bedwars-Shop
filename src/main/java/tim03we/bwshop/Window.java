package tim03we.bwshop;

import cn.nukkit.Player;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;

public class Window {

    private Player player;

    public Window(Player player) {
        this.player = player;
    }

    public void categories() {
        FormWindowSimple form = new FormWindowSimple(BWShop.config.getString("messages.form.categories.title"), " ");
        for (String s : BWShop.shop.getStringList("categories")) {
            String[] ex = s.split(":");
            form.addButton(new ElementButton(ex[0]));
        }
        player.showFormWindow(form);
    }

    public void subcategory(String category) {
        FormWindowSimple form = new FormWindowSimple(category, " ");
        for (String s : BWShop.shop.getStringList(category)) {
            String[] ex = s.split(":");
            form.addButton(new ElementButton(ex[0]));
        }
        player.showFormWindow(form);
    }
}
