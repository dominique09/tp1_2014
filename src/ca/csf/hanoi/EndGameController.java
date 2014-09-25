package ca.csf.hanoi;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class EndGameController {
	
	@FXML Label messageLabel;
	@FXML VBox mainVBox;
	private GameController parentReference;

	@FXML
	void playNewGameButtonClicked() {
		parentReference.getParentReference().getStage().show();
		parentReference.close();
		this.close();
	}
	
	@FXML
	void quitButtonClicked() {
		parentReference.getParentReference().close();
		parentReference.close();
		this.close();
	}
	
	void setMessage(String string){
		messageLabel.setText(string);
	}

	public GameController getParentReference() {
		return parentReference;
	}

	public void setParentReference(GameController parentReference) {
		this.parentReference = parentReference;
	}
	
	public void close() {
		((Stage)mainVBox.getScene().getWindow()).close();
	}
}
