package galaxy.world.blocks.distribution;

import arc.graphics.g2d.*;
import mindustry.content.*;
import mindustry.world.*;
import mindustry.world.blocks.*;

public class GalaxyConveyor extends Block {
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

    @Override
    public void setStats() {
        super.setStats();
        stats.add(Stat.itemsMoved, speed, StatUnit.itemsSecond);
    }

    @Override
    public TextureRegion[] icons() {
        return new TextureRegion[]{regions[0][0]};
    }

    public class GalaxyConveyorBuild extends Building {
        public Item[] ids = new Item[capacity];
        public float[] xs = new float[capacity], ys = new float[capacity];
        public int len = 0;

        @Override
        public void draw() {
            Draw.rect(regions[0][0], x, y, tilesize, tilesize, rotation * 90);
            for (int i = 0; i < len; i++) {
                Draw.rect(ids[i].fullIcon, x + xs[i] * tilesize, y + ys[i] * tilesize, itemSize, itemSize);
            }
        }

        @Override
        public void updateTile() {
            for (int i = len - 1; i >= 0; i--) {
                if (Math.random() < speed) {
                    // Logika untuk memindahkan item
                    // Tambahkan logika pemindahan item di sini
                }
            }
        }

        @Override
        public boolean acceptItem(Building source, Item item) {
            return len < capacity;
        }

        @Override
        public void handleItem(Building source, Item item) {
            if (len < capacity) {
                ids[len] = item;
                xs[len] = 0; // Atur posisi X
                ys[len] = len * 0.4f; // Atur posisi Y
                len++;
            }
        }
    }
}