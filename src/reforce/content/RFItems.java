package reforce.content;

import arc.*;
import arc.graphics.*;
import mindustry.*;
import reforce.graphics.*;
import reforce.type.item.*;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.meta.*;
import arc.Event.*;

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
                    Events.run(EventType.Trigger.update, ((AnimatedItem) i)::update);
                }
            }
        }
    }
}
