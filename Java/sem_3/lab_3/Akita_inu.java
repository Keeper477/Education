package lab_3;

public class Akita_inu extends Dog{
    private int lvl_activity;
    public Akita_inu(String t_name, int t_year, int t_lvl_activity){
        super(t_name,t_year);
        lvl_activity = t_lvl_activity;
    }
    public String walking(){
        if(lvl_activity>=4)
            return "Run faster";
        else
            return "I'm tired";
    }
    public String waiting(){
        return "still waiting";
    }
}
