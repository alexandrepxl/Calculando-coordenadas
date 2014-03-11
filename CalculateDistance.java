import java.text.DecimalFormat;

public class CalculateDistance {

	private double result;
	private DecimalFormat fmt;

	public void setDistance(double p1Lat, double p1Lon, double p2Lat,
			double p2Lon) {
		
		
		double constant = 6371.0;

		p1Lat = p1Lat * Math.PI / 180.0;
		p1Lon = p1Lon * Math.PI / 180.0;
		p2Lat = p2Lat * Math.PI / 180.0;
		p2Lon = p2Lon * Math.PI / 180.0;

		double lat = p2Lat - p1Lat;
		double lon = p2Lon - p1Lon;

		double a = Math.sin(lat / 2) * Math.sin(lat / 2) + Math.cos(p1Lat)
				* Math.cos(p2Lat) * Math.sin(lon / 2) * Math.sin(lon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double result = Math.round(constant * c * 1000); // resultado em metros.


		this.result = result;
	}
	

	// Retorna Sting
	public String getDistance() {

		if (result < 1000) {

			fmt = new DecimalFormat("0");
			return fmt.format(result) + "m";

		} else {

			fmt = new DecimalFormat("0.0");
			return fmt.format(result / 1000) + "km";
		}

	}
	
	
	// Retorna double - distância em metros
	public Double getDistanceDouble(){
		
		return result / 1000;
	}

}
