public class EarthVolume {
    public static void main(String[] args) {
        double radiusKm=6378;
        double conversionFactor=0.621;
        double volumeKm=(4.0/3)*Math.PI*Math.pow(radiusKm,3);
        double volumeMiles=volumeKm*Math.pow(conversionFactor,3);
        System.out.println("The volume of earth in cubic kilometers is "+volumeKm+" and cubic miles is "+volumeMiles);
    }
}