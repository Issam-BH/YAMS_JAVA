module fr.uge.yams {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;

	opens vue to javafx.graphics, javafx.fxml;
	opens controller to javafx.fxml;
	opens model to javafx.fxml;
}
