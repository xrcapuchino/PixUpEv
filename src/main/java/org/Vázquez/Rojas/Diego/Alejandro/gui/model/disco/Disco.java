package org.Vázquez.Rojas.Diego.Alejandro.gui.model.disco;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista.Artista;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.catalogo.Catalogo;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disquera.Disquera;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.genero.Genero;

import java.time.LocalDate;

public class Disco extends Catalogo
{
    private String titulo;
    private float precio;
    private int existencia;
    private float descuento;
    private LocalDate fecha;
    private String imagen;

    private Disquera disquera;
    private Artista artista;
    private Genero genero;

    private Integer disquera_id;
    private Integer artista_id;
    private Integer genero_id;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Disquera getDisquera() {
        return disquera;
    }

    public void setDisquera(Disquera disquera) {
        this.disquera = disquera;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getDisquera_id() {
        return disquera_id;
    }

    public void setDisquera_id(Integer disquera_id) {
        this.disquera_id = disquera_id;
    }

    public Integer getArtista_id() {
        return artista_id;
    }

    public void setArtista_id(Integer artista_id) {
        this.artista_id = artista_id;
    }

    public Integer getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(Integer genero_id) {
        this.genero_id = genero_id;
    }

    @Override
    public String toString() {
        return  "ID del disco = " + id +
                ", titulo='" + titulo + '\'' +
                ", precio=$" + precio +
                ", unidades en existencia=" + existencia +
                ", descuento=" + descuento*100+"%"+
                ", fecha=" + fecha +
                ", imagen='" + imagen + '\'' +
                ", Id artista=" + artista +
                ", Id disquera=" + disquera +
                ", Id genero=" + genero;
    }
}
