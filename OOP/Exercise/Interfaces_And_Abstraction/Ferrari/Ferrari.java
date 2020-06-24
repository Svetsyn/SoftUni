package ferrari;

public class Ferrari implements Car{

    private String driveName;
    private final String model="488-Spider";

    public Ferrari(String driveName) {
        this.driveName = driveName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",this.model
        ,this.brakes()
        ,this.gas()
        ,this.driveName);
    }
}
