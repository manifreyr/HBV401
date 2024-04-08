package is.hi.hbv401g.Framendi;
import is.hi.hbv401g.Bakendi.*;

import java.sql.SQLException;

public class Controller {

    public static void main(String[] args) throws SQLException {
        UserRepository userRepository = new UserRepository();
        for (User u : userRepository.getAllUsers()) {
            System.out.println(u.toString());
        }
    }
}
