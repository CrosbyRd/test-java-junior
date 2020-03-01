public class Automoviles{
    
	private String color;
	private int puertas;
	private int ruedas;
	private float kilometraje;
	private String chasis;
	private String marca;
	protected boolean acelerar;
	protected boolean frenar;
	protected boolean prender;
	protected boolean apagar;
	//Los automóviles deben poder simular las operaciones de acelerar, frenar, prenderse y apagarse.

	Automoviles(String color, int puertas, int ruedas, float kilometraje, String chasis, String marca){
		this.color=color;
		this.puertas=puertas;
		this.ruedas=ruedas;
		this.kilometraje=kilometraje;
		this.chasis=chasis;
		this.marca=marca;
	}
	public void acelerar(){
		if(this.prender){
			this.acelerar=true;
			this.frenar=false;
			System.out.println("El vehiculo acelera");
		}else{
			System.out.println("No puede acelerar un vehiculo apagado");
		}
		
	}

	public void frenar(){
		if(this.prender){
			this.frenar=true;
			this.acelerar=false;
			System.out.println("El vehiculo frena");
		}else{
			System.out.println("No puede frenar un vehiculo apagado");
		}
	}

	public void prender(){
		if(this.prender){
			System.out.println("El vehiculo ya se encuentra encendido");
		}else{
			this.prender=true;
			this.apagar=false;
			System.out.println("El vehiculo se encendio");
		}
		
	}

	public void apagar(){
		if(this.apagar){
			System.out.println("El vehiculo ya se encuentra apagado");
		}else{
			this.apagar=true;
			this.prender=false;
			System.out.println("El vehiculo se ha apagado");
		}
		
	}

	public void setColor(String color){
		this.color=color;
	}

	public String getColor(){
		return this.color;
	}

	public void setPuertas(int puertas){
		this.puertas=puertas;
	}

	public int getPuertas(){
		return this.puertas;
	}

	public void setRuedas(int ruedas){
		this.ruedas=ruedas;
	}

	public int getRuedas(){
		return this.ruedas;
	}

	public void setKilometraje(float km){
		this.kilometraje=km;
	}

	public float getKilometraje(){
		return this.kilometraje;
	}

	public void setChasis(String chasis){
		this.chasis=chasis;
	}

	public String getChasis(){
		return this.chasis;
	}

	public void setMarca(String marca){
		this.marca=marca;
	}

	public String getMarca(){
		return this.marca;
	}
}