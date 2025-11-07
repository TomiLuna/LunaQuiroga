package juego;



public class DemoColision {
    

public boolean ColisionZombieBala (Zombie z , Bala b){
    if (z.getX()-(z.getAncho()/2) <= b.getX() + (b.getAncho()/2) && z.getY() == b.getY ()) //verifico la posicion de bala y de zombie

    return true;
    
    else 
    return false;

}

public boolean ColisionZombiePlanta (Zombie z , Planta1 p){
    if (z.getX()-(z.getAncho()/2) <= p.getX() + (p.getAncho()/2) && z.getY() == p.getY ()) //verifico la posicion de planta y de zombie

    return true;
    
    else 
    return false;

}

public boolean ColisionZombieNuez (Zombie z, Nuez n) {

    if (z.getX()-(z.getAncho()/2) <= n.getX() + (n.getAncho()/2) && z.getY() == n.getY ()) //verifico la posicion de Nuez y de Zombie


    return true;

    else
    return false; 

}

public boolean ColisionZombieRergalo (Zombie z, Regalo r) {

    if (z.getX()-(z.getAncho()/2) <= r.getX() + (r.getAncho()/2) && z.getY() == r.getY ())  //verifico la posicion de Regalo y de Zombie
    
    return true;

    else 
    return false; 

//if ColisionZombieRergalo devuelve true termina el juego 
}
}
