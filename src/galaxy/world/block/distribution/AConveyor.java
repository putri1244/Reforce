package galaxy.world.blocks.distribution;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.annotations.Annotations.*;
import mindustry.content.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.meta.*;

public class AConveyor extends Conveyor {
    public static final int ITEM_CAPACITY = 3;
    public float speed = 0.15f;
    public float displaySpeed = 30f;
    
    // Texture regions for animation
    public @Load(value = "@-#1-#2", lengths = {7, 4}) TextureRegion[][] regions;
    public @Load("@-edge") TextureRegion edgeRegion;
    public @Load("@-stack") TextureRegion stackRegion;

    public AConveyor(String name) {
        super(name);
        
        // Basic block properties
        rotate = true;
        update = true;
        group = BlockGroup.transportation;
        hasItems = true;
        itemCapacity = ITEM_CAPACITY;
        priority = TargetPriority.transport;
        
        // Advanced properties
        unloadable = false;
        solid = false;
        floating = true;
        conveyorPlacement = true;
        noUpdateDisabled = true;
        
        // Stats
        stats.add(Stat.itemsMoved, displaySpeed, StatUnit.itemsSecond);
        stats.add(Stat.powerUse, 0.5f, StatUnit.powerSecond);
    }

    @Override
    public void setStats() {
        super.setStats();
        stats.add(Stat.itemCapacity, ITEM_CAPACITY);
    }

    @Override
    public void setBars() {
        super.setBars();
        // Add custom capacity bar
        addBar("capacity", (AConveyorBuild entity) -> new Bar(
            () -> Core.bundle.format("bar.capacity", entity.items.total(), ITEM_CAPACITY),
            () -> Pal.items,
            () -> (float)entity.items.total() / ITEM_CAPACITY
        ));
    }

    public class AConveyorBuild extends ConveyorBuild {
        public float progress;
        public float animation;
        public int step;

        @Override
        public void updateTile() {
            if(items.total() > 0) {
                progress += speed * delta();
                animation = Mathf.approachDelta(animation, 1f, 0.08f);
            } else {
                animation = Mathf.approachDelta(animation, 0f, 0.08f);
            }

            // Move items forward
            if(progress >= 1f) {
                progress %= 1f;
                step++;

                Building next = getNext();
                if(next != null && items.total() > 0) {
                    Item item = items.first();
                    if(next.acceptItem(this, item)) {
                        items.remove(item, 1);
                        next.handleItem(this, item);
                        moved(item);
                    }
                }
            }
        }

        @Override
        public void draw() {
            super.draw();
            
            // Draw item movement animation
            if(items.total() > 0) {
                float rotation = rotdeg();
                float itemx = x + Angles.trnsx(rotation, progress * 8f);
                float itemy = y + Angles.trnsy(rotation, progress * 8f);
                
                // Draw items
                for(int i = 0; i < Math.min(items.total(), ITEM_CAPACITY); i++) {
                    Item item = items.get(i);
                    Draw.rect(item.fullIcon,
                        itemx + Angles.trnsx(rotation, i * 3f),
                        itemy + Angles.trnsy(rotation, i * 3f),
                        itemSize, itemSize);
                }
                
                // Draw stack indicator if needed
                if(items.total() > 1) {
                    Draw.color(Pal.accent);
                    Draw.rect(stackRegion, itemx, itemy, rotation);
                    Draw.color();
                }
            }
            
            // Draw edge connection
            for(int i = 0; i < 4; i++) {
                if(nearby[i] instanceof AConveyorBuild) {
                    Draw.rect(edgeRegion, x, y, i * 90);
                }
            }
        }

        @Override
        public boolean acceptItem(Building source, Item item) {
            return items.total() < ITEM_CAPACITY && 
                   (source == this || source.block instanceof AConveyor || 
                    source.relativeTo(this) == rotation);
        }

        protected void moved(Item item) {
            // Effect when item moves
            if(Mathf.chance(0.1)) {
                Effect.create(Fx.itemTransfer, x, y, 0, item.color);
            }
        }
    }
}