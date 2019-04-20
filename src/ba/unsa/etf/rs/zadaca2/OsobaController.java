package ba.unsa.etf.rs.zadaca2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.NumberStringConverter;

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

    @FXML
    public void initialize() {
        tabelaOsobe.requestFocus();
        model.setTrenutnaOsoba(model.getOsobe().get(0));
        setTextPropetryBind();
        tabelaOsobe.setItems(model.getOsobe());
        tabelaOsobe.getFocusModel().focus(0);
        //System.out.println("initialize");

        //listener
        tabelaOsobe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Osoba>() {
            @Override
            public void changed(ObservableValue<? extends Osoba> observableValue, Osoba osobaOld, Osoba osobaNew) {
                if (osobaOld != null) {
                    setTextPropetryUnBind();
                    ;
                }
                if (osobaNew == null) {
                    // TODO: SET DEFAULT TEXT ZA POLJA FORME
                } else {
                    updateSelectedUser();
                }
                tabelaOsobe.refresh();
            }

        });
    }

    private void updateSelectedUser() {

    }


    private void setTextPropetryBind() {
        imeText.textProperty().bindBidirectional(model.getTrenutnaOsoba().imeProperty());
        prezimeText.textProperty().bindBidirectional(model.getTrenutnaOsoba().prezimeProperty());
        ulicaText.textProperty().bindBidirectional(model.getTrenutnaOsoba().ulicaProperty());
        gradText.textProperty().bindBidirectional(model.getTrenutnaOsoba().gradProperty());
        postanskiBrojText.textProperty().bindBidirectional(model.getTrenutnaOsoba().postanskiBrojProperty(), new NumberStringConverter());
        rodjendanText.textProperty().bindBidirectional(model.getTrenutnaOsoba().rodjendanProperty(), new LocalDateStringConverter());
    }

    private void setTextPropetryUnBind() {
        imeText.textProperty().unbindBidirectional(model.getTrenutnaOsoba().imeProperty());
        prezimeText.textProperty().unbindBidirectional(model.getTrenutnaOsoba().prezimeProperty());
        ulicaText.textProperty().unbindBidirectional(model.getTrenutnaOsoba().ulicaProperty());
        gradText.textProperty().unbindBidirectional(model.getTrenutnaOsoba().gradProperty());
        postanskiBrojText.textProperty().unbindBidirectional(model.getTrenutnaOsoba().postanskiBrojProperty());
        rodjendanText.textProperty().unbindBidirectional(model.getTrenutnaOsoba().rodjendanProperty());

    }
}
