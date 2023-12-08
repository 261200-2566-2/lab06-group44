public class WarriorCharacter implements Warrior, Character {

    private String name;
    private int level;
    public int hp;
    private int baseAttackDamage;
    private int defense;
    private Weapon weapon;
    private Armor armor;

    /**Create a warrior character
     * effects: generate internal value such as hp, attack, defense from input
     *
     * @param name: name of character
     * @param level:start level
     * @param weapon: increase attack
     * @param armor: increase protect
     */
    public WarriorCharacter(String name, int level, Weapon weapon, Armor armor) {
        this.name = name;
        this.level = level;
        this.hp = 100 + level * 10;
        this.baseAttackDamage = 10 + level * 5;
        this.defense = 5 + level * 2;
        this.weapon = weapon;
        this.armor = armor;
    }

    /**attack an enemy
     * effects: minus enemy's power
     * effects: higher damage when wearing a weapon
     *
     * @param target: this character enemy
     */
    @Override
    public void attack(Character target) {

        int totalAttackDamage = baseAttackDamage;
        if (weapon != null) {
            totalAttackDamage += weapon.getAttackDamage();
        }

        target.getAttack(totalAttackDamage);
    }

    /**level up character
     * effects: plus character level by 1
     */
    @Override
    public void levelUp() {
        this.level++;
        baseAttackDamage = 10 + level * 5;
        defense = 5 + level * 2;
        System.out.println(name + " leveled up to level " + this.level);
    }

    /**show character stat
     * effect: show character data like name level hp damage
     *
     */
    @Override
    public void checkStats() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Health: " + hp);
        System.out.println("Attack Damage: " + baseAttackDamage);
        System.out.println("Defense: " + defense);

        if (weapon != null) {
            System.out.println("Equipped Weapon: " + weapon.getClass().getSimpleName());
        }

        if (armor != null) {
            System.out.println("Equipped Armor: " + armor.getClass().getSimpleName());
        }
    }

    /**Get attack by enemy
     * effect: hp -= damage taken
     *
     * @param damage: enemy's attack damage
     */
    @Override
    public void getAttack(int damage) {
        int actualDamage;
        if(damage-defense<0){
            actualDamage = 0;
        }else{
            actualDamage = damage - defense;
        }


        if (armor != null) {
            actualDamage -= armor.getDefenseBonus();
        }

        hp -= actualDamage;

        if (hp <= 0) {
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " takes " + actualDamage + " damage. Hp : " + hp);
        }
    }
}