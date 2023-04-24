package lab06_punkt;
public class Prostokat extends Figura {
	double wys=0, szer=0;
	
	Prostokat(double wys){
		this.wys = wys;
		this.szer = szer;
	}

	public Prostokat(String kolor, double wys, double szer) {
		super(kolor);
		this.wys = wys;
		this.szer = szer;
	}

	double getPowierzchnia() {
        return (szer * wys);
    }
	public String wyswietl(){
		return "kolor: "+ kolor + "wysokosc: "+wys+"szerokosc: "+szer;
	}
	public void przesun(Punkt pkt){
		szer += pkt.x;
		wys += pkt.y;
	}
    
    
}