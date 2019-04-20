package ba.unsa.etf.rs.zadaca2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class OsobaController {
    private ObservableList<Osoba> osoba = FXCollections.observableArrayList();
    private SimpleObjectProperty trenutnaOsoba = new SimpleObjectProperty();


    private ObservableList<Osoba> getOsoba() {
        return osoba;
    }

    private void setOsoba(ObservableList<Osoba> osoba) {
        this.osoba = osoba;
    }

    private Object getTrenutnaOsoba() {
        return trenutnaOsoba.get();
    }

    public SimpleObjectProperty trenutnaOsobaProperty() {
        return trenutnaOsoba;
    }

    private void setTrenutnaOsoba(Object trenutnaOsoba) {
        this.trenutnaOsoba.set(trenutnaOsoba);
    }
}
