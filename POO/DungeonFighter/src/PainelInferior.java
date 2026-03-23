import javax.swing.*;
import java.awt.*;

public class PainelInferior extends JPanel {
    JButton botaoVoltar;
    Font fonteBotao;

    public PainelInferior() {
        fonteBotao = Fonte.carregar(50);
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(fonteBotao);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setContentAreaFilled(false);
        botaoVoltar.setAlignmentY(Component.CENTER_ALIGNMENT);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(botaoVoltar);
        setBackground(Color.BLACK);
    }
}