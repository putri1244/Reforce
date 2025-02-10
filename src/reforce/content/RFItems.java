package reforce.content;

import arc.graphics.*;
import mindustry.*;
import reforce.graphics.*;
import reforce.type.item.*;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.meta.*;


public class RFItems {
    public static Item Rfrium;
    
    public static void load() {
        Rfrium = new AnimatedItem("Reforium", Color.valueOf("00ffff")) {{
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
