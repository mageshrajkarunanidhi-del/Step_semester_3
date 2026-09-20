class Locker {
    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public void changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678"); // success
        l.changeCode("0000", "9999"); // rejected

        System.out.println(l.getLockerNumber());
    }
}