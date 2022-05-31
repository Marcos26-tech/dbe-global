package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.dao.VisitanteDao;
import br.com.fiap.model.Visitante;
import org.primefaces.model.file.UploadedFile;


import br.com.fiap.service.UploadService;

@Named
@RequestScoped
public class VisitanteBean {

    private Visitante visitante = new Visitante();

    @Inject //injeção de dependencia
    private VisitanteDao dao;

    private UploadedFile image;

    public String save() {
        System.out.println("aqui " + this.visitante);
        visitante.setImagePath( UploadService.write(image, "visitantes"));
        dao.create(visitante);


        FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage("Visitante cadastrado com sucesso"));

        return "visitantes";
    }

    public List<Visitante> getAll(){
        return dao.listAll();
    }


    public Visitante getSetup() {
        return visitante;
    }

    public void setSetup(Visitante setup) {
        this.visitante = setup;
    }

    public UploadedFile getImage() {
        return image;
    }

    public void setImage(UploadedFile image) {
        this.image = image;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }
}
