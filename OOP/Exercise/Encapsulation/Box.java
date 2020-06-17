public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setHeight(double height) {
        validateNonNegativeSize(height, "Height");
        this.height = height;
    }

    private void setWidth(double width) {
        validateNonNegativeSize(width, "Width");
        this.width = width;
    }

    private void setLength(double length) {
        validateNonNegativeSize(length, "Length");
        this.length = length;
    }

    private void validateNonNegativeSize(double dimension, String source) {
        if (dimension <= 0) {
            throw new IllegalArgumentException(source + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        double resultSurface = (2 * this.length * this.width)
                + (2 * this.length * this.height)
                + (2 * this.width * this.height);
        return resultSurface;
    }

    public double calculateLateralSurfaceArea() {
        double resultLSA = (2 * this.length * this.height) + (2 * this.width * this.height);
        return resultLSA;
    }

    public double calculateVolume() {
        double resultVolume = (this.length * this.width * this.height);
        return resultVolume;
    }
}