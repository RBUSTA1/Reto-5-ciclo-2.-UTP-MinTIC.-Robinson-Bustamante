package reto4.model.vo;

public class ProyectoPorTipo {
    private Integer id_p;
    private String constructora;
    private String ciudad;
    private Integer estrato;

    public Integer getId_p() {
        return id_p;
    }
    public void setId_p(Integer id_p) {
        this.id_p = id_p;
    }
    public String getConstructora() {
        return constructora;
    }
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public Integer getEstrato() {
        return estrato;
    }
    public void setEstrato(Integer estrato) {
        this.estrato = estrato;
    }
}
