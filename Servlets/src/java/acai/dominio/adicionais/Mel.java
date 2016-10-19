/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acai.dominio.adicionais;

import acai.dominio.AbstractAcai;
import acai.dominio.Acai;
import acai.dominio.IngredientesAdicionais;

/**
 *
 * @author AsC
 */
public class Mel extends IngredientesAdicionais {
    public Mel(AbstractAcai acai){
        this.acai = acai;
    }
    @Override
    public String getDescription() {
        return acai.getDescription() + " com Mel";
    }

    @Override
    public double cost() {
        return 0.5 + acai.cost();
    }
    
}
