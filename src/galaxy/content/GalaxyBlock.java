package galaxy.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import galaxy.world.block.distribution.*;
import arc.struct.*;
import arc.util.*;
import mindustry.world.block.distribution.*;
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
import static galaxy.GalaxyUnivers.*;
import static mindustry.type.ItemStack.*;

@SuppressWarnings("deprecation")
public class GalaxyBlocks {
    // Conveyor blocks
    public static Block AConveyor;
    
    public static void load() {
        // Initialize conveyor
        AConveyor = new Conveyor("galaxy-conveyor"){{
            requirements(Category.distribution, with(
                Items.galaxrium, 1,
                Items.thorium, 1,
                Items.metaglass, 4
            ));
            
            // Basic properties
            health = 550;
            speed = 0.15f;
            displayedSpeed = 30f;
            
            // Additional properties
            buildCostMultiplier = 0.5f;
            floating = true;
            hasShadow = true;
            
            // Visual settings
            drawer = new DrawBlock() {
                @Override
                public void draw(Building build) {
                    super.draw(build);
                    
                    // Add custom glow effect
                    Draw.color(Color.valueOf("7382f0"));
                    Draw.alpha(0.6f + Mathf.absin(Time.time, 8f, 0.3f));
                    Draw.rect(build.block.region, build.x, build.y);
                    Draw.reset();
                }
            };
            
            // Update effects
            updateEffect = new Effect(20f, e -> {
                Draw.color(Color.valueOf("7382f0"));
                Lines.stroke(e.fout() * 1f);
                Lines.circle(e.x, e.y, e.fin() * 4f);
            });
            
            // Custom behavior
            update = true;
            configurable = true;
            
            // Add custom update logic
            updateTile = building -> {
                if(building instanceof ConveyorBuild conv){
                    // Boost speed when powered
                    if(conv.power != null && conv.power.status > 0.5f){
                        conv.speed *= 1.5f;
                    }
                    
                    // Special effect when carrying items
                    if(conv.items != null && conv.items.total() > 0){
                        if(Mathf.chance(0.02)){
                            Effect.shake(1f, 1f, conv.x, conv.y);
                            updateEffect.at(conv.x, conv.y);
                        }
                    }
                }
            };
        }};
        
        // Initialize container
        /*
        galaxyContainer = new StorageBlock("galaxy-container"){{
            requirements(Category.distribution, with(
                Items.galaxrium, 50,
                Items.thorium, 30,
                Items.metaglass, 20
            ));
            
            size = 2;
            health = 800;
            itemCapacity = 1000;
            coreMerge = true;
            hasItems = true;
        }};
        
        // Initialize drill
        galaxyDrill = new Drill("galaxy-drill"){{
            requirements(Category.production, with(
                Items.galaxrium, 35,
                Items.thorium, 25,
                Items.metaglass, 15
            ));
            
            size = 2;
            health = 600;
            drillTime = 250f;
            tier = 5;
            updateEffect = Fx.pulverizeSmall;
            drillEffect = Fx.mineBig;
            
            // Custom attributes
            hasPower = true;
            consumePower(2f);
            hasLiquids = true;
            hasItems = true;
            floating = true;
        }};
        */
    }
}