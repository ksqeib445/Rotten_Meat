package fun.ksmc.playextend.rottenmeat;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    FileConfiguration config;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        config=getConfig();
        init();
    }

    public void init() {
        config.getStringList("madelist").forEach(s -> {
            String[] sp=s.split("--");
            Material input = Material.valueOf(sp[0]);
            Material out= Material.valueOf(sp[1]);
            FurnaceRecipe recipe = new FurnaceRecipe(new ItemStack(out), input);
            //创建(熔炉)配方
            recipe.setInput(input);
            recipe.setExperience(Float.parseFloat(sp[2]));
            //加入魔法配方
            getServer().addRecipe(recipe);
        });
    }
}
