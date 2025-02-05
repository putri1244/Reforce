package galaxy;

import arc.*;
import arc.func.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.EventType.*;
import mindustry.game.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.net.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.gen.*;
import galaxy.content.*;
import galaxy.world.block.distribution.*;
import static java.lang.Float.*;
import static mindustry.Vars.*;

public class GalaxyUnivers extends Mod {
    public static final String ghlink = "https://github.com/putri1244/Galaxy";
    public static final String shtname = "Galaxy God";
    
    // Mod metadata
    public static final String MOD_NAME = "Galaxy Universe";
    public static final String MOD_AUTHOR = "Putri";
    public static final String MOD_VERSION = "1.0";
    
    // Mod instance
    public static GalaxyUnivers instance;
    
    public GalaxyUnivers() {
        instance = this;
        
        // Fix NaN health values on core load
        Events.on(WorldLoadEvent.class, e -> Team.sharded.cores().each(core -> {
            if (isNaN(core.health)) {
                core.health = core.maxHealth;
            }
        }));
        
        // Add resource multiplier event
        Events.on(BlockBuildEndEvent.class, e -> {
            if (e.tile.build != null && e.tile.team() == Team.sharded) {
                handleBlockBuild(e.tile.build);
            }
        });
        
        // Add mod loaded logging
        Events.on(ClientLoadEvent.class, e -> {
            Log.info("Mod [accent]" + MOD_NAME + "[] has been loaded successfully.");
        });
    }

    @Override
    public void init() {
        // Add mod info
        Log.info("Initializing " + MOD_NAME + " v" + MOD_VERSION);
        
        // Register additional listeners
        registerListeners();
    }
    
    @Override
    public void loadContent() {
        try {
            Log.info("Loading Galaxy content...");
            
            // Load mod content in correct order
            // GalaxyLiquids.load();
            GalaxyItems.load();
            GalaxyBlocks.load();
            // GalaxyTechTree.load();
            
            Log.info("Galaxy content loaded successfully.");
        } catch (Exception e) {
            Log.err("Failed to load Galaxy content", e);
        }
    }
    
    private void registerListeners() {
        // Add game rule changes
        Events.on(GameRules.class, e -> {
            // Modify game rules if needed
            state.rules.infiniteResources = false;
            state.rules.unitCap = 100;
        });
        
        // Add custom block destroy handling
        Events.on(BlockDestroyEvent.class, e -> {
            if (e.tile.build != null) {
                handleBlockDestroy(e.tile.build);
            }
        });
    }
    
    private void handleBlockBuild(Building build) {
        // Add custom logic for when blocks are built
        if (build.block.hasItems) {
            // Increase item capacity for storage blocks
            build.block.itemCapacity *= 1.5f;
        }
        
        if (build.block.hasPower) {
            // Modify power generation/consumption
            build.block.consumePower(build.block.consumesPower ? 1.2f : 0.8f);
        }
    }
    
    private void handleBlockDestroy(Building build) {
        // Add custom logic for when blocks are destroyed
        if (build.block.hasItems && build.items != null) {
            // Drop some items when block is destroyed
            build.items.each((item, amount) -> {
                Effects.effect(Fx.explosion, build.x, build.y);
                Call.transferItemTo(item, amount / 2, build.x, build.y, null);
            });
        }
    }
}