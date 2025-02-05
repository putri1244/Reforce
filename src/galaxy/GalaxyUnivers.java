package galaxy;

import mindustry.mod.Mod;
import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import galaxy.content.*;

public class GalaxyUnivers extends Mod {
    @Override
    public void loadContent() {
        // Load konten mod
	GalaxyBlock.load();
	GalaxyItems.load();
    GalaxyTechTree.load();

    }
}
