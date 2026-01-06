

// public class Linearstrsearch {
//     public static void main(String[] args) {
//         String[] strings = {"apple", "banana", "cherry", "date", "fig", "grape"};
//         String target = "cherry";
//        linearsearch(strings, target);
//     }

//     static String linearsearch(String[] str, String target) {
//             if(str == null || str.length == 0){
//                 System.out.println("array is empty or null");
//             }
//             for(int i=0;i<str.length;i++){
//                 if(str[i].equals(target)){
//                     System.out.println("Element found at index " + i);
//                     return str[i]; // Element found at index i
//                 }
//             }
//             return "Element not found"; // Element not found
//     }
    
// }


public class Linearstrsearch {
    public static void main(String[] args) {
        String string = "cherry";
        char target = 'y';
       linearsearch(string, target);
    }

    static String  linearsearch(String str, char target) {
            if(str == null || str.length() == 0){
                System.out.println("array is empty or null");
            }
            for(int i=0;i<str.length();i++){
                if(target == str.charAt(i)){
                    System.out.println("Element found at index " + i);
                   // Element found at index i
                }
            }
            return "element not found"; // Element not found
    }
}
