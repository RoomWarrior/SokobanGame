import java.io.Serializable;

public class Data implements Serializable {
    private final int[][] desktop;

    public Data(int[][] desktop) {
        this.desktop = desktop;
    }

    public int[][] getDesktop() {
        return desktop;
    }
}
