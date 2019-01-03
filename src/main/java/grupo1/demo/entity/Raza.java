package grupo1.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Raza {
    @Id
    private Long idRaza;
    private String animal;
    private String tipoRaza;
    private String color;

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

}
