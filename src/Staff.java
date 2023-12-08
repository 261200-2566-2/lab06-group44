/**stall staff damage
 * return : staff's damage
 */
class Staff implements Weapon {
    private int magicDamage;

    public Staff(int magicDamage) {
        this.magicDamage = magicDamage;

    }

    @Override
    public int getAttackDamage() {
        return magicDamage;
    }


}