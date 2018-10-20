package com.evernatuas.undisaster.dto;

import android.content.ContentValues;

import com.evernatuas.undisaster.bo.Item;
import com.evernatuas.undisaster.dao.tables.TablaCheck;

import java.util.Objects;

public class Check {
    private Long id;
    private Long idCheckList;
    private String titulo;
    private Boolean snMarcado;
    private Item item;

    public Check() {
    }

    public Check(Long id, Long idChecklist, String titulo, Boolean snMarcado, Item item) {
        this.id = id;
        this.idCheckList = idChecklist;
        this.snMarcado = snMarcado;
        this.titulo = titulo;
        this.item = item;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(TablaCheck.COLUMN_ID, id);
        values.put(TablaCheck.COLUMN_ID_CHECK, idCheckList);
        values.put(TablaCheck.COLUMN_MARCA, snMarcado);
        values.put(TablaCheck.COLUMN_TITLE, titulo);
        values.put(TablaCheck.COLUMN_ITEM, item.getId());
        return values;
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
