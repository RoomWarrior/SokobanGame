import java.io.*;
import java.net.Socket;

public class LevelsFromServer {

    public int[][] getLevelFromServer(String level) {
        String hostName = "194.152.37.7";
        int portNumber = 4446;
        try {
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(level);

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Data object = (Data) in.readObject();
            return object.getDesktop();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
