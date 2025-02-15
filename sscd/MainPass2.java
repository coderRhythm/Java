import java.io.*;
import java.util.*;

class MainPass2 {
    static int LC = 0;
    static int literalIndex = 1;
    static int poolIndex = 1;

    static Map<String, String> optable = new LinkedHashMap<>();
    static Map<String, Integer> literalTable = new LinkedHashMap<>();
    static List<String[]> intermediateCode = new ArrayList<>();
    static Map<String, Integer> literalLCMap = new LinkedHashMap<>();
    static Map<String, Integer> literalIndexMap = new LinkedHashMap<>();
    static List<Integer> poolTable = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("programLiteral.txt"));

        optable.put("START", "AD01");
        optable.put("END", "AD02");
        optable.put("ORIGIN", "AD03");
        optable.put("EQU", "AD04");
        optable.put("LTORG", "AD05");
        optable.put("DC", "DL01");
        optable.put("DS", "DL02");
        optable.put("ADD", "IS01");
        optable.put("SUB", "IS02");
        optable.put("MULT", "IS03");
        optable.put("MOVER", "IS04");
        optable.put("MOVEM", "IS05");
        optable.put("COMP", "IS06");
        optable.put("BC", "IS07");
        optable.put("DIV", "IS08");
        optable.put("READ", "IS09");
        optable.put("PRINT", "IS10");

        String line;
        poolTable.add(literalIndex);

        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\s+");
            String opcode = parts[0];
            String operand1 = parts.length > 1 ? parts[1] : "";
            String operand2 = parts.length > 2 ? parts[2] : "";

            String code = optable.get(opcode);

            if (code != null) {
                if (code.startsWith("AD")) {
                    if (opcode.equals("START")) {
                        LC = Integer.parseInt(operand1);
                        intermediateCode.add(new String[] { code, "", "",
                                operand1 });
                    } else if (opcode.equals("LTORG") ||
                            opcode.equals("END")) {
                        for (Map.Entry<String, Integer> entry : literalTable.entrySet()) {
                            if (entry.getValue() == -1) {
                                literalTable.put(entry.getKey(), LC);
                                literalLCMap.put(entry.getKey(), LC);
                                literalIndexMap.put(entry.getKey(), literalIndex++);
                                LC++;
                            }
                        }
                        if (opcode.equals("LTORG")) {
                            poolTable.add(literalIndex); //
                        }
                        intermediateCode.add(new String[] { code, "", "", "" });
                    } else {
                        intermediateCode.add(new String[] { code, "", "",
                                operand1 });
                    }
                } else if (code.startsWith("IS")) {
                    if (operand2.startsWith("='")) {
                        if (!literalTable.containsKey(operand2)) {
                            literalTable.put(operand2, -1);
                        }
                        intermediateCode.add(new String[] { code, operand1,
                                operand2, "" });
                    } else {
                        intermediateCode.add(new String[] { code, operand1,
                                operand2, "" });
                    }
                    LC++;
                }
            }
        }

        for (Map.Entry<String, Integer> entry : literalLCMap.entrySet()) {
            literalTable.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Optable:");
        for (Map.Entry<String, String> entry : optable.entrySet()) {
            System.out.println(entry.getKey() + " -------- " +
                    entry.getValue());
        }

        System.out.println("\nLiteral Table:");
        int literalCounter = 1;
        for (Map.Entry<String, Integer> entry : literalTable.entrySet()) {
            System.out.println(literalCounter + "  " + entry.getKey() + " -------- " + entry.getValue());
            literalCounter++;
        }

        System.out.println("\nPool Table:");
        System.out.printf("%-10s%-15s%-10s%n", "Index", "Pool Number", "LC Value");

        for (int i = 0; i < poolTable.size(); i++) {
            System.out.printf("%-10d%-15s%-10d%n", i + 1, "P" + (i +
                    1), poolTable.get(i));
        }

        System.out.println("\nIntermediate Code:");
        System.out.printf("%-10s%-10s%-15s%-15s%n", "LC",
                "Opcode", "Operand 1", "Operand 2");

        int initialLC = Integer.parseInt(intermediateCode.get(0)[3]);
        LC = initialLC;
        for (String[] codeLine : intermediateCode) {
            String lcString = codeLine[0].startsWith("AD") ? "" : String.valueOf(LC++);

            String operand2 = codeLine[2];
            if (literalLCMap.containsKey(operand2)) {
                operand2 = "L," +
                        String.valueOf(literalIndexMap.get(operand2));
            }

            System.out.printf("%-10s%-10s%-15s%-15s%n", lcString,
                    codeLine[0], codeLine[1], operand2);
        }
    }
}