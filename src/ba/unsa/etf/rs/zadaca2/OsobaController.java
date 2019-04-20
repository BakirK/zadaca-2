package ba.unsa.etf.rs.zadaca2;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.NumberStringConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OsobaController {

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

    private OsobeModel model;


    //ObservableList<Osoba> lista = FXCollections.observableArrayList();


    public OsobaController(OsobeModel modelInput) {
        model = modelInput;
        //lista = FXCollections.observableArrayList(model.getOsobe());
    }

    @FXML
    public void initialize() {
        //imeKolona.setCellValueFactory(new PropertyValueFactory<Osoba, String>("Ime"));
        //prezimaKolona.setCellValueFactory(new  PropertyValueFactory<Osoba, String>("Prezime"));
        tabelaOsobe.requestFocus();

        model.setTrenutnaOsoba(model.getOsobe().get(0));
        setTextPropetryBind();
        tabelaOsobe.setItems(model.getOsobe());

        tabelaOsobe.getFocusModel().focus(0);
        setTextPropetryUnBind();
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
        if(model.trenutnaOsobaProperty() == null) {
            System.out.println("NULL");
            model.setTrenutnaOsoba(new Osoba("","","",1,"",LocalDate.of(1900,1,1)));
        }
        Osoba o = (Osoba) tabelaOsobe.getSelectionModel().getSelectedItem();
        setTextPropetryUnBind();
        //System.out.println(tabelaOsobe.getSelectionModel().getSelectedItem());
        model.setTrenutnaOsoba(o);
        setTextPropetryBind();
        //tabelaOsobe.setItems(model.getOsobe());
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
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        //LocalDate temp = LocalDate.parse(rodjendanText.getValue().);
        //LocalDate temp = LocalDate.of(rodjendanText.getValue().getYear(), rodjendanText.getValue().getMonth(), rodjendanText.getValue().getDayOfMonth());
        //Osoba o = new Osoba(imeText.getText(), prezimeText.getText(), ulicaText.getText(),Integer.parseInt(postanskiBrojText.getText()), gradText.getText(), temp);
        Osoba o = new Osoba();
        setTextPropetryUnBind();
        model.dodaj(o);
        model.setTrenutnaOsoba(model.getOsobe().get(model.getOsobe().size() - 1));
        setTextPropetryBind();
        tabelaOsobe.refresh();
        tabelaOsobe.requestFocus();
        tabelaOsobe.getSelectionModel().selectLast();

    }

    @FXML
    private void obrisiOsobu(MouseEvent mouseEvent) {
        //setTextPropetryBind();
        setTextPropetryUnBind();
        model.obrisi(tabelaOsobe.getSelectionModel().getSelectedIndex());
        //setTextPropetryBind();
        tabelaOsobe.refresh();
        tabelaOsobe.requestFocus();
        //tabelaOsobe.getSelectionModel().selectLast();


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
