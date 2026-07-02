class Solution {
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }



    

        for (int i = 2; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {

                return false;
            }
        }

        return true;
    }
    
    public int countPrimeSetBits(int left, int right) {

        int count = 0;

        for(int i =left; i <= right; i++) {
           
           int n = i;
           int setbits = 0;
           while(n > 0) {
            if(n % 2 == 1) {
                setbits++;
            }
            n = n / 2;

           }
           if (isPrime(setbits)) {
                count++;
           }
          
            

        }
        return count;
        
    }
    
}