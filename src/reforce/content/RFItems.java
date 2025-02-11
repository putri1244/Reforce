package reforce.content;

import arc.*;
import arc.graphics.*;
import mindustry.*;
import mindustry.core.*;
import reforce.graphics.*;
import reforce.type.item.*;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.meta.*;

public class RFItems {
    public static Item Reforium;
    
    public static void load() {
        Reforium = new AnimatedItem("Reforiums", Color.valueOf("00ffff")) {{
            hardness = 15;
            cost = 0.1f;
            charge = 10.24f;
            radioactivity = 10.24f;
            transition = 5;
            animDelay = 4f;
            // Properties lain
         }};
         if(!Vars.headless){
   	    for(Item i : Vars.content.items()){
             if(i instanceof AnimatedItem){
             Time.run(0f, () -> ((AnimatedItem) i).update());
        }
    }
}
    }
}
