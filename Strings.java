public class Strings {
    public static void main(String[] args)
    {
        String sentence = "I am learning java";

        System.out.println(sentence);

        // printing the substring 
        System.out.println(sentence.substring(0, 4));

        // Strings are immutable 
        // so we can't change the original string
        sentence = sentence.substring(0, 4);
        System.out.println(sentence);
        System.out.println("sentence: ", sentence);
        // System.out.println(print ln is out there );
        System.out.println("println is x is not provided is not mature       ");
    }
}    
