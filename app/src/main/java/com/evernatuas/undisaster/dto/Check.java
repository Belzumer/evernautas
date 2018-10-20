package com.evernatuas.undisaster.dto;

import com.evernatuas.undisaster.bo.Item;

import java.util.Objects;

public class Check {
    private Long id;
    private Long idChecklist;
    private Boolean snMarcado;
    private Item item;
    private Long cantidad;

    public Check(Long id, Long idChecklist, Boolean snMarcado, Item item, Long cantidad) {
        this.id = id;
        this.snMarcado = snMarcado;
        this.idChecklist = idChecklist;
        this.item = item;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdChecklist() {
        return idChecklist;
    }

    public void setIdChecklist(Long idChecklist) {
        this.idChecklist = idChecklist;
    }

    public Boolean getSnMarcado() {
        return snMarcado;
    }

    public void setSnMarcado(Boolean snMarcado) {
        this.snMarcado = snMarcado;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return Objects.equals(id, check.id) &&
                Objects.equals(idChecklist, check.idChecklist);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idChecklist);
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", idChecklist=" + idChecklist +
                ", snMarcado=" + snMarcado +
                ", item=" + item +
                ", cantidad=" + cantidad +
                '}';
    }
}
