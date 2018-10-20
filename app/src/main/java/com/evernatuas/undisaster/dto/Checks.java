package com.evernatuas.undisaster.dto;

import java.util.Objects;

public class Checks {
    private Long id;
    private Long idDesastre;
    private String titulo;

    public Checks(Long id, Long idDesastre, String titulo, String descripcion) {
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
        Checks checks = (Checks) o;
        return Objects.equals(id, checks.id) &&
                Objects.equals(idDesastre, checks.idDesastre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idDesastre);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Checks{");
        sb.append("id=").append(id);
        sb.append(", idDesastre=").append(idDesastre);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
