package galaxy;

import arc.*;
import arc.func.*;
import arc.struct.*;
import mindustry.*;
import mindustry.game.EventType.*;
import mindustry.game.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.net.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import galaxy.content.*;
import galaxy.world.block.distribution.*;

import static java.lang.Float.*;
import static mindustry.Vars.*;

public class GalaxyUnivers extends Mod{
    public static final String ghlink = "https://github.com/putri1244/Galaxy";
    public static final String shtname = " Galaxy God ";
    public GalaxyUnivers() {
      Events.on(WorldLoadEvent.class, e -> Team.sharded.cores().each(c -> {
            if(isNaN(c.health)) c.health = c.maxHealth;
      }));
      
    }
    @Override
    public void loadContent(){
        // GalaxyLiquids.load();
        GalaxyItems.load();
        GalaxyBlocks.load();
        //GalaxyTechTree.load();
        
    }
}