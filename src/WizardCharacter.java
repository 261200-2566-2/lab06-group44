public class WizardCharacter implements Wizard, Character {

    private String name;
    private int level;
    private int hp;
    private int magicDamage;
    private Weapon weapon;
    private Armor armor;

    /**Create a wizard character
     * effects: generate internal value such as hp, attack, defense from input
     *
     * @param name: name of character
     * @param level:start level
     * @param weapon: increase attack
     * @param armor: increase protect
     */
    public WizardCharacter(String name, int level, Weapon weapon, Armor armor) {
        this.name = name;
        this.level = level;
        this.hp = 80 + level * 8;
        this.magicDamage = 15 + level * 4;
        this.weapon = weapon;
        this.armor = armor;
    }

    /**use spell to attack an enemy
     * effects: minus enemy's power
     * effects: higher damage when wearing a weapon
     *
     * @param target: this character enemy
     */
    @Override
    public void castSpell(Character target) {
        if (target != null) {
            int totalDamage = magicDamage + (weapon != null ? weapon.getAttackDamage() : 0);
            target.getAttack(totalDamage);
        } else {
            System.out.println("No target to cast a spell on.");
        }
    }

    /**level up character
     * effects: plus character level by 1
     */
    @Override
    public void levelUp() {
        level++;
        magicDamage = 15 + level * 3;
        System.out.println(name + " leveled up to level " + level);
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
        System.out.println("Magic Damage: " + magicDamage + (weapon != null ? weapon.getAttackDamage() : 0));

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
        int actualDamage = 0;
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