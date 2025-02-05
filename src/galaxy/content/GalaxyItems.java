package galaxy.content;

import arc.*;
import arc.graphics.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.meta.*;

public class GalaxyItems {
  
    public static Item galaxrium, starDust, cosmicAlloy;
    
    public static void load() {
        galaxrium = new Item("galaxrium", Color.valueOf("6c6bf2")) {{
            // Basic properties
            explosiveness = 0.2f;
            hardness = 4f;
            radioactivity = 1f;
            charge = 0.5f;
            cost = 1.1f;
            healthScaling = 0.2f;
            
            // Additional properties
            flammability = 0.1f;
            alwaysUnlocked = false;
            
            // Visual settings
            color = Color.valueOf("6c6bf2");
            lightColor = Color.valueOf("8f8fff");
            
            // Stats
            stats.add(Stat.explosiveness, explosiveness * 100f, StatUnit.percent);
            stats.add(Stat.radioactivity, radioactivity * 100f, StatUnit.percent);
            stats.add(Stat.charge, charge * 100f, StatUnit.percent);
            
            // Effects when destroyed
            destroyEffect = new Effect(30f, e -> {
                Draw.color(color);
                Lines.stroke(e.fout() * 2f);
                Lines.circle(e.x, e.y, e.fin() * 10f);
                
                Draw.color(lightColor);
                for(int i = 0; i < 4; i++){
                    float ang = i * 90f + e.rotation;
                    Lines.lineAngle(e.x, e.y, ang, e.fout() * 8f);
                }
            });
        }};

        starDust = new Item("star-dust", Color.valueOf("fff0c5")) {{
            explosiveness = 0f;
            hardness = 2f;
            radioactivity = 0.5f;
            cost = 0.8f;
            
        }};

        cosmicAlloy = new Item("cosmic-alloy", Color.valueOf("9c7ae5")) {{
            explosiveness = 0.1f;
            hardness = 6f;
            radioactivity = 0.8f;
            cost = 2f;
            
        }};
    }
    
    // Utility method to check if an item is a Galaxy mod item
    public static boolean isGalaxyItem(Item item) {
        return item == galaxrium || item == starDust || item == cosmicAlloy;
    }
    
    // Get crafting cost multiplier for Galaxy items
    public static float getCraftingCostMultiplier(Item item) {
        if (!isGalaxyItem(item)) return 1f;
        
        return switch(item.name) {
            case "galaxrium" -> 1.2f;
            case "star-dust" -> 0.9f;
            case "cosmic-alloy" -> 1.5f;
            default -> 1f;
        };
    }
}