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
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    ObservableList<Osoba> lista = FXCollections.observableArrayList();;
    private OsobeModel model;
    @FXML
    private TableColumn imeKolona;
    @FXML
    private TableColumn prezimeKolona;

    public OsobaController(OsobeModel modelInput) {
        model = modelInput;
        lista = FXCollections.observableArrayList(model.getOsobe());
    }

    @FXML
    public void initialize() {

        //value za date picker


/*
        //text field date picker-a
        rodjendanText.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldDate, String newDate) {
                if (rodjendanText.getEditor().getText().matches("[0-3][0-9][/][0-1][0-9][/][1-2][0-9][0-9][0-9]")) {
                    //if (rodjendanText.getEditor().getText().equals(rodjendanText.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))) {
                        System.out.println("isti");
                        String date = "16/12/2000";
                        LocalDate temp = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        setTextPropetryUnBind();
                        rodjendanText.setValue(temp);
                        //String date = rodjendanText.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        //rodjendanText.getEditor().setText(date);
                        //setTextPropetryBind();
                    //}
                }
            }
        });

        rodjendanText.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observableValue, LocalDate localDate, LocalDate t1) {
                if (t1 != null) {
                    String date = t1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    rodjendanText.getEditor().setText(date);
                }
            }
        });*/

        postanskiBrojText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                //if (!newValue.matches("[,]")) {
                postanskiBrojText.setText(newValue.replaceAll("[,]", ""));
                //}
            }
        });
        postanskiBrojText.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (postanskiBrojText.isFocused() && !postanskiBrojText.getText().isEmpty()) {
                            postanskiBrojText.selectAll();
                        }
                    }
                });
            }
        });
        imeKolona.setCellValueFactory(new PropertyValueFactory<Osoba, String>("Ime"));
        prezimeKolona.setCellValueFactory(new PropertyValueFactory<>("Prezime"));
        tabelaOsobe.requestFocus();
        model.setTrenutnaOsoba(model.getOsobe().get(0));
        setTextPropetryBind();
        tabelaOsobe.setItems(model.getOsobe());

        tabelaOsobe.getFocusModel().focus(0);
        setTextPropetryUnBind();

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
                if (rodjendanText.getValue() != null) {
                    String date = rodjendanText.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    rodjendanText.getEditor().setText(date);
                }
                tabelaOsobe.refresh();
            }
        });
    }

    @FXML
    private void updateSelectedUser() {
        if(model.trenutnaOsobaProperty() == null) {
            //System.out.println("NULL");
            model.setTrenutnaOsoba(new Osoba("","","",1,"",LocalDate.of(1900,1,1)));
        }
        Osoba o = (Osoba) tabelaOsobe.getSelectionModel().getSelectedItem();
        setTextPropetryUnBind();
        //System.out.println(tabelaOsobe.getSelectionModel().getSelectedItem());
        model.setTrenutnaOsoba(o);
        setTextPropetryBind();
        tabelaOsobe.setItems(model.getOsobe());
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
        if (tabelaOsobe.getSelectionModel().getSelectedIndex() != -1) {
            model.obrisi(tabelaOsobe.getSelectionModel().getSelectedIndex());
            //setTextPropetryBind();
            tabelaOsobe.refresh();
            tabelaOsobe.requestFocus();
            //tabelaOsobe.getSelectionModel().selectLast();
        }
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
    // TODO implementirat sort method nad tabelom
    @FXML
    private void sortTable() {
    }

    @FXML
    private void updateDate() {
        System.out.println("aa");
    }
}
