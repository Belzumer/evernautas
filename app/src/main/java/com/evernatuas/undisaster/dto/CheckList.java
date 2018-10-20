package com.evernatuas.undisaster.dto;

import android.content.ContentValues;

import com.evernatuas.undisaster.dao.tables.TablaChecklist;

import java.util.Objects;

public class CheckList {
    private Long id;
    private Long idDesastre;
    private String titulo;

    public CheckList() {
    }
    public CheckList(Long id, Long idDesastre, String titulo) {
        this.id = id;
        this.idDesastre = idDesastre;
        this.titulo = titulo;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(TablaChecklist.COLUMN_ID, id);
        values.put(TablaChecklist.COLUMN_ID_DESASTRE, idDesastre);
        values.put(TablaChecklist.COLUMN_TITLE, titulo);
        return values;
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
        CheckList checks = (CheckList) o;
        return Objects.equals(id, checks.id) &&
                Objects.equals(idDesastre, checks.idDesastre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idDesastre);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckList{");
        sb.append("id=").append(id);
        sb.append(", idDesastre=").append(idDesastre);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
