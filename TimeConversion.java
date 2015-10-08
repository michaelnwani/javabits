public class TimeConversion {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try{
            Scanner in = new Scanner(System.in);
            String originalTime = in.nextLine();
            String[] a = originalTime.split(":");
            String AMPM = a[2].substring(a[2].length()-2, a[2].length());
            
            String hh = a[0];
            String mm = a[1];
            String ss = a[2].substring(0, a[2].length()-2);
            int hhInt = Integer.parseInt(hh);
            
            if (AMPM.equals("PM")){
                if (hhInt < 12){
                   hhInt += 12; 
                }
                
                hh = hhInt + "";
            }
            else{
                if (hhInt == 12){
                    hh = "00";
                } 
            }
            System.out.print(hh+":"+mm+":"+ss);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}