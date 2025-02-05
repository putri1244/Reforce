package galaxy.content;

import arc.graphics.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.meta.*;

public class GalaxyItems {
    public static Item galaxrium;
    
    public static void load() {
        galaxrium = new Item("galaxrium", Color.valueOf("#cc45f6")) {{
            hardness = 2;
            cost = 1f;
            // Properties lain
        }};
    }
}
