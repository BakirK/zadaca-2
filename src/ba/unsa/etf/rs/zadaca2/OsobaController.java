package ba.unsa.etf.rs.zadaca2;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OsobaController {
    private OsobeModel model;
    @FXML
    private TextField imeText;
    @FXML
    private TextField prezimeText;
    @FXML
    private TextField ulicaText;
    @FXML
    private TextField gradText;
    @FXML
    private TextField postanskiBrojText;
    @FXML
    private DatePicker rodjendanText;
    @FXML
    private Button btnDodaj;
    @FXML
    private Button btnObrisi;
    @FXML
    private TableView tabelaOsobe;


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
                }
                if (osobaNew == null) {
                    imeText.setText("");
                    prezimeText.setText("");
                    ulicaText.setText("");
                    gradText.setText("");
                    postanskiBrojText.setText("");
                    rodjendanText.setValue(LocalDate.of(1900,1,1));
                } else {
                    updateSelectedUser();
                }
                tabelaOsobe.refresh();
            }
        });
    }

    @FXML
    private void updateSelectedUser() {
        Osoba o = (Osoba) tabelaOsobe.getSelectionModel().getSelectedItem();
        setTextPropetryUnBind();
        model.setTrenutnaOsoba(o);
        setTextPropetryBind();
        tabelaOsobe.refresh();
    }


    private void setTextPropetryBind() {
        imeText.textProperty().bindBidirectional(model.getTrenutnaOsoba().imeProperty());
        prezimeText.textProperty().bindBidirectional(model.getTrenutnaOsoba().prezimeProperty());
        ulicaText.textProperty().bindBidirectional(model.getTrenutnaOsoba().ulicaProperty());
        gradText.textProperty().bindBidirectional(model.getTrenutnaOsoba().gradProperty());
        postanskiBrojText.textProperty().bindBidirectional(model.getTrenutnaOsoba().postanskiBrojProperty(), new NumberStringConverter());
        rodjendanText.valueProperty().bindBidirectional(model.getTrenutnaOsoba().rodjendanProperty());
    }

    private void setTextPropetryUnBind() {
        imeText.textProperty().unbindBidirectional(model.getTrenutnaOsoba().imeProperty());
        prezimeText.textProperty().unbindBidirectional(model.getTrenutnaOsoba().prezimeProperty());
        ulicaText.textProperty().unbindBidirectional(model.getTrenutnaOsoba().ulicaProperty());
        gradText.textProperty().unbindBidirectional(model.getTrenutnaOsoba().gradProperty());
        postanskiBrojText.textProperty().unbindBidirectional(model.getTrenutnaOsoba().postanskiBrojProperty());
        rodjendanText.valueProperty().unbindBidirectional(model.getTrenutnaOsoba().rodjendanProperty());
    }

    @FXML
    private void dodajOsobu(MouseEvent mouseEvent) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        LocalDate temp = LocalDate.parse(rodjendanText.getValue().format(formatter), formatter);
        model.dodaj(new Osoba(imeText.getText(), prezimeText.getText(), ulicaText.getText(),Integer.parseInt(postanskiBrojText.getText()), gradText.getText(),  temp));
        setTextPropetryUnBind();
        model.setTrenutnaOsoba(model.getOsobe().get(model.getOsobe().size() - 1));
        setTextPropetryBind();
        tabelaOsobe.refresh();
        tabelaOsobe.requestFocus();
        tabelaOsobe.getSelectionModel().selectLast();
    }

    // TODO: implementirat metodu obrisi u klasi OsobeModel
    @FXML
    private void obrisiOsobu(MouseEvent mouseEvent) {
    }

    @FXML
    private void handle(KeyEvent event) {
        if (event.getCode().isArrowKey()) {
            updateSelectedUser();
        }
        else if (event.getCode() == KeyCode.ESCAPE) {
            Platform.exit();
        }
    }
}
