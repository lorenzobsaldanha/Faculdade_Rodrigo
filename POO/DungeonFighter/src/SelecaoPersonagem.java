import java.awt.*;
import javax.swing.*;

public class SelecaoPersonagem {
    Font fonteTitulo;
    Font fontePersonagens;

    JLabel titulo;
    JLabel textoPaladino,textoBarbaro,textoGuerreiro;

    JPanel painelPrincipal;
    JPanel painelBarbaro;
    JPanel painelPaladino;
    JPanel painelGuerreiro;
    JPanel painelPersonagens;

    PainelInferior voltar;

    JButton botaoBarbaro;
    JButton botaoPaladino;
    JButton botaoGuerreiro;

    public SelecaoPersonagem(Paineis multiplosPaineis) {
        // Fontes
        fonteTitulo = Fonte.carregar(75);
        fontePersonagens = Fonte.carregar(30);

        // Configurando os botoes
        ImageIcon iconeBarbaro = new ImageIcon("Assets/botaoBarbaro.png");
        ImageIcon iconePaladino = new ImageIcon("Assets/botaoPaladino.png");
        ImageIcon iconeGuerreiro = new ImageIcon("Assets/botaoGuerreiro.png");

        Image imagemBarbaro = iconeBarbaro.getImage().getScaledInstance(250, 500, Image.SCALE_SMOOTH);
        Image imagemPaladino = iconePaladino.getImage().getScaledInstance(270, 500, Image.SCALE_SMOOTH);
        Image imagemGuerreiro = iconeGuerreiro.getImage().getScaledInstance(250, 500, Image.SCALE_SMOOTH);

        ImageIcon iconeBarbaroResize = new ImageIcon(imagemBarbaro);
        ImageIcon iconePaladinoResize = new ImageIcon(imagemPaladino);
        ImageIcon iconeGuerreiroResize = new ImageIcon(imagemGuerreiro);

        titulo = new JLabel("Selecione o Personagem");
        titulo.setFont(fonteTitulo);
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 90, 0));

        textoBarbaro = new JLabel("Barbaro");
        textoPaladino = new JLabel("Paladino");
        textoGuerreiro = new JLabel("Guerreiro");
        JLabel[] textoPersonagens = {textoBarbaro,textoPaladino,textoGuerreiro};
        for(JLabel j : textoPersonagens) {
            j.setFont(fontePersonagens);
            j.setForeground(Color.WHITE);
            j.setHorizontalAlignment(JLabel.CENTER);
        }

        botaoBarbaro = new JButton(iconeBarbaroResize);
        botaoPaladino = new JButton(iconePaladinoResize);
        botaoGuerreiro = new JButton(iconeGuerreiroResize);

        JButton[] botoesPersonagem = {botaoBarbaro, botaoPaladino, botaoGuerreiro};
        for(JButton b : botoesPersonagem) {
            b.setAlignmentY(Component.CENTER_ALIGNMENT);
            b.setBorderPainted(false);
            b.setContentAreaFilled(false);
            b.setFocusPainted(false);
        }

        // Painel dos personagens
        painelPersonagens = new JPanel();
        painelBarbaro = new JPanel();
        painelPaladino = new JPanel();
        painelGuerreiro = new JPanel();

        painelBarbaro.setLayout(new BoxLayout(painelBarbaro, BoxLayout.Y_AXIS));
        painelPaladino.setLayout(new BoxLayout(painelPaladino, BoxLayout.Y_AXIS));
        painelGuerreiro.setLayout(new BoxLayout(painelGuerreiro, BoxLayout.Y_AXIS));

        painelBarbaro.setBackground(Color.BLACK);
        painelPaladino.setBackground(Color.BLACK);
        painelGuerreiro.setBackground(Color.BLACK);

        botaoBarbaro.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoPaladino.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoGuerreiro.setAlignmentX(Component.CENTER_ALIGNMENT);

        textoBarbaro.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoPaladino.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoGuerreiro.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelBarbaro.add(botaoBarbaro);
        painelBarbaro.add(Box.createVerticalStrut(10));
        painelBarbaro.add(textoBarbaro);

        painelPaladino.add(botaoPaladino);
        painelPaladino.add(Box.createVerticalStrut(10));
        painelPaladino.add(textoPaladino);

        painelGuerreiro.add(botaoGuerreiro);
        painelGuerreiro.add(Box.createVerticalStrut(10));
        painelGuerreiro.add(textoGuerreiro);

        painelPersonagens.setLayout(new GridLayout(1, 3, 20, 0));
        painelPersonagens.setBackground(Color.BLACK);

        painelPersonagens.add(painelBarbaro);
        painelPersonagens.add(painelPaladino);
        painelPersonagens.add(painelGuerreiro);

        // Painel da tela com todos os outros paineis
        voltar = new PainelInferior();
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.add(titulo,BorderLayout.NORTH);
        painelPrincipal.add(painelPersonagens,BorderLayout.CENTER);
        painelPrincipal.add(voltar,BorderLayout.SOUTH);
        painelPrincipal.setBackground(Color.BLACK);

        //Implementacao das acoes dos botoes usando a classe "Paineis", que contem o cardlayout
        JPanel painelComPaineis = multiplosPaineis.paineis;
        CardLayout cardLayout = multiplosPaineis.layoutPaineis;

        voltar.botaoVoltar.addActionListener(e -> cardLayout.show(painelComPaineis, "Painel do Menu"));
        for(JButton b : botoesPersonagem) {
            b.addActionListener(e  -> cardLayout.show(painelComPaineis, "Painel Atributos"));
        }
    }
}