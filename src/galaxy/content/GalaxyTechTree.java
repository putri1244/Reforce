package betamindy.content;

import arc.struct.*;
import betamindy.util.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static mindustry.content.Items.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import static galaxy.content.MindyBlocks.*;
import static galaxy.content.MindyItems.*;

public class GalaxyTechTree{
    static TechTree.TechNode context = null;
    public static void load() {
      margeNode(conveyor, () -> {
          node(aconfeyor, () -> {
            
          });
      });
    }
}
