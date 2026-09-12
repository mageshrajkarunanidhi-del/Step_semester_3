class HallTicket {
    private final String studentName;
    private int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}

public class M4 {
    public static void main(String[] args) {

        HallTicket priya =
                new HallTicket("Priya", 0);

        HallTicket copy = priya;

        copy.setSeatNumber(45);

        HallTicket separate =
                new HallTicket("Priya", 45);

        System.out.println(
                "Priya's name (via getter): " + priya.getStudentName()
        );

        System.out.println(
                "Priya's seatNumber (via first variable): "
                        + priya.getSeatNumber()
        );

        System.out.println("copy == priya: " + (copy == priya));

        System.out.println(
                "separate == priya: " + (separate == priya)
        );
    }
}