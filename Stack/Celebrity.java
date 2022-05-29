class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
        ArrayDeque<Integer> s = new ArrayDeque<>();
    
        for(int i =0;i<n;i++){
            s.push(i);
        }
    
        while(s.size()!=1){
            int i = s.pop();
            int j = s.pop();
            if(arr[i][j]==1){
                s.push(j);
            }
            else{
                s.push(i);
            }
        }
    
        int pot = s.pop();
        boolean isC = true;
        for(int i =0;i<n;i++){
            if(arr[pot][i]!=0) isC = false;
        }
    
        for(int i =0;i<n;i++){
            if(i!=pot && arr[i][pot]!=1) isC = false;
        }
    
        if(isC){
          return pot;
        }else{
            return -1;
        }
    }
}