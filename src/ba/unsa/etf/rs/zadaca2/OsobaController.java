package ba.unsa.etf.rs.zadaca2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class OsobaController {
    private OsobeModel model;
    @FXML
    private TableView tabelaOsobe;
    @FXML
    private Label imeText;
    @FXML
    private Label prezimeText;
    @FXML
    private Label ulicaText;
    @FXML
    private Label gradText;
    @FXML
    private Label postanskiBrojText;
    @FXML
    private Label rodjendanText;
    @FXML
    private Button btnDodaj;
    @FXML
    private Button btnObrisi;

    public OsobaController(OsobeModel modelInput) {
        model = modelInput;
    }
    



}
