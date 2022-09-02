package electronics;

/**
 * Creates framework for Cell Phone description to be developed
 *
 * @version 1.0
 * @author Trev
 * @see PortableElectronics
 */
public class CellPhone extends PortableElectronics {

    private String phoneNumber;
    private boolean hasCamera;
    private String cam;

    /**
     * Sets parameter values to class values
     *
     * @param eManufacturer
     * @param ePrice
     * @param eWeight
     * @param number
     * @param camera
     * @param Type
     */
    public CellPhone(String eManufacturer, double ePrice, double eWeight,
            String number, boolean camera, String Type) {
        super(eManufacturer, ePrice, eWeight, Type);

        // Sets values
        this.manufacturer = eManufacturer;
        this.price = ePrice;
        this.weight = eWeight;
        this.phoneNumber = number;
        this.hasCamera = camera;
        this.batteryType = Type;

        // Determines display if phone can take pictures
        if (takesPictures() == true) {
            cam = "can take pictures";
        } else {
            cam = "cannot take pictures";
        }
    }

    /**
     * Allows String batteryType to be called by method batteryType
     *
     * @return this.batteryType
     */
    public String batteryType() {
        return this.batteryType;
    }

    /**
     * Allows phoneNumber to be called by getNumber
     *
     * @return phoneNumber
     */
    public String getNumber() {
        return phoneNumber;
    }

    /**
     * Sets true or false value for takePictures
     *
     * @return
     */
    public boolean takesPictures() {
        boolean hasCam = hasCamera;

        return hasCam;
    }

    /**
     * Displays structure for description
     *
     * @return CellPhone description
     */
    @Override
    public String toString() {
        return String.format("Cell Phone\nPhone Number: %1$s\nPhone %2$s"
        + "\nMaufactured by %3$s\nThe Price is $%4$.2f\nWeight of %5$.2f oz.\n",
        phoneNumber, cam, manufacturer, price, weight);
    }
}
