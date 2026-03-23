import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class Fonte {
    public static Font carregar(float tamanho) {
        Font font;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Font/MonsterFriendFore.otf"));
            return font.deriveFont(tamanho);
        } catch(FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font("SansSerif", Font.PLAIN, (int) tamanho);
        }
    }
}
