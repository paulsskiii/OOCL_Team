public class CargoItem {
    private int id;
    private String name;
    private int value;

    CargoItem(int id, String name, int value){
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return "ID:" + getId() + " name:" + getName() + " value:" + getValue();
    }
}
