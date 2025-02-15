
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainPass3 {
    static class MNTEntry {
        int index;
        String name;
        int mdtIndex;

        MNTEntry(int index, String name, int mdtIndex) {
            this.index = index;
            this.name = name;
            this.mdtIndex = mdtIndex;
        }
    }

    static class ALAEntry {
        String index;
        String argument;

        ALAEntry(int index, String argument) {
            this.index = "#" + index;
            this.argument = argument.replace(",", ""); // Remove commas
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("ProgramBuff.txt");
            Scanner scanner = new Scanner(file);
            ArrayList<MNTEntry> mnt = new ArrayList<>();
            ArrayList<ALAEntry> ala = new ArrayList<>();
            ArrayList<String> mdt = new ArrayList<>(); // Store macro instructions
            ArrayList<String> alp = new ArrayList<>(); // Store ALP (without macros)
            int mntIndex = 1;
            int mdtIndex = 1;
            boolean isMacro = false;
            boolean isALP = false; // Track ALP section
            Map<String, String> alaMap = new LinkedHashMap<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                // ALP section starts after "START"
                if (line.startsWith("START")) {
                    isALP = true;
                }

                if (isALP) {
                    alp.add(line); // Store ALP instructions
                    continue;
                }

                // Skip MACRO definitions
                if (line.startsWith("MACRO")) {
                    isMacro = true;
                    alaMap.clear(); // Reset ALA for each macro
                    continue;
                }

                if (isMacro) {
                    String[] parts = line.split("\\s+"); // Split by whitespace
                    if (parts.length > 0) {
                        String macroName = parts[0];
                        mnt.add(new MNTEntry(mntIndex++, macroName, mdtIndex));
                        mdt.add(line); // Store macro definition line (unaltered)
                        for (int i = 1; i < parts.length; i++) {
                            String arg = parts[i].replace(",", "");
                            ALAEntry entry = new ALAEntry(i, arg);
                            ala.add(entry);
                            alaMap.put(arg, entry.index); // Map argument to ALA index
                        }
                    }
                    // Process instructions inside the macro
                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine().trim();
                        if (line.startsWith("MEND")) {
                            mdt.add(line); // Store MEND as is
                            mdtIndex = mdt.size() + 1; // Update MDT Index for the next macro
                            break;
                        }
                        // Replace arguments in instruction using ALA mapping
                        for (Map.Entry<String, String> entry : alaMap.entrySet()) {
                            line = line.replace(entry.getKey(), entry.getValue());
                        }
                        mdt.add(line); // Store modified instruction
                    }
                    isMacro = false; // Reset for next macro
                }
            }
            scanner.close();

            // Printing MNT
            System.out.println("MNT:");
            System.out.println("Idx\tMacro Name\tMDT Index");
            for (MNTEntry entry : mnt) {
                System.out.println(entry.index + "\t" + entry.name + "\t\t" + entry.mdtIndex);
            }

            // Printing ALA
            System.out.println("\nALA:");
            System.out.println("Idx\tFormal Argument");
            for (ALAEntry entry : ala) {
                System.out.println(entry.index + "\t" + entry.argument);
            }

            // Printing MDT
            System.out.println("\nMDT:");
            System.out.println("Idx\tInstruction");
            int index = 1;
            for (String instruction : mdt) {
                System.out.println(index++ + "\t" + instruction);
            }

            // Printing ALP (without macro definitions)
            System.out.println("\nALP (Without Macro Definitions):");
            for (String instruction : alp) {
                System.out.println(instruction);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
