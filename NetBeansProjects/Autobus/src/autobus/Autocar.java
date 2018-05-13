/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobus;

/**
 *
 * @author ADMINMJ
 */
public class Autocar {
    private String trayecto;
    private int totalFumadores;
    private int totalNoFumadores;
    private int vendidasFum;
    private int vendidasNoFum;
    private float tarifa;

    public Autocar(String t) {
        trayecto=t;
        tarifa=20;
        totalFumadores=20;
        totalNoFumadores=35;
    }

    public Autocar(String trayecto, int totalFumadores, int totalNoFumadores,
            float tarifa) {
        this.trayecto = trayecto;
        this.totalFumadores = totalFumadores;
        this.totalNoFumadores = totalNoFumadores;
        this.tarifa = tarifa;
    }

    /**
     * @return the trayecto
     */
    public String getTrayecto() {
        return trayecto;
    }

    /**
     * @return the totalFumadores
     */
    public int getTotalFumadores() {
        return totalFumadores;
    }

    /**
     * @return the totalNoFumadores
     */
    public int getTotalNoFumadores() {
        return totalNoFumadores;
    }

    /**
     * @return the vendidasFum
     */
    public int getVendidasFum() {
        return vendidasFum;
    }

    /**
     * @return the vendidasNoFum
     */
    public int getVendidasNoFum() {
        return vendidasNoFum;
    }

    /**
     * @return the tarifa
     */
    public float getTarifa() {
        return tarifa;
    }

  public int totalDisponiblesFumador(){
      int dispo;
      dispo=totalFumadores-vendidasFum;
      return dispo;
  }
   public int totalDisponiblesNoFumador(){
       int dispo;
       dispo=totalNoFumadores-vendidasNoFum;
      return dispo;
   } 
   public int totalDispo(){
       return totalDisponiblesFumador()+totalDisponiblesNoFumador();
   }
    
   public void actualizarVendidasFumador(int nbilletes){
       vendidasFum=vendidasFum+nbilletes;
   }
   public void actualizarVendidasNoFumador(int nbilletes){
       vendidasNoFum=vendidasNoFum+nbilletes;
   }
   public void actualizarPlazas(int nbilletes, String tipoPlazas)
   {
       if(tipoPlazas.equalsIgnoreCase("fumador"))
       {
           actualizarVendidasFumador(nbilletes);
       }
       else
       {
            actualizarVendidasNoFumador(nbilletes);
       }
   }
   public int plazasDisponibles(String tipo)
   {
      int plazas;
      if(tipo.equalsIgnoreCase("fumador"))
          plazas=totalDisponiblesFumador();
      else
          plazas=totalDisponiblesNoFumador();
      return plazas;
   }
}
