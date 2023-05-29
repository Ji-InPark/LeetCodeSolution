class ParkingSystem {
    int[] max = new int[3];
    int[] cars = new int[3];
    
    public ParkingSystem(int big, int medium, int small) {
        max[0] = big; max[1] = medium; max[2] = small;
    }
    
    public boolean addCar(int carType) {
        return cars[carType - 1]++ < max[carType - 1];
    }
}
