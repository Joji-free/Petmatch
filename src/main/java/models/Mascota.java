package models;

public class Mascota {
    private int idmascota;
    private String nombre;
    private int edad;
    private String raza;
    private String sexo; // Enum: Macho/Hembra
    private String tamaño; // Enum: Pequeño/Mediano/Grande
    private String ubicacion;
    private String fotoUrl;
    private String estado; // Enum: En_celo/Adopcion/Disponible_Socializacion
    private int idUsuario;

    // Getters y Setters
    public int getIdmascota() { return idmascota; }
    public void setIdmascota(int idmascota) { this.idmascota = idmascota; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getTamaño() { return tamaño; }
    public void setTamaño(String tamaño) { this.tamaño = tamaño; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
}
