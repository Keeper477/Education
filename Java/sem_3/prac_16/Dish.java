package prac_16;

public final class Dish implements Item {
    private final String title, description;
    private final double cost;

    public Dish(String title, String description, double cost) throws Exception {
        this.title = title;
        this.description = description;
        this.cost = cost;
        if (title.equals("") || description.equals("")|| cost == 0)
            throw new Exception ("java.lang.IllegalArgumentException ");

    }
    public Dish(String title, String description) throws Exception {
        this.title = title;
        this.description = description;
        this.cost = 0;
        throw new Exception ("java.lang.IllegalArgumentException ");
    }

    public double getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Цена за 1 тр: " + cost + " Блюдо: " + title;
    }
}
