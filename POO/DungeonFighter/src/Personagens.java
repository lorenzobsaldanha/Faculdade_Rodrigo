public abstract class Personagens {
    private String nome;
    private int level;
    private int vida;
    private int poder;
    private int defesa;

    public Personagens(String nome, int vida, int poder, int defesa) {
        level = 1;
        this.nome = nome;
        this.vida = vida;
        this.poder = poder;
        this.defesa = defesa;
    }

    public String getNome() {
        return this.nome;
    }
    public int getLevel() {
        return level;
    }
    public int getVida() {
        return this.vida;
    }
    public int getPoder() {
        return this.poder;
    }
    public int getDefesa() {
        return this.defesa;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public void setPoder(int poder) {
        this.poder = poder;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}
