package htw.berlin.webtech.demo.web.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rezept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String beschreibung;
    private Integer vorbereitungsZeit;
    private Integer kochZeit;
    private Integer portionen;
    private String kategorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rezept")
    private Set<Zutat> zutaten = new HashSet<>();

    public Rezept() {}

    public Rezept(String name) {
        this.name = name;
    }

    public Rezept(Long id) {
        this.id = id;
    }

    public Rezept(Long id, String name, String beschreibung, Integer vorbereitungsZeit, Integer kochZeit, Integer portionen, String kategorie) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
        this.vorbereitungsZeit = vorbereitungsZeit;
        this.kochZeit = kochZeit;
        this.portionen = portionen;
        this.kategorie = kategorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Integer getVorbereitungsZeit() {
        return vorbereitungsZeit;
    }

    public void setVorbereitungsZeit(Integer vorbereitungsZeit) {
        this.vorbereitungsZeit = vorbereitungsZeit;
    }

    public Integer getKochZeit() {
        return kochZeit;
    }

    public void setKochZeit(Integer kochZeit) {
        this.kochZeit = kochZeit;
    }

    public Integer getPortionen() {
        return portionen;
    }

    public void setPortionen(Integer portionen) {
        this.portionen = portionen;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public Set<Zutat> getZutaten() {
        return zutaten;
    }

    public void addZutat(Zutat zutat) {
        zutat.setRezept(this);
        this.zutaten.add(zutat);
    }

    public void deleteZutat(Zutat zutat) {
        zutat.setRezept(null);
        this.zutaten.remove(zutat);
    }

    @Override
    public String toString() {
        return "Rezept{" +
                "name='" + name + '\'' +
                '}';
    }
}
