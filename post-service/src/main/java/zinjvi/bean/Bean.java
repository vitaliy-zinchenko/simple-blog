package zinjvi.bean;

/**
 * Created by zinchenko on 29.10.14.
 */
public class Bean {

    private String name;

    public Bean() {
    }

    public Bean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                '}';
    }
}
