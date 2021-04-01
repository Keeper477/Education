package lab_3;

public class Golden_retriever extends Dog{
    private int lvl_friendship;
    private int lvl_training;
    public Golden_retriever(String t_name, int t_year, int t_lvl_friendship, int t_lvl_training){
        super(t_name,t_year);
        lvl_friendship = t_lvl_friendship;
        lvl_training = t_lvl_training;
    }
    public String friend(){
        if(lvl_friendship>=4)
            return "Good dog";
        else
            return "Bad dog";
    }
    public String workout(){
        if(lvl_training>=4)
            return "I'm ready";
        else
            return "I'm not ready";
    }
}