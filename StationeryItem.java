import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StationeryItem extends Item {

    private String meterial;

    public String getMeterial() {
        return meterial;
    }

    public void setMeterial(String meterial) {
        this.meterial = meterial;
    }

    @Override
    public String getTypeInfo() {
        return "Type: Stationery Item / meterial: " + meterial;
    }
}
