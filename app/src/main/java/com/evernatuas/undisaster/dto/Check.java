package com.evernatuas.undisaster.dto;

import com.evernatuas.undisaster.bo.Item;

import java.util.Objects;

public class Check {
    private Long id;
    private Long idCheckList;
    private String titulo;
    private Boolean snMarcado;
    private Item item;

    public Check(Long id, String titulo, Boolean snMarcado) {
        this.id = id;
        this.snMarcado = snMarcado;
        this.titulo = titulo;
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

    public Long getIdCheckList() {
        return idCheckList;
    }

    public void setIdCheckList(Long idCheckList) {
        this.idCheckList = idCheckList;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return Objects.equals(id, check.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Check{");
        sb.append("id=").append(id);
        sb.append(", idCheckList=").append(idCheckList);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", snMarcado=").append(snMarcado);
        sb.append(", item=").append(item);
        sb.append('}');
        return sb.toString();
    }
}
