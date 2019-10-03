package id.ac.polinema.idealbodyweight.util;

public class BMIcalc {
    private float bmi;
    private float mass, height;

    public BMIcalc(float mass, float height) {
        this.mass = mass;
        this.height = height;
        this.calculate();
    }

    public void calculate() {
        this.bmi =
                this.mass / (this.height * this.height);
    }
    public String keterangan(){
        String ket = "";
        if (this.bmi < 18.50) {
            ket = "Underweight";
        } else if (this.bmi >= 18.50 && this.bmi <= 24.99) {
            ket = "Healty Weight";
        } else if (this.bmi > 25) {
            ket = "Overweight";
        }
        return ket;
    }
}
