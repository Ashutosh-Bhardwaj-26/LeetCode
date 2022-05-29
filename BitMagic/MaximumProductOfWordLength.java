import java.util.*;
class MaximumProductOfWordLength {
    static ArrayList<String> arr = new ArrayList<>();

  public static void main(String args[])
  {
   Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of string");
    int n = sc.nextInt();
    sc.nextLine();
    for(int i =0;i<n;i++){
        arr.add(sc.nextLine());
    }

    int k = check(arr);


    System.out.println(k);
   
   sc.close();
  }

  static int check(ArrayList<String> arr){
      int state[]=new int[arr.size()];
      for(int i =0;i<arr.size();i++){
        state[i] = findState(arr.get(i));
      }
      int maxPro = 0;
      for(int i =0;i<arr.size();i++){
        for(int j = i+1;j<arr.size();j++){
            if((state[i] & state[j])==0){
                if(arr.get(i).length() * arr.get(j).length() > maxPro){
                    maxPro = arr.get(i).length() * arr.get(j).length();
                }
            }

        }
      }
      return maxPro;
  }

  static int findState(String s){
      int state = 0;
      for(char c : s.toCharArray()){
        int index = c -'a';
        state |= 1<< (index);
      }
      return state;
  }

}