package galaxy.world.blocks.distribution;

import arc.graphics.g2d.*;
import mindustry.content.*;
import mindustry.world.*;
import mindustry.world.blocks.*;

public class aconfeyor extends Block {
    private static final int capacity = 3;
    public float speed = 0f; // Kecepatan lebih tinggi dari titanium conveyor

    public @Load(value = "@-#1-#2", lengths = {7, 4}) TextureRegion[][] regions;

    public GalaxyConveyor(String name) {
        super(name);
        rotate = true;
        update = true;
        group = BlockGroup.transportation;
        hasItems = true;
        itemCapacity = capacity;
        priority = TargetPriority.transport;
    }

    
}