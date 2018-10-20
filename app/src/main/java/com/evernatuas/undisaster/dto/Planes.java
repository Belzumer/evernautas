package com.evernatuas.undisaster.dto;

import java.util.Objects;

public class Planes {
    private Long id;
    private Long idDesastre;
    private String titulo;

    public Planes(Long id, Long idDesastre, String titulo) {
        this.id = id;
        this.idDesastre = idDesastre;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDesastre() {
        return idDesastre;
    }

    public void setIdDesastre(Long idDesastre) {
        this.idDesastre = idDesastre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planes planes = (Planes) o;
        return Objects.equals(id, planes.id) &&
                Objects.equals(idDesastre, planes.idDesastre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idDesastre);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Planes{");
        sb.append("id=").append(id);
        sb.append(", idDesastre=").append(idDesastre);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
