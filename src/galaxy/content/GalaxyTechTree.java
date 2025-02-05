package galaxy.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static mindustry.content.Items.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import static galaxy.content.GalaxyBlocks.*;
import static galaxy.content.GalaxyItems.*;

public class GalaxyTechTree{
    static TechTree.TechNode context = null;
    
    public static void load() {
      margaNode(Conveyor, () -> {
        node(AConveyor, ()  -> {
          
        });
      });
    }
}