
public class maxwealth {
    public static void main(String[] args) {
        int[][] accounts = {
            {1, 2, 3},
            {3, 2, 1},
            {4, 5, 6}
        };
        System.out.println("Maximum wealth: " + maximumWealth(accounts));
    }
    static int maximumWealth(int [][] accounts){
        if(accounts == null || accounts.length == 0){
            return 0; // Array is empty or null
        }
        int maxwealth =0;
        for(int person = 0; person <accounts.length; person++){
            int currentwealth = 0;
            for(int account = 0; account < accounts[person].length; account++){
                currentwealth += accounts[person][account];
            }
             if(currentwealth > maxwealth){
                maxwealth = currentwealth;
            }
        }
           return maxwealth;
        
}
}

       
    