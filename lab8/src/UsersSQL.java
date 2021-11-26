import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersSQL {
    public static void main(String[]args) {
        String userName = "root";
        String password = "MaestroBurgers_7";
        String connectionUrl = "jdbc:mysql://localhost:3306/airport";
        try (Connection connection = DriverManager.getConnection
                (connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO users " +
                    "VALUES" +
                    "(1, 'ahinski', '" + encrypte("abcdef", "1010110001011100") + "')," +
                    "(NULL, 'karpovich', '" + encrypte("fpmkaftp", "1010110001011100") + "')");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String encrypte(String password, String key) {
        StringBuilder sb = new StringBuilder();
        int keyBase10 = Integer.parseInt(key, 2);
        char[] passwordChars = password.toCharArray();
        for(char Char : passwordChars)
            sb.append(Integer.toBinaryString((int)Char ^ keyBase10));
        return sb.toString();
    }

    public static String decrypte(String password, String key) {
        int keyBase10 = Integer.parseInt(key, 2);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char[] passwordChars = password.toCharArray();
        List<Integer> HTMLcodesList = new ArrayList<>();
        List<StringBuilder> encryptedList = new ArrayList<>();
        for(char Char : passwordChars) {
            sb.append(Char);
            count++;
            if(count == 16) {
                encryptedList.add(sb);
                count = 0;
                sb = new StringBuilder();
            }
        }
        for (StringBuilder element : encryptedList) {
            int encryptedBase10 = Integer.parseInt(element.toString(), 2);
            HTMLcodesList.add((int) (encryptedBase10 ^ keyBase10));
        }
        sb = new StringBuilder();
        for (Integer HTMLcode : HTMLcodesList) {
            sb.append((byte)((char)(HTMLcode.intValue())));
        }
        return sb.toString();
    }
}
