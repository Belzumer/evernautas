package com.evernatuas.undisaster.dto;

import java.util.Objects;

public class PlanAccion {
    private Long id;
    private Integer posicion;
    private String titulo;
    private String descripcion;

    public PlanAccion(Long id, Integer posicion, String titulo, String descripcion) {
        this.id = id;
        this.posicion = posicion;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanAccion that = (PlanAccion) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(posicion, that.posicion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, posicion);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanAccion{");
        sb.append("id=").append(id);
        sb.append(", posicion=").append(posicion);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
