package galaxy;

import arc.*;
import arc.func.*;
import arc.stuct.*;
import mindustry.*;
import mindustry.game.EventType.*;
import mindustry.game.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.net.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;

import static java.lang.Float.*;
import static mindustry.Vars.*;

public class GalaxyUnivers extends Mod{
    public static final String ghlink = "https://github.com/putri1244/Galaxy";
    public static final String shtname = " Galaxy God ";
    public static Seq<Block> visibleBlockList = new Seq<Block>();
    public static boolean uwu = OS.username.equals("sunny") || OS.username.equals("anuke") || OS.username.equals("feeli");
    
    public GalaxyUnivers() {
      musics.init();
      Log.info(OS.username);
      Events.on(WorldLoadEvent.class, e -> Team.sharded.cores().each(c -> {
            if(isNaN(c.health)) c.health = c.maxHealth;
      }));
      
    }
    @Override
    public void loadContent(){
        GalaxyLiquids.load();
        GalaxyItems.load();
        GalaxyBlocks.load();
        GalaxyTechTree.load();
        
    }
}