package com.evernatuas.undisaster.dto;

import java.util.Objects;

public class Check {
    private Long id;
    private String titulo;
    private Boolean snMarcado;
    private String masInfo;

    public Check(Long id, String titulo, Boolean snMarcado, String masInfo) {
        this.id = id;
        this.snMarcado = snMarcado;
        this.titulo = titulo;
        this.masInfo = masInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getSnMarcado() {
        return snMarcado;
    }

    public void setSnMarcado(Boolean snMarcado) {
        this.snMarcado = snMarcado;
    }

    public String getMasInfo() {
        return masInfo;
    }

    public void setMasInfo(String masInfo) {
        this.masInfo = masInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check checkList = (Check) o;
        return Objects.equals(id, checkList.id) &&
                Objects.equals(titulo, checkList.titulo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, titulo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Check{");
        sb.append("id=").append(id);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", snMarcado=").append(snMarcado);
        sb.append(", masInfo='").append(masInfo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
