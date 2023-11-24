package entities;

public class Champion {
    private String name;
    private int life;
    private int atack;
    private int armor;

    public Champion(String name, int life, int atack, int armor) {
        this.name = name;
        this.life = life;
        this.atack = atack;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAtack() {
        return atack;
    }

    public void setAtack(int atack) {
        this.atack = atack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void takeDamage(Champion other) {
        int damage = Math.max(1, other.atack - armor); // Math.max foi necessário para que o dano seja no mínimo 1 independente do armor
        life = Math.max(0, life - damage); // Math.max foi utilizado para caso o valor seja negativo, será ajustado para 0
    }

    public String status() {
        if (life <= 0) {
            return name + ": 0 de vida (morreu)";
        } else {
            return name + ": " + life + " de vida";
        }
    }
}