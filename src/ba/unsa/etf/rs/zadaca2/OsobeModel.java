package ba.unsa.etf.rs.zadaca2;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OsobeModel {

        private ObservableList<Osoba> osobe = FXCollections.observableArrayList();
        private SimpleObjectProperty<Osoba> trenutnaOsoba = new SimpleObjectProperty();


        public ObservableList<Osoba> getOsobe() {
            return osobe;
        }

        public void setOsobe(ObservableList<Osoba> osobe) {
            this.osobe = osobe;
        }

        public Osoba getTrenutnaOsoba() {
            return trenutnaOsoba.get();
        }

        public SimpleObjectProperty trenutnaOsobaProperty() {
            return trenutnaOsoba;
        }

        public void setTrenutnaOsoba(Object trenutnaOsoba) {
            this.trenutnaOsoba.set((Osoba) trenutnaOsoba);
        }

        public void napuni () {
            osobe.add(new Osoba("Bakir", "Karović", "Pozegina 42", 71000, "Sarajevo", "23.09.1999"));
            osobe.add(new Osoba("Faris", "Baždar", "Gradačačka 16", 71000, "Sarajevo", "13.01.1999"));
            osobe.add(new Osoba("Šeila", "Šeilić", "Herrengasse",8010, "Graz",  "28.02.2000"));
            osobe.add(new Osoba("Amra", "Amrica", "Rue Neuve", 1000, "Brisel", "07.03.2000"));
            osobe.add(new Osoba("Nadir", "Muratovic", "Dvorska", 71000, "Sarejevo", "21.07.1999"));
            osobe.add(new Osoba("Pujdo", "Ker", "Neretvanska", 71000, "Sarajevo", "20.04.2019"));
        }

        public void dodaj(Osoba o) {
            osobe.add(o);
        }

        public void obrisi() {

        }
}


