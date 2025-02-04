package galaxy.content;

import arc.*;
import arc.graphics.*;
import mindustry.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.type.*;

public class GalaxyItem {
    public static Item galaxrium;
    public static void load() {
      galaxrium = new Item("galaxrium", Color.valueOf("6c6bf27")){{
            explosiveness = 0.2f;
            hardness = 4;
            radioactivity = 1f;
            cost = 1.1f;
            healthScaling = 0.2f;
        }};
    }
}