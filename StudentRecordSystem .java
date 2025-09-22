import java.io.*;
import java.util.*;

public class StudentRecordSystem {

    static String fileName = "students.txt";

    // Create or write new records
    public static void createRecord(String record) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(record + "\n");
            System.out.println("Record created successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Append new record
    public static void appendRecord(String record) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(record + "\n");
            System.out.println("Record appended successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Read all records
    public static void readRecords() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n--- Student Records ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update record (simple replace old with new)
    public static void updateRecord(String oldRecord, String newRecord) {
        try {
            File inputFile = new File(fileName);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(oldRecord)) {
                    writer.write(newRecord + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }
            writer.close();
            reader.close();

            // Replace old file with updated file
            inputFile.delete();
            tempFile.renameTo(inputFile);

            System.out.println("Record updated successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Create Record");
            System.out.println("2. Append Record");
            System.out.println("3. Read Records");
            System.out.println("4. Update Record");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student record: ");
                    String rec1 = sc.nextLine();
                    createRecord(rec1);
                    break;

                case 2:
                    System.out.print("Enter student record: ");
                    String rec2 = sc.nextLine();
                    appendRecord(rec2);
                    break;

                case 3:
                    readRecords();
                    break;

                case 4:
                    System.out.print("Enter old record to update: ");
                    String oldR = sc.nextLine();
                    System.out.print("Enter new record: ");
                    String newR = sc.nextLine();
                    updateRecord(oldR, newR);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}

