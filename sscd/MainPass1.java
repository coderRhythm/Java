import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MainPass1 {
    public static void main(String[] args) {
        HashMap<String, String[]> opttable = new HashMap<>();
        opttable.put("START", new String[]{"AD", "01"});
        opttable.put("ADD", new String[]{"IS", "01"});
        opttable.put("MOVEM", new String[]{"IS", "02"});
        opttable.put("SUB", new String[]{"IS", "04"});
        opttable.put("DC", new String[]{"DL", "01"});
        opttable.put("DS", new String[]{"DL", "02"});
        // opttable.put("END", new String[]{"AD", "02"});
        opttable.put("MOVER", new String[]{"IS", "03"});

        HashMap<String, String> regTable = new HashMap<>();
        regTable.put("AREG", "01");
        regTable.put("BREG", "02");
        regTable.put("CREG", "03");
        regTable.put("DREG", "04");

        HashMap<String, String[]> symTab = new HashMap<>();
        symTab.put("A1", new String[]{"S", "01"});
        symTab.put("A2", new String[]{"S", "02"});
        symTab.put("5", new String[]{"C", "05"});
        symTab.put("3", new String[]{"C", "03"});


        ArrayList<String> LocationCtr = new ArrayList<>();
        ArrayList<String[]> optCode = new ArrayList<>();
        ArrayList<String> op1 = new ArrayList<>();
        ArrayList<String[]> op2 = new ArrayList<>();

        int locCtr = 0;
        File file = new File("practice.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                // System.out.println(tokens);

                if (tokens[0].equals("START")) {
                    System.out.println("Staret yaaha se");
                    locCtr = Integer.parseInt(tokens[1]);
                    LocationCtr.add("-");
                    optCode.add(opttable.get(tokens[0]));
                    op1.add("-");
                    op2.add(new String[]{"C", Integer.toString(locCtr)});
                } 
                else if (tokens[0].equals("END")) {
                    op2.add(new String[]{"-","-"});
                    op1.add("-");
                    System.out.println("This is end");
                    // break;
                }
                else {
                    if (tokens.length > 0) {
                        System.out.println("fff");
                        if (opttable.containsKey(tokens[0])) {
                            optCode.add(opttable.get(tokens[0]));
                            if (tokens.length > 1) {
                                if (regTable.containsKey(tokens[1])) {
                                    op1.add(regTable.get(tokens[1]));
                                    if (tokens.length > 2) {
                                        op2.add(symTab.get(tokens[2]));
                                    }
                                } else {
                                    if (symTab.containsKey(tokens[1])) {
                                        System.out.println("kk");
                                        op2.add(symTab.get(tokens[1]));
                                        op1.add("-");
                                        
                                    }
                                }
                            }
                        } else if (opttable.containsKey(tokens[1])) {
                            optCode.add(opttable.get(tokens[1]));
                            if (tokens.length > 2) {
                                if (symTab.containsKey(tokens[2])) {
                                    op2.add(symTab.get(tokens[2]));
                                    op1.add("-");
                                }
                            }
                        } 
                    }
                    LocationCtr.add(Integer.toString(locCtr));
                    locCtr++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

//         // Print table header
// System.out.printf("%-10s %-10s %-10s %-10s\n", "LOC", "OPT CODE", "OP1", "OP2");
// System.out.println("--------------------------------------------------------------");

// // Print table rows
// for (int i = 0; i < optCode.size(); i++) {
//     String loc = (i < LocationCtr.size()) ? LocationCtr.get(i) : "-";
//     String opCodeStr = String.join(",", optCode.get(i));
//     String op1Str = (i < op1.size()) ? op1.get(i) : "-";
//     String op2Str = "-";

//     if (i < op2.size() && op2.get(i) != null) {
//         op2Str = String.join(",", op2.get(i));  // Joining both parts (e.g., "C,200")
//     }

//     System.out.printf("%-10s %-10s %-10s %-10s\n", loc, opCodeStr, op1Str, op2Str);
// }

    // try{
            
    // }
        System.out.println(op1);
        // System.out.println(op2);

    for(int i=0; i<LocationCtr.size(); i++)
    {
        System.out.print(LocationCtr.get(i));
        System.out.print("\t");
        
        

    }
System.out.println("");
    for(String[] it: op2)
    {
        for(String elem: it)
        {
            System.out.print(elem);
            System.out.print(",");
            

        }
        System.out.println("");
    }
        
    }
}
