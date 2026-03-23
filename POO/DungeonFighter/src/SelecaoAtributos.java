import java.awt.*;
import javax.swing.*;

public class SelecaoAtributos extends Heroi{
    Font fonteTitulo,fonteAtributos,fonteStats;
    JLabel titulo,stats,stats2;
    JLabel nome,level,poder,vida,defesa;
    JLabel erro;
    JTextField nomeText;
    JButton addPoder,addVida,addDefesa,minusVida,minusPoder,minusDefesa;

    JPanel painelPrincipal;
    JPanel painelTitulo;
    JPanel subTitulo;
    JPanel painelAtributos;
    JPanel painelColuna1;
    JPanel painelColuna2;
    JPanel painelVida;
    JPanel painelPoder;
    JPanel painelDefesa;
    PainelInferior painelInferior;
    /*
    * Ainda falta fazer algumas coisas mas to com preguiça entao vou dar push nessa bomba, depois eu faço
    * */
    public SelecaoAtributos(Paineis multiplosPaineis) {

        ImageIcon iconeCoracao = new ImageIcon("Assets/coracao.png");
        ImageIcon iconeCoracaoInvertido = new ImageIcon("Assets/coracaoInvertido.png");
        ImageIcon iconeEscudo = new ImageIcon("Assets/escudo.png");
        ImageIcon iconeEscudoInvertido = new ImageIcon("Assets/escudoInvertido.png");
        ImageIcon iconePoder = new ImageIcon("Assets/poder.png");
        ImageIcon iconePoderInvertido = new ImageIcon("Assets/poderInvertido.png");

        Image imagemCoracao = iconeCoracao.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imagemCoracaoInvetido = iconeCoracaoInvertido.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imagemEscudo = iconeEscudo.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imagemEscudoInvetido = iconeEscudoInvertido.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imagemPoder = iconePoder.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imagemPoderInvetido = iconePoderInvertido.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

        ImageIcon iconeCoracaoResize = new ImageIcon(imagemCoracao);
        ImageIcon iconeCoracaoInvertidoResize = new ImageIcon(imagemCoracaoInvetido);
        ImageIcon iconeEscudoResize = new ImageIcon(imagemEscudo);
        ImageIcon iconeEscudoInvertidoResize = new ImageIcon(imagemEscudoInvetido);
        ImageIcon iconePoderResize = new ImageIcon(imagemPoder);
        ImageIcon iconePoderInvertidoResize = new ImageIcon(imagemPoderInvetido);

        fonteTitulo = Fonte.carregar(60);
        fonteAtributos = Fonte.carregar(25);
        fonteStats = Fonte.carregar(40);

        painelPrincipal = new JPanel();
        painelAtributos = new JPanel();
        painelTitulo = new JPanel();
        subTitulo = new JPanel();
        painelColuna1 = new JPanel();
        painelColuna2 = new JPanel();
        painelVida = new JPanel();
        painelDefesa = new JPanel();
        painelPoder = new JPanel();
        painelInferior = new PainelInferior();

        nomeText = new JTextField(20);

        addVida = new JButton(iconeCoracaoResize);
        minusVida = new JButton(iconeCoracaoInvertidoResize);
        addDefesa = new JButton(iconeEscudoResize);
        minusDefesa = new JButton(iconeEscudoInvertidoResize);
        addPoder = new JButton(iconePoderResize);
        minusPoder = new JButton(iconePoderInvertidoResize);

        titulo = new JLabel("Atributos");
        stats  = new JLabel("Stats Atuais");
        stats2 = new JLabel("Adicionar Stats");
        nome   = new JLabel("Nome       " + getNome());
        level  = new JLabel("Level      " + getLevel());
        poder  = new JLabel("Poder      " + getPoder());
        vida   = new JLabel("Saude      " + getVida());
        defesa = new JLabel("Defesa     " + getDefesa());
        erro = new JLabel("");

        JLabel [] titulosStats = {stats,stats2};
        for(JLabel t : titulosStats) {
            t.setFont(fonteStats);
            t.setForeground(Color.WHITE);
        }
        JLabel [] atributos = {nome,level,poder,vida,defesa};
        for(JLabel l : atributos) {
            l.setFont(fonteAtributos);
            l.setForeground(Color.WHITE);
        }
        JButton[] botoesAtributos = {addPoder,minusPoder,addVida,minusVida,addDefesa,minusDefesa};
        for(JButton b : botoesAtributos) {
            b.setAlignmentY(Component.CENTER_ALIGNMENT);
            b.setBorderPainted(false);
            b.setContentAreaFilled(false);
            b.setFocusPainted(false);
        }

        nomeText.setFont(fonteAtributos);
        nomeText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        nomeText.setOpaque(false);
        nomeText.setForeground(Color.WHITE);
        nomeText.setCaretColor(Color.WHITE);
        nomeText.setMaximumSize(nomeText.getPreferredSize());

        subTitulo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        subTitulo.setBackground(Color.BLACK);
        nome.setBorder(BorderFactory.createEmptyBorder(0, 820, 0, 0));
        subTitulo.add(level);
        subTitulo.add(nome);
        subTitulo.add(nomeText);

        titulo.setFont(fonteTitulo);
        titulo.setForeground(Color.white);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));

        painelTitulo.setLayout(new BorderLayout());
        painelTitulo.setBackground(Color.BLACK);
        painelTitulo.add(titulo, BorderLayout.NORTH);
        painelTitulo.add(subTitulo, BorderLayout.CENTER);

        painelAtributos.setLayout(new GridLayout(0, 2));
        painelColuna1.setLayout(new BoxLayout(painelColuna1,BoxLayout.Y_AXIS));
        painelColuna2.setLayout(new BoxLayout(painelColuna2,BoxLayout.Y_AXIS));

        erro.setFont(fonteStats);
        erro.setForeground(Color.RED);
        painelInferior.add(erro);

        painelAtributos.setBackground(Color.BLACK);
        painelColuna1.setBackground(Color.BLACK);
        painelColuna2.setBackground(Color.BLACK);

        painelColuna1.setBorder(BorderFactory.createEmptyBorder(100, 10, 0, 0));
        painelColuna2.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        stats.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        stats2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        painelColuna1.add(stats);
        painelColuna1.add(Box.createVerticalStrut(100));
        painelColuna1.add(poder);
        painelColuna1.add(Box.createVerticalStrut(170));
        painelColuna1.add(vida);
        painelColuna1.add(Box.createVerticalStrut(160));
        painelColuna1.add(defesa);

        painelVida.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        painelPoder.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        painelDefesa.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        painelVida.setBackground(Color.BLACK);
        painelPoder.setBackground(Color.BLACK);
        painelDefesa.setBackground(Color.BLACK);

        painelVida.add(addVida);
        painelVida.add(minusVida);
        painelPoder.add(addPoder);
        painelPoder.add(minusPoder);
        painelDefesa.add(addDefesa);
        painelDefesa.add(minusDefesa);

        painelColuna2.add(stats2);
        painelColuna2.add(Box.createVerticalStrut(80));
        painelColuna2.add(painelPoder);
        painelColuna2.add(Box.createVerticalStrut(0));
        painelColuna2.add(painelVida);
        painelColuna2.add(Box.createVerticalStrut(0));
        painelColuna2.add(painelDefesa);

        painelAtributos.add(painelColuna1);
        painelAtributos.add(painelColuna2);

        //Adicionando tudo ao painel principal
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.setBackground(Color.BLACK);
        painelPrincipal.add(painelTitulo,BorderLayout.NORTH);
        painelPrincipal.add(painelAtributos,BorderLayout.CENTER);
        painelPrincipal.add(painelInferior,BorderLayout.SOUTH);

        JPanel painelComPaineis = multiplosPaineis.paineis;
        CardLayout cardLayout = multiplosPaineis.layoutPaineis;
        painelInferior.botaoVoltar.addActionListener(e -> cardLayout.show(painelComPaineis, "Painel de Selecao de Personagem"));
        nomeText.addActionListener(e -> {
            String nomeDigitado = nomeText.getText().trim();
            if (nomeDigitado.isEmpty()) {
                erro.setText("Nome vazio bb");
            } else {
                erro.setText("");
                setNome(nomeDigitado);
            }
            painelInferior.revalidate();
            painelInferior.repaint();
        });
        addPoder.addActionListener(e -> {
            setPoder(getPoder() + 1);
            poder.setText("Poder      " + getPoder());
        });
        addVida.addActionListener(e -> {
            setVida(getVida() + 1 );
            vida.setText("Saude      " + getVida());
        });
        addDefesa.addActionListener(e -> {
            setDefesa(getDefesa() + 1);
            defesa.setText("Defesa     " + getDefesa());
        });
        minusPoder.addActionListener(e -> {
            setPoder(getPoder() - 1);
            poder.setText("Poder      " + getPoder());
        });
        minusVida.addActionListener(e -> {
            setVida(getVida() - 1 );
            vida.setText("Vida      " + getVida());
        });
        minusDefesa.addActionListener(e -> {
            setDefesa(getDefesa() - 1);
            defesa.setText("Defesa      " + getDefesa());
        });
    }
}