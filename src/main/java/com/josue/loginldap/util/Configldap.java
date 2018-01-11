package com.josue.loginldap.util;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

/**
 * loginldap
 * User: josue
 * Date: 11/01/18
 * Time: 12:23
 */
public class Configldap {

    public boolean aut(String usr, String pwd){
        boolean flag = false;

        try {
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, usr+"@josue.cc");
            env.put(Context.SECURITY_CREDENTIALS, pwd);
            env.put(Context.PROVIDER_URL, "ldap://192.168.8.105:389");
            LdapContext ctx = new InitialLdapContext(env,null);
            System.out.println("SE CONECTÓ");
            ctx.close();
            flag = true;
        } catch (NamingException e) {
            flag = false;
            System.out.println("FALLÓ CONEXIÓN");
            e.printStackTrace();
        }

        return flag;
    }

}
