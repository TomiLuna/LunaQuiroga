package juego;



public class DemoColision {
    

public boolean ColisionZombieBala (Zombie z , Bala b ){
    if (z.getX()-(z.getAncho()/2) <= b.getX() + (b.getAncho()/2) && z.getY() == b.getY ()) //verifico la posicion de bala y de zombie

    
    return true;
    
    else 
    return false;


        
    
    
}
}