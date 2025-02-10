package reforce.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

public class RFBlock {
    public static Block RFBlocks, otherBlock;
    // Tambahkan block baru
    
    public static void load() {
        RFBlocks = new Block("RFBlock") {{
            health = 3000;
            size = 1;
            requirements(Category.defense, ItemStack.with(
                Items.copper, 30
            ));
        }};
        
        otherBlock = new Block("otherBlock") {{  // Definisikan block baru
            health = 150;
            size = 2;
            requirements(Category.defense, ItemStack.with(
                Items.copper, 50
            ));
        }};
    }
}
