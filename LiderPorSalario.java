package reto4.model.vo;

public class LiderPorSalario {
    private String nombre;
    private String apellido;
    private Integer id_lider;
    private Integer salario;

    public LiderPorSalario(){
        
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getId_lider() {
        return id_lider;
    }
    public void setId_lider(Integer id_lider) {
        this.id_lider = id_lider;
    }
    public Integer getSalario() {
        return salario;
    }
    public void setSalario(Integer salario) {
        this.salario = salario;
    }
}