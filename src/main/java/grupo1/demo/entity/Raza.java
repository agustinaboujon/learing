package grupo1.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Raza implements Serializable {
    @Id
    private Long idRaza;
    private String animal;
    private String tipoRaza;
    private String color;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "raza")
    private List<Mascota> mascotasList;

    public Raza (Long idRaza, String animal, String tipoRaza, String color){
        this.idRaza = idRaza;
        this.animal = animal;
        this.tipoRaza = tipoRaza;
        this.color = color;
    }

    public Raza (){}

    public Long getIdRaza(){ return idRaza; }

    public String getAnimal(){ return  animal; }
    public void setAnimal(){ this.animal = animal; }

    public String getTipoRaza(){ return tipoRaza; }
    public void setTipoRaza(String tipoRaza){ this.tipoRaza = tipoRaza; }

    public String getColor(){ return color; }
    public void setColor(String color){ this.color = color; }

    public List<Mascota> getMascotasList() { return mascotasList; }

    public void setMascotasList(List<Mascota> mascotasList) {
        this.mascotasList = mascotasList;
    }
}
