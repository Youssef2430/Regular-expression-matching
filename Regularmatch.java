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

    public static void main(String[] args){
        System.out.println(isMatch(args[0], args[1]));
    }
}