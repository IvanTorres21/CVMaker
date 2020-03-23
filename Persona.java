import java.util.HashMap;

public class Persona {
  
  private String nombre;
  private String edad; // Es un string por comodidad, ya que no va a tener que hacer operaciones sobre el
  private String email;
  private String direc;
  private String telf;
  private String foto;
  private HashMap<String, String> formacion = new HashMap<String, String>();
  private HashMap<String, String> experiencia = new HashMap<String, String>();
  
  // Getters y Setters
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public String getEdad() {
    return edad;
  }
  public void setEdad(String edad) {
    this.edad = edad;
  }
  
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getDirec() {
    return direc;
  }
  public void setDirec(String direc) {
    this.direc = direc;
  }
  
  public String getTelf() {
    return telf;
  }
  public void setTelf(String telf) {
    this.telf = telf;
  }
  
  public String getFoto() {
    return foto;
  }
  public void setFoto(String foto) {
    this.foto = foto;
  }
  
  public HashMap<String, String> getFormacion() {
    return formacion;
  }
  public void setFormacion(HashMap<String, String> formacion) {
    this.formacion = formacion;
  }
  
  public HashMap<String, String> getExperiencia() {
    return experiencia;
  }
  public void setExperiencia(HashMap<String, String> experiencia) {
    this.experiencia = experiencia;
  }
  
  // Constructor
  
  public Persona() {
    
  }
  // Funciones
  
  public void addForm(String name, String anio) {
    
    this.formacion.put(name, anio);
  }
  public void addExp(String name, String time) {
    
    this.experiencia.put(name, time);
  }
}
