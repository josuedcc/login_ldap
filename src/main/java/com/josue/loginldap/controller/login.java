package com.josue.loginldap.controller;

import com.josue.loginldap.modelo.Usuarios;
import com.josue.loginldap.util.Configldap;
import org.springframework.web.bind.annotation.*;

/**
 * loginldap
 * User: josue
 * Date: 11/01/18
 * Time: 11:24
 */

@RestController
@RequestMapping("/aut")
public class login {

    private Configldap configldap = new Configldap();

    @PostMapping("/login")
    public boolean aut(@RequestBody Usuarios usuarios){
        System.out.println(usuarios.getNombre());
        return configldap.aut(usuarios.getNombre(),usuarios.getPassword());
    }
}
