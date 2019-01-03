package grupo1.demo.entity;

import javax.persistence.*;

@Entity
public class Mascota {
    @Id
    private Long idMascota;
    //private String raza;
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_raza")
    private Raza raza;
    private int patas;
    private boolean vivo;
    private String gruñir;

    public Mascota(long idMascota, Raza raza, int patas, boolean vivo){
        this.idMascota = idMascota;
        this.raza = raza;
        this.patas = patas;
        this.vivo = vivo;
    }

    public Mascota(){}

    public Long getIdMascota(){ return idMascota; }

    public Raza getRaza(){
        return raza;
    }
    public void setRaza(Raza raza){
        this.raza = raza;
    }

    public int getPatas(){
        return patas;
    }
    public void setPatas(int patas){
        this.patas = patas;
    }

    public boolean getVivo(){
        return vivo;
    }
    public void setVivo(boolean vivo){
        this.vivo = vivo;
    }

    public boolean isVivo() {
        return vivo;
    }

    public String getGruñir() {
        return gruñir;
    }

    public void setGruñir(String gruñir) {
        this.gruñir = gruñir;
    }
}
