package edu.ucab.dao;

import edu.ucab.model.Usuario;
import edu.ucab.uilities.Utilities;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioFacade extends AbstractFacade<Usuario>{

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return Utilities.getEMF().createEntityManager();
    }
    
    public Optional<Usuario> findByName(String nombre){
        Optional<Usuario> optUser = Optional.empty();
        try {
            String query = "FROM Usuario u WHERE u.username = :nombre";
            TypedQuery<Usuario> q = getEntityManager().createQuery(query, Usuario.class);
            q.setParameter("nombre", nombre);
            optUser = Optional.ofNullable(q.getSingleResult());
        } catch (Exception e) {
            Logger.getLogger(UsuarioFacade.class.getName()).log(Level.SEVERE, e.getMessage());
        }
        return optUser;
    }
}
