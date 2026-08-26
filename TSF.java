public class TSF {
    public static void simulateTrafficSignal(int cycles) {
        int stateIndex = 0; // 0 = Red, 1 = Green, 2 = Yellow

        for (int i = 0; i < cycles; i++) {
            switch (stateIndex) {
                case 0:
                    System.out.println("Red - Stop");
                    break;
                case 1:
                    System.out.println("Green - Go");
                    break;
                case 2:
                    System.out.println("Yellow - Prepare to stop");
                    break;
            }
            // Advance state using modulus operator for wraparound back to Red
            stateIndex = (stateIndex + 1) % 3;
        }
    }

    public static void main(String[] args) {
        simulateTrafficSignal(3);
    }
} 
