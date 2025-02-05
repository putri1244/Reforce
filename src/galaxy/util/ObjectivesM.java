package galaxy.util;

import arc.*;
import mindustry.game.*;
import static mindustry.game.Objectives.*;

public class ObjectivesM {
    public static class PortalLevel implements Objective {
        public int exp, level;

        @Override
        public boolean complete(){
            return Core.settings.getInt("betamindy-campaign-exp", 0) >= exp;
        }

        @Override
        public String display(){
            // Menghapus AnucoinTex.emojiPortal
            return Core.bundle.format("requirement.portallevel", level);
        }

        // Menghapus konstruktor dengan argumen
        public PortalLevel() {
            // Inisialisasi default jika diperlukan
            this.level = 0; // Atau nilai default lainnya
            this.exp = 0; // Atau nilai default lainnya
        }
    }
}