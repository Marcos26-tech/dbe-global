package br.com.fiap.dao;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.fiap.model.Visitante;

public class VisitanteDao {

    @Inject
    private EntityManager manager;

    public void create(Visitante visitante) {
        manager.getTransaction().begin();
        manager.persist(visitante);
        manager.getTransaction().commit();

        manager.clear();
    }

    public List<Visitante> listAll() {
        TypedQuery<Visitante> query = manager.createQuery("SELECT u FROM Visitante u", Visitante.class);
        return query.getResultList();
    }
}