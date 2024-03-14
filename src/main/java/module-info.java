module is.hi.hbv401g.Framendi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens is.hi.hbv401g.Framendi to javafx.fxml;
    exports is.hi.hbv401g.Framendi;
    opens is.hi.hbv401g.Bakendi to javafx.fxml;
    exports is.hi.hbv401g.Bakendi;


}
