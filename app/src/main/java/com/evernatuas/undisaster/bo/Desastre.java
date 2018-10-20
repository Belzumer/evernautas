package com.evernatuas.undisaster.bo;

import java.util.Objects;

public abstract class Desastre {
    private Long idDesastre;

    public Long getIdDesastre() {
        return idDesastre;
    }

    public void setIdDesastre(Long idDesastre) {
        this.idDesastre = idDesastre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desastre desastre = (Desastre) o;
        return Objects.equals(idDesastre, desastre.idDesastre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDesastre);
    }
}
