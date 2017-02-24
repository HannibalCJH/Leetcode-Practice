public class Solution {
    public int CountPrimes(int n) 
    {
        bool[] isPrime = new bool[n];
        for(int i = 2; i < n; i++)
            isPrime[i] = true;
        
        for(int i = 0; i * i < n; i++)
        {
            if(isPrime[i])
            {
                for(int j = i * i; j < n; j += i)
                    isPrime[j] = false;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++)
            if(isPrime[i])
                count++;
        return count;
    }
}
