import java.time.LocalDate;
import java.util.*;

interface LibraryItem {
    int getBorrowingDays();

    default LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getBorrowingDays());
    }
}

class Book implements LibraryItem {
    @Override
    public int getBorrowingDays() {
        return 14;
    }
}

class DVD implements LibraryItem {
    @Override
    public int getBorrowingDays() {
        return 7;
    }
}

class Magazine implements LibraryItem {
    @Override
    public int getBorrowingDays() {
        return 3;
    }
}

class LibraryItemFactory {
    public static LibraryItem create(String type) {
        return switch (type) {
            case "BOOK" -> new Book();
            case "DVD" -> new DVD();
            case "MAGAZINE" -> new Magazine();
            default -> throw new IllegalArgumentException("Invalid item type");
        };
    }
}

public class Main2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());

            LocalDate currentDate = LocalDate.of(2023, 10, 26);

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();

                String[] parts = line.split(" ", 2);

                String type = parts[0];
                String title = parts[1].replace("\"", "");

                LibraryItem item = LibraryItemFactory.create(type);

                LocalDate dueDate = item.calculateDueDate(currentDate);

                System.out.println(title + ": " + dueDate);
            }
        }
    }
}