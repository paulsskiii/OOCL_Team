class ShipOverloadException extends Exception {
    public ShipOverloadException(String message) {
        super(message);
    }

    // If current weight + cargoweight exceeds ship capacity, throw
    // ship overloadexception
    public boolean isExceeded(int currentWeight, int cargoWeight, int shipCapacity) throws ShipOverloadException {
        
        if ((currentWeight + cargoWeight) < shipCapacity) {
            return true;
        } else {
            throw new ShipOverloadException("Ship capacity exceeded.");
        }
        
    }
}