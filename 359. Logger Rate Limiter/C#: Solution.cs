public class Logger {
    Dictionary<string, int> map;

    /** Initialize your data structure here. */
    public Logger() 
    {
        map = new Dictionary<string, int>();    
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public bool ShouldPrintMessage(int timestamp, string message) 
    {
        if(map.ContainsKey(message) && timestamp - map[message] < 10)
            return false;
            
        if(map.ContainsKey(message))
        {
            map[message] = timestamp;
        }
        else
        {
            map.Add(message, timestamp);
        }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * bool param_1 = obj.ShouldPrintMessage(timestamp,message);
 */
