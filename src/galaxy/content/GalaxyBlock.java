package galaxy.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.entities.pattern.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import galaxy.world.blocks.distribution.*;

import static galaxy.GalaxyUnivers.*;
import static galaxy.util.LibBlock.*;
import static mindustry.type.ItemStack.*;
@SuppressWarnings("deprecation")

public class GalaxyBlock{
    public static Block aconveyor;
    public static void load() {
      gconveryor = new Conveyor("Galaxy conveyor"){{
        requiments(Category.distribution, with(Items.galaxrium, 1, Items.tromium, 1, Items.metaglass, 4));
        health = 550;
        speed = 0.15f;
        displaySpeed 30f;
        
      }};
    }
}