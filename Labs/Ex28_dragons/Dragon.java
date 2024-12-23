public class Dragon 
{
    private String name;
    private int level;
    private boolean canBreatheFire;
    
    public Dragon(String theName, int theLevel) {
        name = theName;
        level = theLevel;
        checkAndSetFireBreather();
    }
    
    public String getName() {
        return name;
    }
    
    public int getLevel() {
        return level;
    }
    
    public boolean isFireBreather() {
        return canBreatheFire;
    }
    
    private void checkAndSetFireBreather() {
        if (level >= 70) {
            canBreatheFire = true;
        } else {
            canBreatheFire = false;
        }
    }
    
    public void attack() {
        if (isFireBreather()) {
            System.out.println(">>>>>>>>>>");
            System.out.println(">>>>>>>>>>>>>>");
            System.out.println(">>>>>>>>>>>>>>");
            System.out.println(">>>>>>>>>>");
        } else {
            System.out.println("~ ~ ~");
        }
    } // ??
    
    public void gainEexperience() {
        int exp = 10;
        level += exp;
    } // ??

    public String toString()
    {
        return "Dragon " + name + " is at level " + level;
    }
}