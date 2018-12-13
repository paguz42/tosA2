////////////////////////////////////////////////////////////////////
// MANUEL PAGOTTO 1144708
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
    public enum itemType{PIZZE,PRIMI}
    
    private itemType piatto;
    private String nome;
    private double price;

    public MenuItem(itemType piatto, String nome, double price) {
        this.setName(new String(nome));
        this.setPrice(price);
        this.setDish(piatto);
    }

    public itemType getDish(){
        return piatto;
    }

    public void setDish(itemType piatto){
        this.piatto = piatto;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome){
        this.nome = nome;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
