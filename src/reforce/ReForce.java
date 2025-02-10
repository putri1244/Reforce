package reforce;

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
import reforce.content.*;

public class ReForce extends Mod {
    @Override
    public void loadContent() {
        // Load konten mod
	RFBlock.load();
	RFItems.load();
  RFTechTree.load();

    }
}
