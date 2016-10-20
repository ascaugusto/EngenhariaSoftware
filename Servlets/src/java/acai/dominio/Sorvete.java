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
public class Sorvete extends AbstractAcai {
    public Sorvete() {
        descricao =  "Sorvete pronto";
    }

    public double cost() {
        return 6;
    }
}
