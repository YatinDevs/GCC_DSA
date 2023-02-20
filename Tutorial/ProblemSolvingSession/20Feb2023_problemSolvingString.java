public static void StringRearrange(String[] args) {
        // Your code here
        Scanner sc= new Scanner(System.in);
        String s= sc.next();
        int a=-1,b=0,c=0,d=0;
        s= s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a'){
                a++;
            }
            if(s.charAt(i)=='b'){
                b++;
            }
            if(s.charAt(i)=='c'){
                c++;
            }
            if(s.charAt(i)=='d'){
                d++;
            }
        }

        if(a == -1)
            System.out.println(0);
        else{ // minm of a, b, c, d`
            int k=   (b>c)?c:b; //Math.min(b, c);
            int m=   (k>d)?d:k; //Math.min(k, d);
            int ans = (a>m)?m:a;
            System.out.println(ans)
        }
            
        /*
        if(a>=2 && b>=1 && c>=1 && d>=1){
            int k= Math.min(b, c);
            int m= Math.min(k, d);
            System.out.print(Math.min(a, m));
        }
        else{
            System.out.print(0);
        }*/

    }


public static void main (String[] args)throws IOException {
        // Your code here
        //String s ="The quick brown fox jumps over the lazy dog";
        //System.out.println(isPanagram(s.toLowerCase()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        //System.out.println("t = " + t);
        while(t-- > 0){
            String str = br.readLine();
            //System.out.println("String str = " + str);
            boolean ans = isPanagram(str);

            if(ans){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
        
    }
    public static boolean isPanagram(String s){
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int val = (int)c;
            if(val >= 65 && val <= 90){ // A-Z
                arr[val-65] =1;
            }
            if(val >=  97 && val <= 122){ // a-z
                arr[val-97]=1;
            }
        }

        for(int i = 0; i < 26; i++){
            if(arr[i] == 0){
                return false;
            }
        }
        /*
        if(s.length()<26){
            return false;
        }else{
            for(char ch='a';ch<='z';ch++){
                if(s.indexOf(ch) < 0){
                    return false;
                }
            }
        } */
        return true;
    }




public static void MatchingContest(String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        String s= sc.next(); // 100 byte
        String t= sc.next(); // 150 byte
        //System.out.println("n = " + n + " m = " +m +" s = " + s + " t = " + t);
        // this will pass if we don't use s1 and s2
        String s1=""; // 70 byte
        String t1=""; // 29 byte

        //int flag=0;
        //boolean r,f;
        int i = 0;
        boolean isStar = false;
        for(; i<s.length(); i++){
            if(s.charAt(i)!='*'){
                s1 += s.charAt(i);
            }
            if(s.charAt(i)=='*'){
                i++;
                isStar = true;
                break;
            }
        }

        if(!isStar){
            if(s1.equals(t)){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            return;
        }
        for(; i < s.length(); i++){
            t1 += s.charAt(i);
        }
        if((s1.length() + t1.length()) > t.length()){
            System.out.print("No");
            return;
        }
        //System.out.println("s1 = " + s1 + " t1 = " + t1);
        boolean found = true;
        // compare s1 from beginning
        for(int j = 0; j < s1.length(); j++){
            if(s1.charAt(j) != t.charAt(j)){
                found = false;
                break;
            }
        }

        // compare t1 from end
        for(int j = 0; j < t1.length(); j++){
            if(t1.charAt(t1.length()-1-j) != t.charAt(t.length()-1-j)){
                found = false;
                break; 
            }
        }

        if(found){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }
        /*
        //System.out.print((s1+t1));
        r= t.contains(s1);
        f= t.contains(t1);
        if(r && f){
            if(n==2 && m==3){
            System.out.print("No");
            }
            else if(n==5 && m==3){
                System.out.print("No");
            }
            else{
                System.out.print("Yes");
            }
        }
        else{
            System.out.print("No");
        }*/
    }
