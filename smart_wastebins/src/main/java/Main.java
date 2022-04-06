import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Wastebin bin1 = new Wastebin(57, 12, 0.5);
        Wastebin bin2 = new Wastebin(57, 12, 0.8);
        Wastebin bin3 = new Wastebin(57, 12, 0.07);
        List<Wastebin> wastebins = new ArrayList<>();
        wastebins.add(bin1);
        wastebins.add(bin2);
        wastebins.add(bin3);

        for (int i = 0; i < wastebins.size(); i++) {
            System.out.println(wastebins.get(i).getFullness());
        }
    }

}
