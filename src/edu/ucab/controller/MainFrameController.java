package edu.ucab.controller;

import edu.ucab.model.Usuario;

public class MainFrameController {

    public Usuario getCurrentUser() {
        return (Usuario) Context.getInstance().getContext().get("user");
    }    
}
