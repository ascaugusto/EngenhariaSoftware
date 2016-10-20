/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acai.dominio;

/**
 *
 * @author AsC
 */
public abstract class AbstractAcai {
    
    String descricao = "Acai sendo Feito";
    
    public String getDescription(){
        return descricao;
    }
    public AbstractAcai(){
    }
    public abstract double cost();
}
