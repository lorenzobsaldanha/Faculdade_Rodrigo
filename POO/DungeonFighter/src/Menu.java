import java.awt.*;
import javax.swing.*;

public class Menu{
    Font fonteTitulo;
    Font fonteBotoes;

    JLabel titulo1;
    JLabel titulo2;

    JPanel painelTitulo;
    JPanel painelPrincipal;
    JPanel painelBotoes;

    JButton botaoPlay;
    JButton botaoDebug;
    JButton botaoSair;

    public Menu(Paineis multiplosPaineis) {
        //Título
        fonteTitulo = Fonte.carregar(90);
        fonteBotoes = Fonte.carregar(50);

        titulo1 = new JLabel("Dungeon");
        titulo2 = new JLabel("Fighter");

        JLabel [] titulos = {titulo1,titulo2};
        for(JLabel t : titulos) {
            t.setFont(fonteTitulo);
            t.setForeground(Color.WHITE);
            t.setHorizontalAlignment(JLabel.CENTER);
            t.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        painelTitulo = new JPanel();
        painelTitulo.setBackground(Color.BLACK);
        painelTitulo.setLayout(new BoxLayout(painelTitulo,BoxLayout.Y_AXIS));
        painelTitulo.add(titulo1);
        painelTitulo.add(titulo2);

        //Botões
        botaoPlay = new JButton("Jogar");
        botaoDebug = new JButton("Debug");
        botaoSair = new JButton("Sair");

        JButton[] botoes = {botaoPlay,botaoDebug,botaoSair};
        for(JButton b : botoes) {
            b.setFont(fonteBotoes);
            b.setFocusPainted(false);
            b.setBorderPainted(false);
            b.setContentAreaFilled(false);
            b.setForeground(Color.WHITE);
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setBackground(Color.BLACK);

        painelBotoes.add(Box.createVerticalGlue());
        painelBotoes.add(botaoPlay);
        painelBotoes.add(Box.createVerticalStrut(20));
        painelBotoes.add(botaoDebug);
        painelBotoes.add(Box.createVerticalStrut(20));
        painelBotoes.add(botaoSair);
        painelBotoes.add(Box.createVerticalGlue());

        //Painel Principal
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.add(painelTitulo,BorderLayout.NORTH);
        painelPrincipal.add(painelBotoes,BorderLayout.CENTER);
        painelPrincipal.setBackground(Color.BLACK);

        //Implementacao das acoes dos botoes usando a classe "Paineis", que contem o cardlayout
        JPanel painelComPaineis = multiplosPaineis.paineis;
        CardLayout cardLayout = multiplosPaineis.layoutPaineis;
       
        botaoPlay.addActionListener(e -> cardLayout.show(painelComPaineis, "Painel de Selecao de Personagem"));
        botaoSair.addActionListener(e -> System.exit(0));
    }
}
