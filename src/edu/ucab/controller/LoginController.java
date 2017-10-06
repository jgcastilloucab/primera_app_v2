package edu.ucab.controller;

import edu.ucab.dao.UsuarioFacade;
import edu.ucab.model.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jgcastillo
 */
public class LoginController {

    private final UsuarioFacade usuarioFacade;

    public LoginController() {
        this.usuarioFacade = new UsuarioFacade();
    }
    
    public boolean checkDataBase(){
        boolean connectionOk = false;
        List<Usuario> usuarios = usuarioFacade.findAll();
        if(usuarios != null){
            connectionOk = true;
        }
        return connectionOk;
    }

    public boolean checkUsr(String user, String psw) {
        if (user != null && (!user.equals("Indique su usuario")
                || !user.isEmpty())) {
            Optional<Usuario> optUsr = usuarioFacade.findByName(user);
            if (optUsr.isPresent()) {
                System.out.println("encontró a " + optUsr.get().getName());
                Usuario usr = optUsr.get();
                if (user.equalsIgnoreCase(usr.getUsername())
                        && psw.equals(usr.getPsw())) {
                    Context.getInstance().getContext().put("user", usr);
                    return true;
                }
            }
        }
        return false;
    }
    
}
