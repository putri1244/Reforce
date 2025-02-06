package galaxy.content;

import arc.graphics.*;
import mindustry.*;
import galaxy.graphics.*;
import galaxy.type.item.*;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.meta.*;


public class GalaxyItems {
    public static Item galaxrium;
    
    public static void load() {
        galaxrium = new AnimatedItem("galaxrium", Color.valueOf("00ffff")) {{
            hardness = 15;
            cost = 0.1f;
            charge = 10.24f;
            radioactivity = 10.24f;
            transition = 5;
            animDelay = 4f;
            // Properties lain
        }};
    }
}
