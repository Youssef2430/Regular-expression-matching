import java.util.LinkedList;
import java.util.Scanner;

public class Regularmatch {
    public static boolean isMatch(String s, String p) {
        String comp = "";
        if(p.indexOf( '*' ) == -1 && p.indexOf( '.' ) == -1){
            return s.equals(p);
        }else{
            for(int i = 0;i<p.length();i++){
                if(p.charAt(i) != '*' && p.charAt(i) != '.'){
                    comp = comp +p.charAt(i);
                }else{
                    if(p.charAt(i) == '.'){
                        if(comp.length() != 0){
                            String temp = "";
                            for(int t = 0;t< comp.length();t++){
                                temp = temp + s.charAt(t);
                            }
                            if((temp == comp) == false){
                                return false;
                            }else{
                                temp = "";
                                for(int j = comp.length()-1;j<s.length();j++){
                                    temp = temp + s.charAt(j);
                                }
                                s = temp;
                            }
                        }
                        String temp = "";
                        for(int t = 1; t < s.length(); t++){
                            temp = temp + s.charAt(t);
                        }
                        s = temp;
                        comp = "";
                        
                    }else{
                        if(comp.length() == 0){
                            return true;
                        }else{
                            int oi = 1;
                            while (oi == 1){
                                if(s.indexOf(comp) != 0){
                                    //if(s.charAt(0) != comp.charAt(0)){
                                    //    return false;
                                    //}else{
                                        comp = "";
                                        oi = 2;
                                    //}
                                }
                                if(comp.length() == s.length()){
                                    return true;
                                }
                                String temp = "";
                                for(int y = comp.length();y<s.length();y++){
                                    temp = temp + s.charAt(y);
                                }
                                s = temp;
                                
                                
                            }
                            
                        }
                    }
                }
            }
            if(comp.length() != 0){
                return (comp.equals(s));
            }else{
                return false;
            }
        }
    }
    public static boolean isMatch1(String s, String p){
        LinkedList<String> results = new LinkedList<>();
        String comp = "";
        boolean inside = false;
        boolean add = false;
        boolean first = true;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*' && !add){
                if(first){
                    inside = true;
                    first = false;
                    if(comp != ""){
                        results.add("strict");
                        results.add(comp);
                        comp = "";
                    }
                }else{
                    first = true;
                    inside = false;
                    results.add(comp);
                    comp = "";
                }
            }else if(s.charAt(i) == '/' && inside){
                add = true;
            }else{
                if(add){
                    comp = comp + s.charAt(i);
                    add = false;
                }else if (inside){
                    comp = comp + s.charAt(i);
                }else{
                    comp = comp + s.charAt(i);
                }
            }
        }
        if(comp != ""){
            results.add("strict");
            results.add(comp);
        }


        boolean next = false;
        for(int i = 0; i < results.size();i++){
            if(results.get(i) == "strict"){
                next = true;
            }else if(next){
                boolean last = (i == results.size()-1);
                next = false;
                String comp1 = results.get(i);
                if(p.length() < comp1.length()){
                    return false;
                }
                String comp2 = "";
                String temp = "";
                for(int j = 0;j<p.length();j++){
                    if(j<comp1.length()){
                        comp2 = comp2 + p.charAt(j);
                    }else{
                        temp = temp + p.charAt(j);
                    }
                }
                p = temp;
                if(!comp1.equals(comp2)){
                    return false;
                }
                if(last){
                    return true;
                }
            }else{
                String comp1 = results.get(i);
                boolean last = (i == results.size()-1);
                if(last){
                    for(int k = 0;k < p.length();k++){
                        if(comp1.indexOf((Character.toString(p.charAt(k)))) == -1 ){
                            return false;
                        }
                    }
                    return true;
                }else{
                    int lastchar = 0;
                    String nextstrict = results.get(i+2);
                    for(int k = 0;k < p.length();k++){
                        if(comp1.indexOf((Character.toString(p.charAt(k)))) == -1 ){
                            if(p.charAt(k) != nextstrict.charAt(0)){
                                return false;
                            }else{
                                lastchar = k;
                                break;
                            }
                        }
                    }
                    String temp = "";
                    for(int o = lastchar;o<p.length();o++){
                        temp = temp + p.charAt(o);
                    }
                    p = temp;

                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter your pattern: ");
        String s= sc.nextLine();
        System.out.print("Enter your expression: ");
        String p= sc.nextLine();
        while(!p.trim().equals("Q")){
            if(isMatch1(s, p)){
                System.out.println("The expression matches the pattern !");
            }else{
                System.out.println("The expression DOESN'T matches the pattern !");
            }
            System.out.println("Enter your another expression (or 'Q' to quit ): ");
            p= sc.nextLine();
        }
        sc.close();
        System.out.println("Thank You !!");
    }
}