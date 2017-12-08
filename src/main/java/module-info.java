module asteroid {
    exports net.yumix.asteroid.color;
    exports net.yumix.asteroid;

    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    
    opens net.yumix.asteroid to javafx.fxml;
}