package repository;

import model.UsuariosModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private static UsuarioRepository instance;
    protected EntityManager entityManager;

    public UsuarioRepository() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static UsuarioRepository getInstance() {
        if (instance == null) {
            instance = new UsuarioRepository();
        }
        return instance;
    }

    public String salvar(UsuariosModel usuario) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            return "Usuário salvo com sucesso.";
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return "Erro ao salvar usuário: " + e.getMessage();
        }
    }

    public List<UsuariosModel> buscarTodos() {
        try {
            List<UsuariosModel> usuarios = entityManager.createQuery("from UsuariosModel").getResultList();
            return usuarios;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public String remover(UsuariosModel usuario) {
        try {
            entityManager.getTransaction().begin();

            if (!entityManager.contains(usuario)) {
                usuario = entityManager.merge(usuario);
            }
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
            return "Usuário removido com sucesso!";
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return "Erro ao remover usuário: " + e.getMessage();
        }
    }


    public UsuariosModel buscarPorId(int id) {
        try {
            return entityManager.find(UsuariosModel.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
